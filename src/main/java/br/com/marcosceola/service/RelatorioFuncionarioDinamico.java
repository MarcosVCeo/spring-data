package br.com.marcosceola.service;

import br.com.marcosceola.repository.FuncionarioRepository;
import br.com.marcosceola.specification.SpecificationFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.Scanner;

public class RelatorioFuncionarioDinamico {

    @Autowired
    FuncionarioRepository repository;


    public void inicial(Scanner scanner) {
        System.out.println("Nome: ");
        var nome = scanner.next();

        repository
                .findAll(Specification.where(SpecificationFuncionario.nome(nome)))
                .forEach(System.out::println);

    }
}
