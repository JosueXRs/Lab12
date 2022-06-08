package com.tecsup.petclinic.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Owner;

/**
 * 
 * @author vanessa
 *
 */
@Repository
public interface OwnerRepository 
	extends CrudRepository<Owner, Long> {

	List<Owner> findByFirstName(String first_name);

	List<Owner> findByLastName(String last_name);

	List<Owner> findByTelephone(String telephone);

}