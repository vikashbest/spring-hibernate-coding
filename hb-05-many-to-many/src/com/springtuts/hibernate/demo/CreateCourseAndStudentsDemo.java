package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Course;
import com.springtuts.hibernate.demo.entity.Instructor;
import com.springtuts.hibernate.demo.entity.InstructorDetail;
import com.springtuts.hibernate.demo.entity.Review;
import com.springtuts.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course course = new Course("Web Developer Bootcamp !");
			
			// save the course
			System.out.println("\nSaving the course ... ");
			session.save(course);
			System.out.println("Course Saved: "+course);
			
			// create the students
			Student student1 = new Student("John", "Doe", "johndoe@yopmail.com");
			Student student2 = new Student("Mary", "Smith", "marysmith@hotmail.com");
			
			// add the students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			// save the students
			System.out.println("\nSaving students...");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved Students: "+course.getStudents());
			
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
