package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects		
			Instructor instructor = new Instructor("Abhishek", "Sinha", "abhisheksinha@yopmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://www.abhishekvlogs.com/youtube", "Vlogging");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			// Note: this will also save the details object because of CascadeType.ALL
			System.out.println("Saving Instructor: "+instructor);
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Success !!");
			
		}finally {
			factory.close();
		}
		
	}

}
