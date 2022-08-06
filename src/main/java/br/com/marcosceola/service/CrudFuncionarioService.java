package br.com.marcosceola.service;

import br.com.marcosceola.orm.Funcionario;
import br.com.marcosceola.repository.FuncionarioRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Scanner;

@Service
public class CrudFuncionarioService extends AbstractCrud {

    public CrudFuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }

    private void inicializar() {
        for (int i = 0; i < 10; i++) {
            var funcionario = new Funcionario(String.valueOf(i), BigDecimal.TEN);

            repository.save(funcionario);
        }
    }

    @Override
    protected void salvar(Scanner scanner) {
        System.out.println("Nome do funcionario");
        var nome = scanner.next();
        System.out.println("Salario do funcionário (0,00)");
        var salario = BigDecimal.valueOf(scanner.nextDouble());

        var funcionario = new Funcionario(nome, salario);

        repository.save(funcionario);
        System.out.println("Salvo");
    }

    @Override
    protected void atualizar(Scanner scanner) {
        System.out.println("Id");
        var id = scanner.nextInt();

        System.out.println("Novo nome");
        var novoNome = scanner.next();

        System.out.println("Novo salario");
        var novoSalario = BigDecimal.valueOf(scanner.nextDouble());

        var funcionario = new Funcionario(novoNome, novoSalario);
        funcionario.setId(id);

        repository.save(funcionario);
        System.out.println("Atualizado");
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
        inicializar();
        System.out.println("Qual pagina deseja visualizar?");
        var pagina = scanner.nextInt() + 1;

        var page = repository.findAll(PageRequest.of(
                pagina,
                5,
                Sort.by(Sort.Direction.DESC, "nome")));

        System.out.println("Total paginas = " + page.getTotalPages());
        System.out.println("Pagina Atual = " + page.getNumber());

        page.forEach(System.out::println);
    }
}
