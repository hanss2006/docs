package com.ettiv.docs.domain;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UnitRepository extends PagingAndSortingRepository<Unit, Integer> {

    List<Unit> findByName(@Param("name") String name);

}
