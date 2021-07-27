package org.tk.spring.jpa3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig({Jpa3JavaConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Stock3CrudPagingRepositoryTest {


    @Autowired
    private Stock3CrudPagingService service;

    @Test
    void getAllStock() {
        List<Stock3Entity> stockList = service.getAll();
        stockList.forEach(System.out::println);
    }

    @Test
    void getAllStockSorted() {
        List<Stock3Entity> stockList = service.getAllSorted(Sort.by(Sort.Order.desc("id")));
        stockList.forEach(System.out::println);
    }

    //TODO still results not printed
    @Test
    void getAllStockPagination() {
        Page<Stock3Entity> page = service.getAllPaginated(PageRequest.of(4, 1));
        System.out.println("Total ELements : " + page.getTotalElements());
        System.out.println("Total Pages : " + page.getTotalPages());
        page.get().forEach(System.out::println);
    }

    @Test
    void saveWithTx() {
        Stock3Entity entity = new Stock3Entity();
        entity.setId("NSE:MINE");
        entity.setName("MY COMPANY");
        entity.setPrice(20.5);
        service.save(entity);

        List<Stock3Entity> stockList = service.getAll();
        stockList.forEach(System.out::println);
    }
}
