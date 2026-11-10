package f;


public class LinearRegression {
	private double Bo;
	private double B1;
	private double[] x;
	private double[] y;
	private double Yi;

	
	public LinearRegression(double[] x, double[] y) {
		
		
		this.x = x;
		this.y = y;
		this.B1 = Sxy()/Sxx();
		this.Bo = yMean() - (this.B1*xMean());
		
	}
	
	//set our B1 
	public void setB1(double B1) {
		this.B1 = B1;
	}
	
	public void setBo(double Bo) {
		this.Bo = Bo;
	}
	
	//our getter 
	public double getB1() {
		return this.B1;
	}
	
	public double getBo() {
		return this.Bo;
	}
	
	///mean calculations
	public double xMean() {
		double xSum = 0;
		for(int i  = 0; i < this.x.length; i++) {
			xSum+= this.x[i];
		}
		double equation = xSum/this.x.length;
		
		return equation ;
	}
	
	public double yMean() {
		double ySum = 0;
		for(int i = 0; i <this.y.length; i ++) {
			ySum += this.y[i];
		}
		double equation = ySum/this.y.length;
		
		return equation ;
	}
	
	//equation equations 
	public double Sxy() {
		double ySum = 0;
		double xSum = 0;
		double xySum = 0;
		
		
		for(int i = 0 ; i<this.y.length; i++) {
			ySum += this.y[i];
			xSum += this.x[i];
			
			xySum += this.y[i] * this.x[i];
		}
		
		double equation = xySum - (xSum * ySum)/ this.y.length;
		
		return Math.round(equation);
		
	}//end fo xy
	
	public double Sxx() {
		double xSum = 0;
		double xSumSquared = 0;
		
		for(int i = 0; i < this.x.length; i++) {
			xSum += this.x[i];
			xSumSquared += Math.pow(this.x[i], 2);
		}
		
		double equation = xSumSquared - Math.pow(xSum,2)/this.x.length;
		
		return Math.round(equation);
		
		
		
	
	}//end of xx 
	
	public void setYi(double x) {
		this.Yi = this.Bo + B1 * x ;
	}
	public double getYi() {
		return Yi;
	}
	
	public String toString() {
		
		if(B1 <0 && Bo<0) {
		return "Yi = " + " -" + (Bo) +" -"+ (B1) + "()" ;
		}else if(B1 >0 && Bo>0) {
			return "Yi = " + (Bo) +" +"+ (B1) + "()" ;
		}else if(B1 >0 && Bo <0) {
			return "Yi = " +" -" + (Bo) +" +"+ (B1) + "()" ;
		}else {
			return "Yi = " + (Bo) +" -"+ (B1) + "()" ;
		}
	}
	
	public static void main(String[] args) {
		
		double[] xAxis = {8,9.5,7.2,6.5,10,12,11.5,14.8,17.3,27,30,25};
		
		double[] yAxis = {12.5,18.6,25.3,24.8,35.7,45.4,44.4,45.8,65.3,75.7,72.3,79.2};
		
		
		LinearRegression myObj = new LinearRegression(xAxis,yAxis);
		
System.out.println(myObj.toString());

myObj.setYi(20);

System.out.println("copies of books that would be sold: " + myObj.getYi());
		
	}//end of static void 

}//end of class
