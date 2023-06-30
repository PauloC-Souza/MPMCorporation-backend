package com.mpmcorporation.vidfire.controller;

import com.mpmcorporation.vidfire.entity.Video;
import com.mpmcorporation.vidfire.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestParam("arquivo") MultipartFile arquivo, @RequestParam("descricao") String descricao)
            throws ExecutionException, InterruptedException {
        return ok(service.salvar(arquivo, descricao));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Video> buscar(@PathVariable("uuid") String uuid)
            throws ExecutionException, InterruptedException {
        return ok(service.BuscarVideo(uuid));
    }
}
