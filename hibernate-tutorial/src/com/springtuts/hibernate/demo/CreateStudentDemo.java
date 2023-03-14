package com.springtuts.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating a new student object...");
			String dateOfBirthStr = "24/12/1998";
			Date dateOfBirth = DateUtils.parseDate(dateOfBirthStr);
			Student student = new Student("Gopal", "Yadav", "gopalyadav@yopmail.com", dateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(student);
			
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
