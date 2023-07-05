package com.mpmcorporation.vidfire.controller;

import com.mpmcorporation.vidfire.entity.Video;
import com.mpmcorporation.vidfire.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/video")
@Api("Api de gerenciamento de vídeos")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping
    @ApiOperation("Api para salvar um novo vídeo")
    public ResponseEntity<String> salvar(@RequestParam("arquivo") MultipartFile arquivo, @RequestParam("descricao") String descricao)
            throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(service.salvar(arquivo, descricao));
    }

    @GetMapping("/buscar/{uuid}")
    @ApiOperation("Api para buscar vídeo")
    public ResponseEntity<Video> buscar(@PathVariable("uuid") String uuid)
            throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(service.buscarVideo(uuid));
    }

    @GetMapping("/download/{uuid}")
    @ApiOperation("Api para realizar download de vídeos")
    public ResponseEntity<Resource> download(@PathVariable("uuid") String uuid)
            throws Exception {
        Video video = service.buscarVideo(uuid);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(video.getTipo()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "video; filename=\"" + video.getNome() + "\"")
                .body(new ByteArrayResource(Base64.decodeBase64(video.getVideo())));
    }

    @GetMapping("/free")
    public String retornoFree(){
        return "Este é um endpoint liberado pela nossa API";
    }

    @GetMapping("/auth")
    public String retornoAuth(){
        return "Este é um endpoint que precis ade autenticação";
    }
}
