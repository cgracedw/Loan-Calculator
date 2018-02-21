package loanCalculator;

public class LoanCalcLogic {
	String termMosFld;
	String termYrsFld;
	String principalFld;
	String interestRateFld;

	int termMosValue;
	int termYrsValue;
	int months;
	int years;
	
	Double monthlyPayments;
	Double totalPrincipal;
	Double principalValue;
	Double interestRateValue;
	
	
	Double interestPercent;
	Double totalInterest;
	Double monthlyIntRate; 
	Double updatedPrincipal;
	Double monthlyInterest;
	Double totalDue; 

	
	public int getTermMonths() {
		termYrsValue = Integer.parseInt(termYrsFld);
		if (termYrsValue > 0) {
		months = termYrsValue * 12;
		}
		System.out.println(months);
		return months;
	}
	
	public int getTermYrs() {
		termMosValue = Integer.parseInt(termMosFld);
		if (termMosValue > 0) {
		 years = termMosValue/12;
		}
		System.out.println(years);
		return years;
	}
	
	public Double getTotalPrincipal() { 
		totalPrincipal = Double.parseDouble(principalFld);
		return totalPrincipal;
	}
	
	public Double getMonthlyInterest() {
		
		interestRateValue = Double.parseDouble(interestRateFld);
		monthlyIntRate = interestPercent/12; //calculates the interest rate per month.
		interestPercent = interestRateValue/100;
		
		monthlyInterest = monthlyIntRate * updatedPrincipal;
		return monthlyInterest;
	}
	
	public Double getUpdatedPrincipal() {
		/*
		 * iterate through the months.
		 * at the start of each month take the monthlyPayments amount away from the principal and save the new principal value as the updated principal. 
		 * 
		 */
		principalValue = Double.parseDouble(principalFld);
		interestRateValue = Double.parseDouble(interestRateFld);
		
		for(int i=0; i<=months; i++) {
			int monthStart = 0;
			
				updatedPrincipal = principalValue - monthlyPayments;
	
		}
		
		updatedPrincipal = principalValue - monthlyPayments; //calculates the new principal after a payment.
		return updatedPrincipal;
	}
	
	public Double getMonthlyPayments() {
			//termMosValue = Integer.parseInt(termMosFld);
			principalValue = Double.parseDouble(principalFld);
			interestRateValue = Double.parseDouble(interestRateFld);
			
			interestPercent = interestRateValue/100; //changes number received into percent;
			totalInterest = interestPercent * principalValue; //calculates the total interest for loan.
			
			
			totalDue = principalValue + totalInterest;
			
			monthlyPayments = totalDue/months;
		
		    System.out.println(monthlyPayments);
			return monthlyPayments;
	}
	
	public Double getTotalInterest() {
//		totalInterest = principalValue * interestPercent;
		
//		System.out.println(totalInterest);
		return totalInterest;
	}
	
}
