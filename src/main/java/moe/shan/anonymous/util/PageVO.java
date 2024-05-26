package moe.shan.anonymous.util;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageVO<T> {
    public final List<T> content;
    public final PageInfo pageInfo;

    public PageVO(Page<T> page) {
        this.content = page.getContent();
        var pageable = page.getPageable();
        this.pageInfo = new PageInfo(
                page.getTotalElements(),
                pageable.getPageSize(),
                pageable.getPageNumber()
        );

    }

    public static <T> PageVO<T> of(Page<T> page) {
        return new PageVO<>(page);
    }

    public record PageInfo(long total, int perPage, int pageNow) {

    }

}