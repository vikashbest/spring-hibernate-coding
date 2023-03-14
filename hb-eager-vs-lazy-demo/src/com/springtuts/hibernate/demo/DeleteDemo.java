package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int id = 4;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found Instructor: "+instructor);
			
			// delete the instructor
			if(instructor != null) {
				System.out.println("Deleting: "+instructor);
				
				// Note: this will also delete associated "details" object
				session.delete(instructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Success !!");
			
		}finally {
			factory.close();
		}
		
	}

}
