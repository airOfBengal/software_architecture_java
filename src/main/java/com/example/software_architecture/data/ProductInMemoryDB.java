package com.example.software_architecture.data;

import com.example.software_architecture.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public enum ProductInMemoryDB {
    INSTANCE;

    private static List<ProductDto> productDtoList = new ArrayList<>();
    private static Integer lastId = 0;


    public Integer getId(){
        return ++lastId;
    }


    public void add(ProductDto productDto){
        productDto.setId(getId());
        productDtoList.add(productDto);
    }

    public List<ProductDto> findAll(){
        return productDtoList;
    }

    public ProductDto findById(Integer id){
        for(ProductDto dto: productDtoList){
            if (dto.getId() == id) return dto;
        }

        return null;
    }

    public void remove(Integer id){
        ProductDto toRemove = null;
        for(ProductDto dto: productDtoList){
            if (dto.getId() == id){
                toRemove = dto;
                break;
            }
        }

        if (toRemove != null){
            productDtoList.remove(toRemove);
        }
    }

    public void edit(ProductDto productDto){
        for (ProductDto dto: productDtoList){
            if (dto.getId() == productDto.getId()){
                dto.setName(productDto.getName());
            }
        }
    }
}
