package br.com.marcosceola.repository;

import br.com.marcosceola.orm.UnidadeTrabalho;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudUnidadeTrabalhoRepository extends PagingAndSortingRepository<UnidadeTrabalho, Integer> {
}
