package br.com.marcosceola.specification;

import br.com.marcosceola.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, citeriaQuery, criteriaBuider) ->
                criteriaBuider.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Funcionario> cpf(String cpf) {
        return (root, citeriaQuery, criteriaBuider) ->
                criteriaBuider.equal(root.get("cpf"), cpf);
    }

    public static Specification<Funcionario> salario(BigDecimal salario) {
        return (root, citeriaQuery, criteriaBuider) ->
                criteriaBuider.greaterThanOrEqualTo(root.get("salario"), salario);
    }

}
