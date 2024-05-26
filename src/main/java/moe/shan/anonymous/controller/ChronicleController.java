package moe.shan.anonymous.controller;

import moe.shan.anonymous.model.chronicle.Chronicle;
import moe.shan.anonymous.service.chronicle.ChronicleService;
import moe.shan.anonymous.util.PageVO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChronicleController {
    private final ChronicleService chronicleService;

    public ChronicleController(ChronicleService chronicleService) {
        this.chronicleService = chronicleService;
    }

    @GetMapping("/chronicle")
    public ResponseEntity<PageVO<Chronicle>> getAllChronicle(
            @RequestParam(value = "perPage", defaultValue = "10") int perPage,
            @RequestParam(value = "pageNow", defaultValue = "0") int pageNow
    ) {
        return ResponseEntity.ok(chronicleService.findAll(PageRequest.of(pageNow, perPage, Sort.Direction.DESC, "beginYear", "endYear")));
    }

}
