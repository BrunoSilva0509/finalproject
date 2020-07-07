package com.bruno.silva.severosdelivery.controller;

import com.bruno.silva.severosdelivery.model.SeverosDeliveryEntity;
import com.bruno.silva.severosdelivery.repository.SeverosDeliveryRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class SeverosDeliveryController {  //classe controladora


    @Autowired
    private SeverosDeliveryRepository severosDeliveryRepository;

    @GetMapping
    public ResponseEntity<List<SeverosDeliveryEntity>> findAll (){  // get
        return new ResponseEntity<List<SeverosDeliveryEntity>>(
                (List<SeverosDeliveryEntity>) this.severosDeliveryRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);//error 404
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<SeverosDeliveryEntity> findById(@PathVariable ("id") Long id) {
        if(this.severosDeliveryRepository.findById(id).isPresent()){
            return new ResponseEntity<SeverosDeliveryEntity>(
                    this.severosDeliveryRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<SeverosDeliveryEntity>(HttpStatus.NOT_FOUND);
    }




    public ResponseEntity<SeverosDeliveryEntity> cadastrar (@RequestBody SeverosDeliveryEntity funcionarioEntity) {
        return new ResponseEntity<SeverosDeliveryEntity> (
                this.severosDeliveryRepository.save(funcionarioEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<SeverosDeliveryEntity> atualizar (@PathVariable("id") long id,
                                                        @RequestBody SeverosDeliveryEntity funcionarioEntity) throws Exception {

        if(id == 0 || !this.severosDeliveryRepository.existsById(id)){
            throw  new Exception("Código não encontrado ou inexistente!");

        }
        return new ResponseEntity<SeverosDeliveryEntity>(
                this.severosDeliveryRepository.save(funcionarioEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    // criando o método para deletar...

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SeverosDeliveryEntity> deletar (@PathVariable("id") long id ){
        this.severosDeliveryRepository.deleteById(id);
        return new ResponseEntity<SeverosDeliveryEntity>(new HttpHeaders(), HttpStatus.OK);
    }

}

