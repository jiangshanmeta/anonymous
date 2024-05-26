package moe.shan.anonymous.service.media;

import moe.shan.anonymous.model.media.Media;
import moe.shan.anonymous.repository.MediaRepository;
import moe.shan.anonymous.util.PageVO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;

    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public PageVO<Media> findAll(Pageable pageable) {
        return PageVO.of(mediaRepository.findAll(pageable));
    }

    public Optional<Media> findById(String id) {
        return mediaRepository.findById(id);
    }
}
