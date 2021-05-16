package com.ettiv.docs.domain;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "types", path = "types")
public interface TypeDocRepository extends PagingAndSortingRepository<TypeDoc, Integer> {

    List<TypeDoc> findByName(@Param("name") String name);

}