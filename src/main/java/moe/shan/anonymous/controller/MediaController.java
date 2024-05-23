package moe.shan.anonymous.controller;

import moe.shan.anonymous.model.media.Media;
import moe.shan.anonymous.service.media.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MediaController {
    private MediaService mediaService;


    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping("media")
    public ResponseEntity<List<Media>> media(){
        return ResponseEntity.ok(mediaService.findAll() );
    }

    @GetMapping("/media/{id}")
    public ResponseEntity<Media> getMedia(@PathVariable String id){
        Optional<Media> mediaOptional = mediaService.findById(id);
        return mediaOptional.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }


}
