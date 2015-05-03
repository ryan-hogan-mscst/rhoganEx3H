package ex3h;

import java.text.DecimalFormat;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] dblRainfall = {
				1.2,2.7,2.2,3.1,2.9,5.1,3.2,2.7,3.6,1.8,2.2,1.7};
		
		String [] rainfall = {"1.2","2.7", "2.2", "3.1","2.9","5.1",
				"3.2","2.7","3.6","1.8","2.2","1.7"};
		
		DecimalFormat fmt = new DecimalFormat("#0.0");
		rainfall rainfall1 = new rainfall(dblRainfall);
		System.out.println("Rainfall Total: " + fmt.format(rainfall1.getTotal()));
		System.out.println("Rainfall average: " + fmt.format(rainfall1.getAverage()));
		System.out.println("Rainfall highest: " + fmt.format(rainfall1.getHighest()));
		System.out.println("Rainfall lowest: " + fmt.format(rainfall1.getLowest()));
		System.out.println();
		
		DecimalFormat fmtstr = new DecimalFormat("#0.0");
		rainfall rainfall2 = new rainfall(rainfall);
		System.out.println("Rainfall Total: " + fmt.format(rainfall2.getTotal2()));
		System.out.println("Rainfall average: " + fmt.format(rainfall2.getAverage2()));
		System.out.println("Highest: " + fmt.format(rainfall2.getHighest2()));
		System.out.println("Lowest: " + fmt.format(rainfall2.getLowest2()));
	}

}
