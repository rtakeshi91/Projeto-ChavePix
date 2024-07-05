package com.project.ApiPix.Record;

import com.project.ApiPix.Domain.TipoChave;
import com.project.ApiPix.Domain.TipoConta;

public record ChavePixDto(TipoChave tipoChave, String valorChave, TipoConta tipoConta, Integer agencia, Integer conta, String nome, String sobrenome) {
}
