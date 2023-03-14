package com.springtuts.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Course;
import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			System.out.println("Instructor: "+instructor);
			
			List<Course> courses = instructor.getCourses();
			System.out.println("Courses: "+courses);
			
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
