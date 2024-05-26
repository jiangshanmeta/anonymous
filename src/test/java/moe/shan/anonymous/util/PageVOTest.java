package moe.shan.anonymous.util;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageVOTest {

    @Test
    void of() {
        PageVO<String> pageVO = PageVO.of(
                new PageImpl<>(
                        List.of("First", "Second"),
                        PageRequest.of(3, 2),
                        123
                )
        );

        assertEquals(List.of("First", "Second"), pageVO.content);
        assertEquals(123, pageVO.pageInfo.total());
        assertEquals(3, pageVO.pageInfo.pageNow());
        assertEquals(2, pageVO.pageInfo.perPage());

    }
}