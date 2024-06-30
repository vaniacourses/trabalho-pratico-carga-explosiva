package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveItemDoEstoqueDTO;

import com.cargaexplosiva.api.dto.requestUpdateItemDoEstoqueDTO;
import com.cargaexplosiva.api.dto.responseItemDoEstoqueDTO;
import com.cargaexplosiva.api.model.Estoque;
import com.cargaexplosiva.api.model.ItemDoEstoque;
import com.cargaexplosiva.api.repository.EstoqueRepository;
import com.cargaexplosiva.api.repository.ItemDoEstoqueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        var estoque = new Estoque();
        BeanUtils.copyProperties(itemDoEstoqueDTO, itemDoEstoque);
        BeanUtils.copyProperties(itemDoEstoqueDTO,estoque);
        itemDoEstoque.setEstoque(estoque);
        estoque.setItemDoEstoque(itemDoEstoque);
        itemDoEstoque = itemDoEstoqueRepository.save(itemDoEstoque);

        return new responseItemDoEstoqueDTO(itemDoEstoque);
    }

    public ResponseEntity<Object> getOne(UUID id) {
        Optional<ItemDoEstoque> itemDoEstoque = itemDoEstoqueRepository.findById(id);
        if(itemDoEstoque.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("itemDoEstoque não encontrado.");
        }
        responseItemDoEstoqueDTO itemDoEstoqueDTO = new responseItemDoEstoqueDTO(itemDoEstoque.get());
        return ResponseEntity.status(HttpStatus.OK).body(itemDoEstoqueDTO);
    }

    public List<responseItemDoEstoqueDTO> getAll(){
        var items = itemDoEstoqueRepository.findAll();
        List<responseItemDoEstoqueDTO> response = new ArrayList<>();
        items.forEach(e -> response.add(new responseItemDoEstoqueDTO(e)));
        return response;

    }

    public ResponseEntity<Object> update(requestUpdateItemDoEstoqueDTO itemDoEstoqueDTO){
        Optional<ItemDoEstoque> itemDoEstoque = itemDoEstoqueRepository.findById(itemDoEstoqueDTO.id_item());
        if (itemDoEstoque.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("itemDoEstoque não encontrado.");
        }
        var itemDoEstoqueModel = itemDoEstoque.get();
        BeanUtils.copyProperties(itemDoEstoqueDTO, itemDoEstoqueModel);
        BeanUtils.copyProperties(itemDoEstoqueDTO,itemDoEstoqueModel.getEstoque());
        itemDoEstoqueRepository.save(itemDoEstoqueModel);
        return ResponseEntity.status(HttpStatus.OK).body(new responseItemDoEstoqueDTO(itemDoEstoqueModel));
    }

    public void delete(UUID id) {
        itemDoEstoqueRepository.deleteById(id);
    }
}
