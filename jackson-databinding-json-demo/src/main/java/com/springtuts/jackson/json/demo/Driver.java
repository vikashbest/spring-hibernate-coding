package com.springtuts.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO:
			// data/sample-lite.json
			Student myStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First Name: "+myStudent.getFirstName());
			System.out.println("Last Name: "+myStudent.getLastName());
			
			
			// print out the address: street and city
			Address tempAddress = myStudent.getAddress();
			System.out.println("\nStreet: "+tempAddress.getStreet());
			System.out.println("City: "+tempAddress.getCity());
			
			//print out languages
			System.out.println("\nLanguages: ");
			for(String tmpLang : myStudent.getLanguages()) {
				System.out.println(tmpLang);
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
		
	}

}
