package com.ettiv.docs.domain;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DocRepository extends PagingAndSortingRepository<Doc, Integer> {

    List<Doc> findByName(@Param("name") String name);

}

