/**
 * 
 */
package com.nagihome.serialize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nagi
 *
 */
public class SerializeData {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SerializeData serializeData = new SerializeData();
		List<Person> people = serializeData.getPersonData();

		/*for (Person person : people) {			
			serializeData.getObjectOutputStream().writeObject(person);
		}*/
		Person person = people.get(0);
		for (int i = 0; i < 1000000; i++) {
			serializeData.getObjectOutputStream().writeObject(person);
		}
	}

	private List<Person> getPersonData() {

		Person person = new Person();
		person.setPersonId(1);
		person.setFirstName("Nagi");
		person.setLastName("Ponnaganti");
		person.setAge(28);
		person.setAddress("102, Langdon cresecent, London, E6 2PP.");
		person.setSalary(BigDecimal.valueOf(Double.valueOf(42000.098)));
		person.setCompanyName("FDM Group");

		return Arrays.asList(person);
	}

	public SerializeData() throws Exception {

		File personData = new File("Person.dat");

		if (!personData.exists())
			personData.createNewFile();

		fileOutputStream = new FileOutputStream(personData);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);

	}

	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;

	/**
	 * @return the fileOutputStream
	 */
	public FileOutputStream getFileOutputStream() {
		return fileOutputStream;
	}

	/**
	 * @param fileOutputStream
	 *            the fileOutputStream to set
	 */
	public void setFileOutputStream(FileOutputStream fileOutputStream) {
		this.fileOutputStream = fileOutputStream;
	}

	/**
	 * @return the objectOutputStream
	 */
	public ObjectOutputStream getObjectOutputStream() {
		return objectOutputStream;
	}

	/**
	 * @param objectOutputStream
	 *            the objectOutputStream to set
	 */
	public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
		this.objectOutputStream = objectOutputStream;
	}

}
