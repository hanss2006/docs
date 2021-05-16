package com.ettiv.docs.user;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByEmail(@Param("email") String email);
    List<User> findByLastName(@Param("lastName") String lastName);
}
