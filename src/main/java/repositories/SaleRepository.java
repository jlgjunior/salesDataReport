package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {

}
