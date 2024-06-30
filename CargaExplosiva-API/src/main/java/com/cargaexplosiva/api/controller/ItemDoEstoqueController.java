package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.*;
import com.cargaexplosiva.api.model.ItemDoEstoque;
import com.cargaexplosiva.api.service.ItemDoEstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("item-do-estoque")
public class ItemDoEstoqueController {

    private final ItemDoEstoqueService itemDoEstoqueService;

    public ItemDoEstoqueController(ItemDoEstoqueService itemDoEstoqueService) {
        this.itemDoEstoqueService = itemDoEstoqueService;
    }

    @PostMapping
    public ResponseEntity<Object> saveItemDoEstoque(@RequestBody @Valid requestSaveItemDoEstoqueDTO itemDoEstoqueDTO) {
        try {
            var item = itemDoEstoqueService.save(itemDoEstoqueDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(item);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar item.");
        }
    }

    @GetMapping("/{id_item}")
    public ResponseEntity<Object> getItem(@PathVariable(value = "id_item") UUID id_item){
        return itemDoEstoqueService.getOne(id_item);
    }

    @GetMapping
    public ResponseEntity<List<responseItemDoEstoqueDTO>> getAllItem(){
        return ResponseEntity.status(HttpStatus.OK).body(itemDoEstoqueService.getAll());
    }

    @PutMapping
    public ResponseEntity<Object> updateItem(@RequestBody @Valid requestUpdateItemDoEstoqueDTO itemDoEstoqueDTO){
        return itemDoEstoqueService.update(itemDoEstoqueDTO);
    }

    @DeleteMapping("/{id_item}")
    public ResponseEntity<Object> deleteItem(@PathVariable(value = "id_item") UUID id_item){
        itemDoEstoqueService.delete(id_item);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
