package com.bruno.silva.severosdelivery.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

// JPA - Java Persistence API
@Entity
@Table(name= "pedidos")
public class SeverosDeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "pedido")
    private String pedido;


}
