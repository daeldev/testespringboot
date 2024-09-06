package com.example.testespringboot.controller;

import com.example.testespringboot.DTOs.EstoqueRecordDto;
import com.example.testespringboot.model.EstoqueModel;
import com.example.testespringboot.repository.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*api rest:
    POST - Salva dados
    GET - Lista dados
    DELETE - Deleta dados
    PUT - Atualiza dados
*/

//Mapeia um estoque controller que vai ser uma api rest
@RestController
public class EstoqueController {

    @Autowired
    EstoqueRepository estoqueRepository;

    @PostMapping("/estoque")
    public ResponseEntity<EstoqueModel> salvarEstoque(@RequestBody @Valid EstoqueRecordDto estoqueRecordDto){
        //Instancia o estoqueModel
        var estoqueModel = new EstoqueModel();
        BeanUtils.copyProperties(estoqueRecordDto, estoqueModel);
//        retorna
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueRepository.save(estoqueModel));
    }
}
