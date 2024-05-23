package moe.shan.anonymous.service.chronicle;

import moe.shan.anonymous.model.chronicle.Chronicle;
import org.springframework.data.domain.Page;

public interface ChronicleService {
    Page<Chronicle> findAll();
}
