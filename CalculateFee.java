
public class CalculateFee {
	String name ;
	int coursenum;
	boolean ishome;
	int homefees = 500;
	int nationalFee = 800;
	double totalFee;
	
	public CalculateFee(String pname ,int pcoursenum,boolean pishome) {
		name = pname;
		coursenum =pcoursenum;
		ishome = pishome; 
	
}
	public double calfee() {
		if (ishome)
			  totalFee = coursenum * homefees;
		else
		  totalFee =coursenum * nationalFee;
		
	return totalFee;
						
	}
}
