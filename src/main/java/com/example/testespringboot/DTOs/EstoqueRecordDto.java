package com.example.testespringboot.DTOs;

import com.example.testespringboot.Enum.TamanhoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record EstoqueRecordDto(@NotBlank String nome, @NotNull BigDecimal preco, @NotNull int quantidade, @NotNull TamanhoEnum tamanho) {

}
