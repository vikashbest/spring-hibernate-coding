package com.springtuts.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();

		
		try {
			int studentId = 3;
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
				
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			// delete the student
			System.out.println("Deleting student: "+myStudent);
			session.delete(myStudent);
		
			// delete student id=19
			System.out.println("Deleting student id=19");
			session.createQuery("delete from Student where id=19").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!");
			
		}finally {
			factory.close();
		}
		
	}

}
