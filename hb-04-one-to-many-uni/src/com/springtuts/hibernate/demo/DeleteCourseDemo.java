package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Course;
import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			
			// get a course
			int id = 11;
			Course course = session.get(Course.class, id);
			
			// delete course
			System.out.println("Deleting Course: "+course);
			session.delete(course);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Success !!");
			
		}finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
	}

}
