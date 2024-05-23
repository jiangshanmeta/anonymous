package moe.shan.anonymous.service.chronicle;

import moe.shan.anonymous.model.chronicle.Chronicle;
import moe.shan.anonymous.repository.ChronicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ChronicleServiceImpl implements ChronicleService {

    private ChronicleRepository chronicleRepository;

    public ChronicleServiceImpl(ChronicleRepository chronicleRepository){
        this.chronicleRepository = chronicleRepository;
    }

    @Override
    public Page<Chronicle> findAll() {
        return chronicleRepository.findAll(PageRequest.of(0,10));
    }
}
