package com.project.ApiPix.Entities;

import com.project.ApiPix.Domain.TipoChave;
import com.project.ApiPix.Domain.TipoConta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name="chavePix")
@Entity(name="chavePix")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class ChavePixJpa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoChave tipoChave;

    private String valorChave;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    private Integer agencia;
    private Integer conta;
    private String nome;
    private String sobrenome;

    private LocalDateTime dataHoraInclusao;

    private LocalDateTime dataHoraInativacao;

}
