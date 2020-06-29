package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import models.Sale;

@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public interface SaleRepository extends CrudRepository<Sale, Long> {

}
