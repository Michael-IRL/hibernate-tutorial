package ie.bitterCoffee.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ie.bitterCoffee.hibernate.demo.entity.Student;

public class DeleteStudentDemo
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
			/*
			//delete the student
			System.out.println("Delete the student: "+myStudent);
			session.delete(myStudent);*/
			
			//delete student id = 2
			System.out.println("Delete student id=2 ");
			session.createQuery("delete from Student where id =2").executeUpdate();
						
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
