package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

/**
 * 
 * @author vanessa
 *
 */

public interface OwnerService {

	Owner create(Owner owner);

	Owner update(Owner owner);

	void delete(Long id) throws OwnerNotFoundException;

	Owner findById(long id) throws OwnerNotFoundException;

	List<Owner> findByFirstName(String first_name);

	List<Owner> findByLastName(String last_name);

	List<Owner> findByTelephone(String telephone);

	Iterable<Owner> findAll();
		
}