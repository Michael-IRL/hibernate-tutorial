package ie.bitterCoffee.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ie.bitterCoffee.hibernate.demo.entity.Student;

public class QueryStudentDemo
{

	public static void main(String[] args)
	{
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(theStudents);
			
			//query student: last name = 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			//display students
			System.out.println("\nStudents with the last name Doe");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally
		{
			factory.close();
		}		
	}

	private static void displayStudents(List<Student> theStudents)
	{
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

}
