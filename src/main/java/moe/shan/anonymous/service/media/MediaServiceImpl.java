package moe.shan.anonymous.service.media;

import moe.shan.anonymous.model.media.Media;
import moe.shan.anonymous.repository.MediaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {
    private MediaRepository mediaRepository;

    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> findAll(){
        return mediaRepository.findAll();
    }

    public Optional<Media> findById(String id){
        return mediaRepository.findById(id);
    }
}
