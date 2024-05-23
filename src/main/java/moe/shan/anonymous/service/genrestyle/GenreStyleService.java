package moe.shan.anonymous.service.genrestyle;

import moe.shan.anonymous.model.genrestyle.GenreStyle;

import java.util.List;
import java.util.Optional;

public interface GenreStyleService {
    List<GenreStyle> findAll();
    Optional<GenreStyle> findById(String id);
}
