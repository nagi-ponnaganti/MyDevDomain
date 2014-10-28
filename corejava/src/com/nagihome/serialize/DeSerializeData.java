/**
 * 
 */
package com.nagihome.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Nagi
 *
 */
public class DeSerializeData {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		DeSerializeData deSerializeData = new DeSerializeData();

		Person person = (Person) deSerializeData.getObjectInputStream().readObject();

		System.out.println("Printing Object: "
				+ ToStringBuilder.reflectionToString(person));

	}

	public DeSerializeData() throws Exception {

		File personData = new File("Person.dat");

		fileInputStream = new FileInputStream(personData);
		objectInputStream = new ObjectInputStream(fileInputStream);
	}

	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;

	/**
	 * @return the fileInputStream
	 */
	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	/**
	 * @param fileInputStream
	 *            the fileInputStream to set
	 */
	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	/**
	 * @return the objectInputStream
	 */
	public ObjectInputStream getObjectInputStream() {
		return objectInputStream;
	}

	/**
	 * @param objectInputStream
	 *            the objectInputStream to set
	 */
	public void setObjectInputStream(ObjectInputStream objectInputStream) {
		this.objectInputStream = objectInputStream;
	}

}
