package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveItemDoEstoqueDTO;

import com.cargaexplosiva.api.dto.requestUpdateItemDoEstoqueDTO;
import com.cargaexplosiva.api.dto.responseItemDoEstoqueDTO;
import com.cargaexplosiva.api.model.ItemDoEstoque;
import com.cargaexplosiva.api.repository.ItemDoEstoqueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ItemDoEstoqueService {

    final ItemDoEstoqueRepository itemDoEstoqueRepository;

    public ItemDoEstoqueService(ItemDoEstoqueRepository itemDoEstoqueRepository) {
        this.itemDoEstoqueRepository = itemDoEstoqueRepository;
    }

    public Object save(requestSaveItemDoEstoqueDTO itemDoEstoqueDTO){
        var itemDoEstoque = new ItemDoEstoque();
        BeanUtils.copyProperties(itemDoEstoqueDTO, itemDoEstoque);
        itemDoEstoque = itemDoEstoqueRepository.save(itemDoEstoque);
        return new responseItemDoEstoqueDTO(itemDoEstoque);
    }

    public ResponseEntity<Object> getOne(UUID id) {
        var itemDoEstoque = itemDoEstoqueRepository.findById(id);
        return itemDoEstoque.<ResponseEntity<Object>>
                        map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("itemDoEstoque não encontrado."));
    }

    public List<ItemDoEstoque> getAll(){
        return itemDoEstoqueRepository.findAll();

    }

    public ResponseEntity<Object> update(requestUpdateItemDoEstoqueDTO itemDoEstoqueDTO){
        Optional<ItemDoEstoque> itemDoEstoque = itemDoEstoqueRepository.findById(itemDoEstoqueDTO.id_item());
        if (itemDoEstoque.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("itemDoEstoque não encontrado.");
        }
        var itemDoEstoqueModel = itemDoEstoque.get();
        BeanUtils.copyProperties(itemDoEstoqueDTO, itemDoEstoqueModel);
        return ResponseEntity.status(HttpStatus.OK).body(itemDoEstoqueRepository.save(itemDoEstoqueModel));
    }

    public void delete(UUID id) {
        itemDoEstoqueRepository.deleteById(id);
    }
}
