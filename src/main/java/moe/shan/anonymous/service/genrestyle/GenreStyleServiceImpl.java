package moe.shan.anonymous.service.genrestyle;

import moe.shan.anonymous.model.genrestyle.GenreStyle;
import moe.shan.anonymous.repository.GenreStyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreStyleServiceImpl implements GenreStyleService {
    private GenreStyleRepository genreStyleRepository;

    public GenreStyleServiceImpl(GenreStyleRepository genreStyleRepository) {
        this.genreStyleRepository = genreStyleRepository;
    }

    public List<GenreStyle> findAll(){
        return genreStyleRepository.findAll();
    }

    public Optional<GenreStyle> findById(String id){
        return genreStyleRepository.findById(id);
    }
}
