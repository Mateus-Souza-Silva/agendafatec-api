package br.com.projetoagendafatec.agendafatecapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 380, nullable = false)
    private String nome;

    @Column(length = 300, nullable = false)
    private String email;

    @Column
    private Boolean favorito;
}