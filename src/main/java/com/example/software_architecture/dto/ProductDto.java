package com.example.software_architecture.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
}
