package br.com.marcosceola.repository;

import br.com.marcosceola.orm.Cargo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends PagingAndSortingRepository<Cargo, Integer> {

}
