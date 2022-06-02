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

	List<Owner> findByFirst_name(String first_name);

	List<Owner> findByLast_name(String last_name);

	List<Owner> findByTelephone(String telephone);

	Iterable<Owner> findAll();
		
}