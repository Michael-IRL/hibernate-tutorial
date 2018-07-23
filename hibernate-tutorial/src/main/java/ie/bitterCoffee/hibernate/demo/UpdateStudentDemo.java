package ie.bitterCoffee.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ie.bitterCoffee.hibernate.demo.entity.Student;

public class UpdateStudentDemo
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
			int studentId = 1;
			
			//start a transaction
			session.beginTransaction();
			
			//Retrieve student based on the id: primary key 
			System.out.println("\nGetting student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updateing student...");
			//Update the property on the retrieved object and hibernate will save it on commit
			myStudent.setFirstName("Scooby");			
			
			//commit transaction
			session.getTransaction().commit();
			
			//get new session start new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("update email for all students");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!\n");
			
		}
		finally
		{
			factory.close();
		}		
	}

}
