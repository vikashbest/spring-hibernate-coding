package com.springtuts.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
				SessionFactory factory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Student.class)
												.buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();
				
				try {
					String dateOfBirthStr = "20/05/1998";
					Date dateOfBirth = DateUtils.parseDate(dateOfBirthStr);
					// create 3 student objects
					System.out.println("Creating 3 new student objects...");
					Student student1 = new Student("Rakesh", "Kumar", "rakeshkr@yopmail.com",dateOfBirth);
					Student student2 = new Student("Vinay", "Kumar", "vinaykr@yopmail.com",dateOfBirth);
					Student student3 = new Student("Shubham", "Kumar", "shubhamkr@yopmail.com",dateOfBirth);
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					// commit transaction
					session.getTransaction().commit();
					System.out.println("Done !!");
					
				} catch (ParseException e) {
					e.printStackTrace();
				}finally {
					factory.close();
				}
	}

}
