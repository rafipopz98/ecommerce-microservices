package dev.rafi.inverntory_service.service;

import dev.rafi.inverntory_service.model.Inventory;
import dev.rafi.inverntory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

@RequiredArgsConstructor
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        Optional<Inventory> checkStock = inventoryRepository.findBySkuCode(skuCode);
        return checkStock.isPresent();
    }
}
