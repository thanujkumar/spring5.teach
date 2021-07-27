package org.tk.spring.jpa3;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock3CrudPagingRepository extends PagingAndSortingRepository<Stock3Entity, String> {
    //provides two extra methods in addition to crud repository
    // findAll(Sort) and findAll(Pageable)
}
