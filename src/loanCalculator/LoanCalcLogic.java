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
		if (termMosFld !=null && principalFld !=null && interestRateFld !=null) {
			try {
			termMosValue = Integer.parseInt(termMosFld);
			principalValue = Double.parseDouble(principalFld);
			interestRateValue = Double.parseDouble(interestRateFld);
			interestPercent = interestRateValue/100;
			Double intPerMonth = (principalValue * interestPercent)/termMosValue;
			Double principalPerMonth = principalValue/termMosValue;
			monthlyPayments = intPerMonth + principalPerMonth;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number.");
			}
		}
		    System.out.println(monthlyPayments);
			return monthlyPayments;
	}
	
	public Double getTotalInterest() {
//		totalInterest = principalValue * interestPercent;
		
//		System.out.println(totalInterest);
		return 0.0;
	}
	
}
