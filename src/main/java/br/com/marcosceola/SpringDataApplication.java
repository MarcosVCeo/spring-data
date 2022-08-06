package br.com.marcosceola;

import br.com.marcosceola.service.CrudCargoService;
import br.com.marcosceola.service.CrudFuncionarioService;
import br.com.marcosceola.service.CrudUnidadeTrabalhoService;
import br.com.marcosceola.service.RelatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private boolean sistema = true;

    @Autowired
    public CrudCargoService cargoService;

    @Autowired
    public CrudFuncionarioService funcionarioService;

    @Autowired
    public CrudUnidadeTrabalhoService unidadesTrabalhoService;

    @Autowired
    public RelatoriosService relatoriosService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        var src = new Scanner(System.in);

        while (sistema) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Qual ação você quer executar");
            System.out.println("0 = Sair");
            System.out.println("1 = Cargo");
            System.out.println("2 = Funcionario");
            System.out.println("3 = Unidade Trabalho");
            System.out.println("4 = Relatorios");

            var acao = src.nextInt();

            switch (acao) {
                case 0 -> sistema = false;
                case 1 -> cargoService.inicial(src);
                case 2 -> funcionarioService.inicial(src);
                case 3 -> unidadesTrabalhoService.inicial(src);
                case 4 -> relatoriosService.inicial(src);
            }
        }

        src.close();
    }
}
