package code;
import java.rmi.*;

public class StudentClient {
	public static void main(String args[]) 
	{
		try 
		{
			PromotionInterface pro = (PromotionInterface)	Naming.lookup("rmi://localhost:12345/mon_serveur_hello");
			
			// Add students
			pro.add_student("Filip", 21);
			pro.add_student("Mario", 23);
			pro.add_student("Ana", 24);
			StudentInterface filip = (StudentInterface) pro.get_student("Filip");
			StudentInterface mario = (StudentInterface) pro.get_student("Mario");
			StudentInterface ana = (StudentInterface) pro.get_student("Ana");
			
			// Add exams
			filip.add_exam("Distibuted", 5, 0.2);
			filip.add_exam("Math 101", 3, 0.5);
			
			mario.add_exam("Distibuted", 9, 0.2);
			mario.add_exam("Math 101", 4, 0.5);
			
			ana.add_exam("Art 101", 9, 0.2);
			ana.add_exam("Management", 8, 0.4);
			
			System.out.println("Promotion Score: " + pro.promotion_score() + "\n");
			
			printStudentInfo(filip);
			printStudentInfo(mario);
			printStudentInfo(ana);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void printStudentInfo(StudentInterface s) throws RemoteException {
		System.out.println("Name: " + s.get_name() + "\nAge: " + s.get_age() + "\nAverage: " + s.calculate_average());
		System.out.println("Exams:");
		System.out.println(s.print_exams() + "\n");
	}
}
