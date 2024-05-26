package moe.shan.anonymous.service.media;

import moe.shan.anonymous.model.media.Media;
import moe.shan.anonymous.util.PageVO;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MediaService {
    PageVO<Media> findAll(Pageable pageable);

    Optional<Media> findById(String id);
}
