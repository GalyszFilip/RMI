package code;
import java.rmi.RemoteException;

public interface StudentInterface extends java.rmi.Remote 
{
  public void add_exam(String examName, double score, double coeff) throws java.rmi.RemoteException;
  
  public String print_exams() throws java.rmi.RemoteException;
  
  public double calculate_average() throws java.rmi.RemoteException;
  
  public String get_name() throws java.rmi.RemoteException;
  
  public int get_age() throws java.rmi.RemoteException;
}

