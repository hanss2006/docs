package com.ettiv.docs.domain;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface UnitRepository extends PagingAndSortingRepository<Unit, Long> {

    List<Unit> findByName(@Param("name") String name);

}
