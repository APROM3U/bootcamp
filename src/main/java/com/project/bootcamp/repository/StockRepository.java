package com.project.bootcamp.repository;

import com.project.bootcamp.model.Stock;
//import com.project.bootcamp.model.dto.StockDTO;
//import jdk.vm.ci.meta.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    @Query("Select stock " +
           "From Stock stock " +
           "Where stock.name = :name and stock.date = :date and stock.id <> :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

    @Query("Select stock " +
            "From Stock stock " +
            "Where stock.date = :date")
    Optional<List<Stock>> findByToday(LocalDate date);
}
