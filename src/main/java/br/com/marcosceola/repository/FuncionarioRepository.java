package br.com.marcosceola.repository;

import br.com.marcosceola.orm.Funcionario;
import br.com.marcosceola.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
        JpaSpecificationExecutor<Funcionario> {

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, BigDecimal salario, Date dataContratacao);

    @Query(value = "SELECT f " +
           "FROM Funcionario AS f " +
           "WHERE " +
           "    f.nome = :nome " +
           "    AND f.salario >= :salario " +
           "    AND f.dataContratacao = :dataContratacao")
    List<Funcionario> findNomeDataContratacaoSalarioMaior(String nome, BigDecimal salario, LocalDate dataContratacao);

    @Query(value = "SELECT " +
           "    f.id, " +
           "    f.nome, " +
           "    f.salario " +
           "FROM funcionarios AS f ", nativeQuery = true)
    List<FuncionarioProjecao> projecaoFuncionarios();


}
