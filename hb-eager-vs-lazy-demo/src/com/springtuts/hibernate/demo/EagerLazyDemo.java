package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Course;
import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Springtuts: Instructor: "+instructor);
			
			System.out.println("Springtuts: Courses: "+instructor.getCourses());

			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// since courses are lazy loaded... this should fail
			
			System.out.println("\nSpringtuts: The session is closed now!\n");
			// option 1: call getter method while session is open (check line 37: remove it and it will fail again)
			
			// get courses for the instructor
			System.out.println("Springtuts: Courses: "+instructor.getCourses());
			
			System.out.println("Success !!");
			
		}finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
	}

}
