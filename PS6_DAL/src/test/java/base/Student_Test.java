package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Student_Test {

	static PersonDomainModel person1 = new PersonDomainModel();
	static PersonDomainModel person2 = new PersonDomainModel();
	static PersonDomainModel person3 = new PersonDomainModel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PersonDAL.addPerson(person1);
		PersonDAL.addPerson(person2);
		PersonDAL.addPerson(person3);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(person1.getPersonID());
		PersonDAL.deletePerson(person2.getPersonID());
		PersonDAL.deletePerson(person3.getPersonID());
		
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(1==1);
	}
	
	@Test
	public void Persontests(){
		
		assertTrue(PersonDAL.getPerson(person1.getPersonID()).getFirstName()== null);
		assertTrue(PersonDAL.getPerson(person2.getPersonID()).getFirstName()== null);
		assertTrue(PersonDAL.getPerson(person3.getPersonID()).getFirstName()== null);
		
		assertTrue(PersonDAL.getPersons().size()==3);
		PersonDAL.deletePerson(person1.getPersonID());
		
		assertTrue(PersonDAL.getPersons().size()==2);
		
		person1.setFirstName("BROCK");
		PersonDAL.updatePerson(person1);
		assertTrue(PersonDAL.getPerson(person1.getPersonID()).getFirstName() == "BROCK");
		
	}

}
