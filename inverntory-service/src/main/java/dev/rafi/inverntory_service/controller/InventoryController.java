package dev.rafi.inverntory_service.controller;

import dev.rafi.inverntory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")

public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
