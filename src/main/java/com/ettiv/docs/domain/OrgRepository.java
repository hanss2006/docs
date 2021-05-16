package com.ettiv.docs.domain;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface OrgRepository extends PagingAndSortingRepository<Org, Integer> {

    List<Org> findByName(@Param("name") String name);

}

