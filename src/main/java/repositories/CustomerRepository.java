package repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import models.Customer;


@Repository
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}