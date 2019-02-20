package code;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.HashMap;


public class StudentServer extends UnicastRemoteObject implements PromotionInterface
{
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Student> students;
	public StudentServer() throws java.rmi.RemoteException
	{
		super();
		students = new HashMap<>();
	}

	@Override
	public void add_student(String name, int age) throws RemoteException {
		Student s = new Student(name, age);
		students.put(name.hashCode(), s);
	}
	
	@Override
	public Student get_student(String name) throws RemoteException {
		return students.get(name.hashCode());
	}
	
	@Override
	public double promotion_score() throws RemoteException {
		double avgScore = 0.0;
		for(Student s : students.values()){
			avgScore += s.calculate_average();
		}
		return avgScore / students.size();
	}
	
	public static void main(String args[])
	{
		try 
		{
			StudentServer obj = new StudentServer();
			
			// start RMIRegistry: port 12345
			// Alternative: start rmiregistry in terminal !
			java.rmi.registry.LocateRegistry.createRegistry(12345);
			
			// register the object
			Naming.rebind("rmi://localhost:12345/mon_serveur_hello",obj);
			
			System.out.println("StudentServer bound in registry");
		} 
		catch(Exception e)
		{
	      e.printStackTrace();
	    }
	}
}
