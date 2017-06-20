package doubleType;

public class DoubleDemo {
	public static void main(String[] args){
		Double dueAmount=0.0;
		try{
			dueAmount=Double.parseDouble("0.0");
		}catch (Exception e){
			System.out.println("Error when parsing amount " + dueAmount);
		}
		
		
		
	}
}
