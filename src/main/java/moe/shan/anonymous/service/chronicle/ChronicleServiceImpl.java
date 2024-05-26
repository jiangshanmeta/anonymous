package moe.shan.anonymous.service.chronicle;

import moe.shan.anonymous.model.chronicle.Chronicle;
import moe.shan.anonymous.repository.ChronicleRepository;
import moe.shan.anonymous.util.PageVO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChronicleServiceImpl implements ChronicleService {

    private final ChronicleRepository chronicleRepository;

    public ChronicleServiceImpl(ChronicleRepository chronicleRepository) {
        this.chronicleRepository = chronicleRepository;
    }

    @Override
    public PageVO<Chronicle> findAll(Pageable pageable) {
        return PageVO.of(chronicleRepository.findAll(pageable));
    }
}
