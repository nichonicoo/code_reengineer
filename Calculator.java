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
				return RiskFactor.HIGH_RISK;
			if(points > 0)
				return RiskFactor.MODERATE_RISK;
			
			return RiskFactor.LOW_RISK;
		}
		
		public double calculateInsurancePremium(double insuranceValue) {
			RiskFactor riskFactor = calculateMotoristRisk();
			return riskFactor.getRisk() * insuranceValue;
		}
		
	}
	
	enum RiskFactor {
		LOW_RISK(0.02),
		MODERATE_RISK(0.04),
		HIGH_RISK(0.06);

		private double risk;

		RiskFactor(double risk) {
			this.risk = risk;
		}
		public double getRisk() {
			return risk;
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
