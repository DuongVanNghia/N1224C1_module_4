package com.n1224C1.techzen.dto.page;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PageCustom<T>{
    int page;
    int size;
    int totalPage;
    int totalElement;
    public  PageCustom(Page<T> page) {
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalPage = page.getTotalPages();
        this.totalElement = page.getNumberOfElements();
    }
}
