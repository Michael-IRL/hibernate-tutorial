package ie.bitterCoffee.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ie.bitterCoffee.hibernate.demo.entity.Student;

public class ReadStudentDemo
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
			//create a student object
			System.out.println("Creating a new student object ...");
			Student tempStudent = new Student("Daffy","Duck","daffyduck@example.ie");
			
			//start a transaction
			session.beginTransaction();
			
			//save java object
			System.out.println("Saving the student ...");
			System.out.println(tempStudent);
			session.save(tempStudent);			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Saved student. Generate id: "+tempStudent.getId());
			
			//get new session start new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			//Retrieve student based on id primary key
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: "+myStudent);			
			
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
