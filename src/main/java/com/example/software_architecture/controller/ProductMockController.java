package com.example.software_architecture.controller;

import com.example.software_architecture.data.ProductInMemoryDB;
import com.example.software_architecture.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/standalone/mock")
public class ProductMockController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public void create(@RequestBody ProductDto productDto){
        ProductInMemoryDB.INSTANCE.add(productDto);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody List<ProductDto> findAll(){
        return ProductInMemoryDB.INSTANCE.findAll();
    }

    @RequestMapping(value = "/findById/{productid}", method = RequestMethod.GET)
    public @ResponseBody ProductDto findById(@PathVariable("productid") Integer productId) {
        return ProductInMemoryDB.INSTANCE.findById(productId);
    }

    @RequestMapping(value = "/remove/{productid}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("productid") Integer productId){
        ProductInMemoryDB.INSTANCE.remove(productId);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(@RequestBody ProductDto productDto){
        ProductInMemoryDB.INSTANCE.edit(productDto);
    }
}
