package moe.shan.anonymous.controller;

import moe.shan.anonymous.model.media.Media;
import moe.shan.anonymous.service.media.MediaService;
import moe.shan.anonymous.util.PageVO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MediaController {
    private final MediaService mediaService;


    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping("media")
    public ResponseEntity<PageVO<Media>> media(
            @RequestParam(value = "perPage", defaultValue = "10") int perPage,
            @RequestParam(value = "pageNow", defaultValue = "0") int pageNow
    ) {
        return ResponseEntity.ok(mediaService.findAll(PageRequest.of(pageNow, perPage, Sort.Direction.DESC, "hotIndex")));
    }

    @GetMapping("/media/{id}")
    public ResponseEntity<Media> getMedia(@PathVariable String id) {
        Optional<Media> mediaOptional = mediaService.findById(id);
        return mediaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
