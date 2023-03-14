package com.springtuts.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			
			String dateOfBirthStr = "20/10/1008";
			Date dateOfBirth = DateUtils.parseDate(dateOfBirthStr);
			
			System.out.println("Creating a new student object...");
			Student student = new Student("Shiva", "Shambhoo", "shivashambhoo@yopmail.com",dateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student..."+student);
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			//========= My NEW Code =================
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+student.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Get complete: "+myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
	}

}
