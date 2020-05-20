package net.mstiller.navigreat;

import java.util.List;

import net.mstiller.navigreat.objects.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// allows CORS policy
@CrossOrigin(allowedHeaders={"*"})
// defines the REST path; e.g. "localhost:8080/customers"
@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	
	List<Customer> findByFirstName(@Param("name") String name);
	
	List<Customer> findByLastName(@Param("name") String name);
	
}