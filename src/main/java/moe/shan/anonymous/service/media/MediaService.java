package moe.shan.anonymous.service.media;

import moe.shan.anonymous.model.media.Media;

import java.util.List;
import java.util.Optional;

public interface MediaService {
    List<Media> findAll();
    Optional<Media> findById(String id);
}
