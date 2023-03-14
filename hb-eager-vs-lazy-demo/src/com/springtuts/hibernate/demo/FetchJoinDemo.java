package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.springtuts.hibernate.demo.entity.Course;
import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+"JOIN FETCH i.courses "
															+"where i.id=:theInstructorId",
														Instructor.class);
			// set parameter on query
			query.setParameter("theInstructorId", id);
			
			// execute query and get instructor
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Springtuts: Instructor: "+instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\nSpringtuts: The session is closed now!\n");
			
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
