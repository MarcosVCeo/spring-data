package br.com.marcosceola.service;

import br.com.marcosceola.orm.Cargo;
import br.com.marcosceola.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrudCargoService extends AbstractCrud {

    public CrudCargoService(CargoRepository cargoRepository) {
        super(cargoRepository);
    }

    protected void salvar(Scanner scanner) {
        System.out.println("Descricao do cargo");
        var descricao = scanner.next();
        var cargo = new Cargo(descricao);
        repository.save(cargo);
        System.out.println("Salvo");
    }

    protected void atualizar(Scanner scanner) {
        System.out.println("Id");
        var id = scanner.nextInt();
        System.out.println("Descricao do Cargo");
        var descricao = scanner.next();

        var cargo = new Cargo(descricao);
        cargo.setId(id);
        repository.save(cargo);
        System.out.println("Atualizado");
    }

    protected void listarTodos(Scanner scanner) {
        var cargos = repository.findAll();
        cargos.forEach(System.out::println);
    }

    protected void deletar(Scanner scanner) {
        System.out.println("Id");
        var id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado");
    }
}
