package code;
import java.io.Serializable;
import java.rmi.server.RemoteObject;

public class Exam extends RemoteObject implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private double score;
	private double coeff;
	
	public Exam(String name, double score, double coeff) {
		this.name = name;
		this.score = score;
		this.coeff = coeff;
	}
	
	protected String getName(){
		return name;
	}
	
	protected double getScore(){
		return score;
	}
	
	protected double getCoeff(){
		return coeff;
	}
	
	
	

}
