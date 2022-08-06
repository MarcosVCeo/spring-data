package br.com.marcosceola.service;

import br.com.marcosceola.orm.UnidadeTrabalho;
import br.com.marcosceola.repository.CrudUnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService extends AbstractCrud {

    public CrudUnidadeTrabalhoService(CrudUnidadeTrabalhoRepository repository) {
        super(repository);
    }

    @Override
    protected void salvar(Scanner scanner) {
        System.out.println("Digite o nome da unidade");
        var nome = scanner.next();

        System.out.println("Digite o endereco");
        var endereco = scanner.next();

        var unidadeTrabalho = new UnidadeTrabalho(nome, endereco);
        repository.save(unidadeTrabalho);
        System.out.println("Salvo");
    }

    @Override
    protected void atualizar(Scanner scanner) {
        System.out.println("Digite o id");
        var id = scanner.nextInt();

        System.out.println("Digite o nome da unidade");
        var nome = scanner.next();

        System.out.println("Digite o endereco");
        var endereco = scanner.next();

        var unidadeTrabalho = new UnidadeTrabalho(nome, endereco);
        unidadeTrabalho.setId(id);

        repository.save(unidadeTrabalho);
        System.out.println("Alterado");
    }

    @Override
    protected void deletar(Scanner scanner) {
        System.out.println("Id");
        var id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado");
    }

    @Override
    protected void listarTodos(Scanner scanner) {
        var unidades = (ArrayList<UnidadeTrabalho>) repository.findAll();

        unidades.sort(Comparator.comparing(UnidadeTrabalho::getId));
        unidades.forEach(System.out::println);
    }
}
