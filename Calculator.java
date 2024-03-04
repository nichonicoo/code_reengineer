package gslc_codeengineer;


public class Calculator {
	
	public static void main(String[] args) {
		new Calculator().test();
	}
	
	class Motorist {
		private int points;
		private	int age;
		
		public Motorist(int age) {
			this.points = 0;
			this.age = age;
		}
		public void addPoints(int points) {
			this.points += points;
		}
		public int getAge() {
			return this.age;
		}
		public int getPointsOnLicense() {
			return points;
		}
		
		public RiskFactor calculateMotoristRisk() {
			if(points > 3 || age < 25)
				return new HIGH_RISK();
			if(points > 0)
				return new MODERATE_RISK();
			
			return new LOW_RISK();
		}
		
		public double calculateInsurancePremium(double insuranceValue) {
			RiskFactor riskFactor = calculateMotoristRisk();
			return riskFactor.calculateInsurancePremium(insuranceValue);
		}
		
	}
	
	// Polymorphism 
	public abstract class RiskFactor{
		public abstract double calculateInsurancePremium(double insuranceValue);
	}
	
	public class LOW_RISK extends RiskFactor{
		@Override
		public double calculateInsurancePremium(double insuranceValue) {
			return insuranceValue * 0.02;
		}
	}
	public class MODERATE_RISK extends RiskFactor{
		@Override
		public double calculateInsurancePremium(double insuranceValue) {
			return insuranceValue * 0.04;
		}
	}
	public class HIGH_RISK extends RiskFactor{
		@Override
		public double calculateInsurancePremium(double insuranceValue) {
			return insuranceValue * 0.06;
		}
	}
	
	public void test(){
		Motorist a = new Motorist(30);
		Motorist b = new Motorist(31);
		Motorist c = new Motorist(37);
		b.addPoints(1);
		c.addPoints(5);
		System.out.println(a.calculateInsurancePremium(1000));
		System.out.println(b.calculateInsurancePremium(1000));
		System.out.println(c.calculateInsurancePremium(1000));
	}

}