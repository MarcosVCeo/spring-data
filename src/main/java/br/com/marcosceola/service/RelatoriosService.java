package br.com.marcosceola.service;

import br.com.marcosceola.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private boolean sistema = true;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void inicial(Scanner scanner) {

        var src = new Scanner(System.in);

        while (sistema) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Qual ação você quer executar");
            System.out.println("0 = Sair");
            System.out.println("1 = Busca funcionario nome");
            System.out.println("2 = Buscar funcionario por nome, salario minimo e data de contratação");
            System.out.println("3 = Projeção de fucionarios");

            var acao = src.nextInt();

            switch (acao) {
                case 0 -> sistema = false;
                case 1 -> buscaFuncionarioPorNome(src);
                case 2 -> buscaFuncionarioPorNomeSalario(src);
                case 3 -> projecaoFuncionarios();
            }
        }

        src.close();
    }

    private void buscaFuncionarioPorNome(Scanner scanner) {
        System.out.println("Insira o nome desejado");
        var nome = scanner.next();
        var funcionarios = funcionarioRepository.findByNome(nome);

        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioPorNomeSalario(Scanner scanner) {
        System.out.println("Digite o nome");
        var nome = scanner.next();

        System.out.println("Digite o salario");
        var salario = BigDecimal.valueOf(scanner.nextDouble());

        System.out.println("Digite a data");

        var datetext = scanner.next();
        var data = LocalDate.parse(datetext);

        var funcionarios = funcionarioRepository
                .findNomeDataContratacaoSalarioMaior(nome, salario, data);

        if (funcionarios.isEmpty()) {
            throw new RuntimeException("Nenhum funcionário foi encontrado");
        }

        funcionarios.forEach(System.out::println);
    }

    private void projecaoFuncionarios() {

        funcionarioRepository.projecaoFuncionarios()
                .forEach(f -> System.out.println(
                        "Id = " + f.getId() +
                        " Nome = " + f.getNome() +
                        " Salario = " + f.getSalario()));
    }
}
