package ex3h;

public class rainfall {
	private double [] rainfallArray;
	private double[] sales;
	private double[] rainfall;
	private double[] dblRain;
	
	
	public rainfall(double[] dblRainfall) {
		// TODO Auto-generated constructor stub
		sales = new double[dblRainfall.length];
		
		for (int index = 0; index < dblRainfall.length; index++) {
			sales[index] = dblRainfall[index];
		}
	}
	
	public rainfall(String[] rainfall) {
	       this.rainfall = new double[rainfall.length]; 
	        for  (int index = 0; index < rainfall.length; index++) 
	                this.rainfall[index] = Double.parseDouble(rainfall[index]);		
	}

	public double getTotal() {
		double total = 0.0;
		for (double value: sales)
			total += value;
		return total;
	}
	
	public double getTotal2() {
		double total = 0.0;
		for (double value: rainfall) {
			total += value;
		}
		return total;
	}
	
	public double getAverage() {
		double total;
		total = getTotal() / sales.length;
		return total;
	}
	
	public double getAverage2() {
		double total;
		total = getTotal2() / rainfall.length;
		return total;
	}
	
	public double getHighest() {
		double highest = sales[0];
		for(int index = 1; index < sales.length; index++) {
			if (sales[index] > highest)
				highest = sales[index];
		}
		return highest;
	}
	
	public double getHighest2() {
		double highest = rainfall[0];
		for(int index = 1; index < rainfall.length; index++) {
			if (rainfall[index] > highest) {
				highest = rainfall[index];
			}
		}
		return highest;
	}
	
	public double getLowest() {
		double lowest = sales[0];
		for (int index = 1; index < sales.length; index++) {
			if(sales[index] < lowest)
				lowest = sales[index];
			}
		return lowest;
	}
	
	public double getLowest2() {
		double lowest = rainfall[0];
		for (int index = 1; index < rainfall.length; index++) {
			if(rainfall[index] < lowest) {
				lowest = rainfall[index];
			}
		}
		return lowest;
	}
}
