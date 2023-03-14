package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			// get the instructor detail object
			int id = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			// print the instructor detail
			System.out.println("Instructor Detail: "+instructorDetail);
			
			// print the associated instructor
			System.out.println("Associated Instructor: "+instructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Success !!");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			// handle connection leak
			session.close();
			
			factory.close();
		}
		
	}

}
