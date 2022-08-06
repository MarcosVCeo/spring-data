package br.com.marcosceola.orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String endereco;

    @ManyToMany(mappedBy = "unidadesTrabalho", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios = new ArrayList<>();

    public UnidadeTrabalho() {

    }

    public UnidadeTrabalho(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.nome = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }
}
