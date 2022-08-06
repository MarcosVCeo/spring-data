package br.com.marcosceola.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Scanner;

public abstract class AbstractCrud {

    private boolean system = true;
    protected PagingAndSortingRepository repository;

    public AbstractCrud(PagingAndSortingRepository repository) {
        this.repository = repository;
    }

    public final void inicial(Scanner scanner) {
        while (system) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Qual operação deseja fazer ?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Deletar");
            System.out.println("5 - Procurar por Id");

            var acao = scanner.nextInt();

            switch (acao) {
                case 0 -> system = false;
                case 1 -> salvar(scanner);
                case 2 -> atualizar(scanner);
                case 3 -> listarTodos(scanner);
                case 4 -> deletar(scanner);
            }
        }
    }

    abstract void salvar(Scanner scanner);

    abstract void atualizar(Scanner scanner);

    abstract void deletar(Scanner scanner);

    abstract void listarTodos(Scanner scanner);
}
