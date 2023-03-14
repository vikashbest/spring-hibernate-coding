package com.springtuts.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// query students 
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(students);
			
			// query students: lastName='Kumar'
			students = session.createQuery("from Student s where s.lastName='Kumar'").getResultList();
			
			System.out.println("\n\nStudents who have last name 'Kumar'");
			displayStudents(students);
			
			// query students: lastName='Fell' OR firstName='Chris'
			students = session.createQuery("from Student s where "
												+ "s.lastName='Fell' OR s.firstName='Chris'").getResultList();
			System.out.println("\n\nStudents whose last name='Fell' OR first name='Chris'");
			displayStudents(students);
			
			// query students where email like hotmail.com
			students = session.createQuery("from Student s where s.email LIKE '%hotmail.com'").getResultList();
			System.out.println("\n\nStudents whose email is hotmail.com");
			displayStudents(students);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!");
			
		}finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}

}
