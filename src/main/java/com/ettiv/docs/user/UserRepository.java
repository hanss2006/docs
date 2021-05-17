package com.ettiv.docs.user;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByEmail(@Param("email") String email);
    List<User> findByLastName(@Param("lastName") String lastName);

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Override
    void delete(User user);

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Override
    void deleteAll(Iterable<? extends User> users);

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Override
    void deleteAll();

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Override
    User save(User s);
}
