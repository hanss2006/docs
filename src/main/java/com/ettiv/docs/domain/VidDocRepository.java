package com.ettiv.docs.domain;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vid", path = "vid")
public interface VidDocRepository extends PagingAndSortingRepository<VidDoc, Integer> {

    List<VidDoc> findByName(@Param("name") String name);

}

