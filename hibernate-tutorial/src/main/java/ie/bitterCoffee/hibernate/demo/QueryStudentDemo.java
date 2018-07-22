package ie.bitterCoffee.hibernate.demo;

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
			
			//display students
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally
		{
			factory.close();
		}		
	}

}
