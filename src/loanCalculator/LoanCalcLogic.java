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
	//Double interestPercent;
	//Double totalInterest;
	
	Double interestPercent;
	Double totalInterest;
	Double monthlyIntRate; 
	Double updatedPrincipal;
	Double monthlyInterest;
	Double totalAmountDue; 

	
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
	
	public Double getMonthlyPayments() {
			termMosValue = Integer.parseInt(termMosFld);
			principalValue = Double.parseDouble(principalFld);
			interestRateValue = Double.parseDouble(interestRateFld);
			
			interestPercent = interestRateValue/100; //changes number received into percent;
			totalInterest = interestPercent * principalValue; //calculates the total interest for loan.
			monthlyIntRate = interestPercent/12; //calculates the interest rate per month.
			updatedPrincipal = principalValue - monthlyPayments; //calculates the new principal after a payment.
			monthlyInterest = monthlyIntRate * updatedPrincipal;
			totalAmountDue = principalValue + totalInterest; //calculates the full amount owed plus the interest.
			
			Double totalDue = principalValue + totalInterest;
			
			monthlyPayments = totalDue/months;
		
		    System.out.println(monthlyPayments);
			return monthlyPayments;
	}
	
	public Double getTotalInterest() {
//		totalInterest = principalValue * interestPercent;
		
//		System.out.println(totalInterest);
		return 0.0;
	}
	
}
