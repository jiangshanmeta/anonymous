package moe.shan.anonymous.controller;

import moe.shan.anonymous.model.genrestyle.GenreStyle;
import moe.shan.anonymous.service.genrestyle.GenreStyleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreStyleController {
    private final GenreStyleService genreStyleService;

    public GenreStyleController(GenreStyleService genreStyleService) {
        this.genreStyleService = genreStyleService;
    }

    @GetMapping("/genreStyle")
    public ResponseEntity<List<GenreStyle>> getAllGenreStyle() {
        var list = genreStyleService.findAll();
        System.out.printf("======%d=====", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/genreStyle/{id}")
    public ResponseEntity<GenreStyle> getGenreStyleById(@PathVariable String id) {
        var result = genreStyleService.findById(id);
        System.out.println(result);

        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
