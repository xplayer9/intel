package com.example.spring.repository;

import com.example.spring.dto.MyDto;
import com.example.spring.dto.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbRep extends JpaRepository<StockDTO, Long> {
    //List<StockDTO> findBySymbol(String sym);
}
