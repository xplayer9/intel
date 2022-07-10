package com.example.spring.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="`stocktable`")
public class StockDTO {

    //@Column(name="name")
    //String name;
    @Column(name="stock")
    String stock;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
}
