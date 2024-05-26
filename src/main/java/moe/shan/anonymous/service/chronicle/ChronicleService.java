package moe.shan.anonymous.service.chronicle;

import moe.shan.anonymous.model.chronicle.Chronicle;
import moe.shan.anonymous.util.PageVO;
import org.springframework.data.domain.Pageable;

public interface ChronicleService {
    PageVO<Chronicle> findAll(Pageable pageable);
}
