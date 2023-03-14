package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Course;
import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;
import com.springtuts.hibernate.demo.entity.Review;
import com.springtuts.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the student from the database
			int id = 1;
			Student student = session.get(Student.class, id);
			System.out.println("\nLoaded student: "+student);
			System.out.println("Courses: "+student.getCourses());
			
			// create more courses
			Course course1 = new Course("Learn Yoga & Meditation");
			Course course2 = new Course("Learn How to Cook");
			
			// add student to the courses
			course1.addStudent(student);
			course2.addStudent(student);
			
			// save the courses
			System.out.println("\nSaving the courses... ");
			session.save(course1);
			session.save(course2);
			
			
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
