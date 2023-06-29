package com.mpmcorporation.vidfire.controller;

import com.mpmcorporation.vidfire.entity.Video;
import com.mpmcorporation.vidfire.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping
    public String salvar(@RequestBody Video video)
            throws ExecutionException, InterruptedException {
        return service.salvar(video);
    }

    @GetMapping("/{nome}")
    public Video buscar(@PathVariable("nome") String nome)
            throws ExecutionException, InterruptedException {
        return service.BuscarVideo(nome);
    }
}
