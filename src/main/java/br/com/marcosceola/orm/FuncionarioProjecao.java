package br.com.marcosceola.orm;

import java.math.BigDecimal;

public interface FuncionarioProjecao {

    Integer getId();

    String getNome();

    BigDecimal getSalario();
}
