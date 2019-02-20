package code;
public interface PromotionInterface extends java.rmi.Remote 
{

  public void add_student(String name, int age) throws java.rmi.RemoteException;
  
  public StudentInterface get_student(String name) throws java.rmi.RemoteException;
  
  public double promotion_score() throws java.rmi.RemoteException;
  
}
