package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
	private OwnerService ownerService;

	/**
	 * 
	 */
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String FNAME = "George";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
		logger.info("" + owner);

		assertThat(owner.getFirst_name(), is(FNAME));

	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByFirstName() {

		String FIND_FNAME = "George";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByFirst_name(FIND_FNAME);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByLastName() {

		String FIND_LNAME = "Coleman";
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findByLast_name(FIND_LNAME);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByTelephone() {

		String FIND_TELEPHONE = "6085552654";
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findByTelephone(FIND_TELEPHONE);

		assertThat(owners.size(), is(SIZE_EXPECTED));
		
	}

		
	
	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreateOwner() {

		String OWNER_FNAME = "Victor";
		String OWNER_LNAME = "Rodriguez";
		String OWNER_TELEPHONE = "9632587410";

		Owner owner = new Owner(OWNER_FNAME, OWNER_LNAME,OWNER_TELEPHONE);
		
		Owner ownerCreated = ownerService.create(owner);
		
		logger.info("OWNER CREATED :" + ownerCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(ownerCreated.getId()      , notNullValue());
		assertThat(ownerCreated.getFirst_name()    , is(OWNER_FNAME));
		assertThat(ownerCreated.getLast_name() , is(OWNER_LNAME));
		assertThat(ownerCreated.getTelephone()  , is(OWNER_TELEPHONE));

	}

	
	/**
	 * 
	 */
	@Test
	public void testUpdateOwner() {

		String OWNER_FNAME = "George";
		String OWNER_LNAME = "Franklin";
		String OWNER_TELEPHONE = "6085551023";
		long create_id = -1;

		String UP_OWNER_FNAME = "George2";
		String UP_OWNER_LNAME = "Franklin2";
		String UP_OWNER_TELEPHONE = "6085551000";

		Owner owner = new Owner(OWNER_FNAME, OWNER_LNAME, OWNER_TELEPHONE);

		// Create record
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		logger.info(">>" + ownerCreated);

		create_id = ownerCreated.getId();

		// Prepare data for update
		ownerCreated.setFirst_name(UP_OWNER_FNAME);
		ownerCreated.setLast_name(UP_OWNER_LNAME);
		ownerCreated.setTelephone(UP_OWNER_TELEPHONE);

		// Execute update
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);

		//        ACTUAL       EXPECTED
		assertThat(create_id ,notNullValue());
		assertThat(upgradeOwner.getId(), is(create_id));
		assertThat(upgradeOwner.getFirst_name(), is(UP_OWNER_FNAME));
		assertThat(upgradeOwner.getLast_name(), is(UP_OWNER_LNAME));
		assertThat(upgradeOwner.getTelephone(), is(UP_OWNER_TELEPHONE));
	}

	/**
	 * 
	 */
	@Test
	public void testDeleteOwner() {

		String OWNER_FNAME = "Peter";
		String OWNER_LNAME = "McTavish";
		String OWNER_TELEPHONE = "6085552765";

		Owner owner = new Owner(OWNER_FNAME, OWNER_LNAME, OWNER_TELEPHONE);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
			
		try {
			ownerService.findById(owner.getId());
			assertThat(true, is(false));
		} catch (OwnerNotFoundException e) {
			assertThat(true, is(true));
		} 				

	}
	
	
	
}
