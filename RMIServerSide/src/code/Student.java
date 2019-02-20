package code;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Student extends UnicastRemoteObject implements StudentInterface{

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private ArrayList<Exam> exams;
	
	public Student(String name, int age) throws java.rmi.RemoteException{
		this.name = name;
		this.age = age;
		exams = new ArrayList<>();
	}

	@Override
	public void add_exam(String examName, double score, double coeff) throws java.rmi.RemoteException {
		Exam e = new Exam(examName, score, coeff);
		exams.add(e);
	}

	@Override
	public String print_exams() throws java.rmi.RemoteException {
		String eString = "";
		for(Exam e: exams){
			eString += e.getName() + ", Score: " + e.getScore() + ", Coefficient: " + e.getCoeff()+ ", Weighted: " + e.getScore() * e.getCoeff() +  "\n";
		}
		return eString;
	}

	@Override
	public double calculate_average() throws java.rmi.RemoteException {
		double totalScore = 0.0;
		for(Exam e: exams){
			totalScore += e.getScore() * e.getCoeff();
		}
		return totalScore / exams.size();
	}

	@Override
	public String get_name() throws java.rmi.RemoteException {
		return name;
	}

	@Override
	public int get_age() throws java.rmi.RemoteException {
		return age;
	}
	

}
