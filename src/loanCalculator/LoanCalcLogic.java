package loanCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class LoanCalcLogic {

	int termMosValue;
	int termYrsValue;
	
	Double monthlyPayments;
	Double totalPrincipal;
	Double interestRateValue;
	
	
	Double interestPercent;
	Double totalInterest;
//	Double monthlyIntRate; 
	Double updatedPrincipal;
	Double monthlyInterest;
	Double totalDue; 
	
	public LoanCalcLogic(String termMosFld, String principalFld, String interestRateFld) {
		termMosValue = Integer.parseInt(termMosFld);
		totalPrincipal = Double.parseDouble(principalFld);
		interestRateValue = Double.parseDouble(interestRateFld);
	}

	public int getNumOfPayments() {
		
		return termYrsValue * 12;
	}
	
	public int getTermMonths() {
		return termMosValue;
	}

	
/*	public int getTermYrs() {
		int years = 0;
		if (termMosValue > 0) {
		years = termMosValue/12;
		}
		System.out.println(years);
		return years;
	}
*/	
	public Double getTotalPrincipal() { 
		
		return totalPrincipal;
	}
	
	public Double getMonthlyInterest() {
		
		
		Double monthlyIntRate = interestPercent/12; //calculates the interest rate per month.
		interestPercent = interestRateValue/100;
		
		monthlyInterest = monthlyIntRate * updatedPrincipal;
		return monthlyInterest;
	}
	
	public Double getUpdatedPrincipal() {
		/*
		 * does months need to be an array?
		 * iterate through the months.
		 * at the start of each month take the monthlyPayments amount away from the principal and save the new principal value as the updated principal. 
		 * 
		 * array to save each month value
		 * print out a list of all the months
		 * take the principal at the beginning of the the first month
		 * calculate the monthly interest for that month
		 * subtract the monthly payment amount
		 * calculate how much of the monthly payment is principal and how much is interest
		 * 
		 * save the new principal amount
		 * 
		 */
		
		
		System.out.println(monthlyPayments);
		System.out.println(termMosValue);
		for(int i=1; i<=termMosValue; i++) {
			
			//int monthStart = 0;
			System.out.println(i);
			
				updatedPrincipal = totalPrincipal - monthlyPayments;
	
		}
		
		updatedPrincipal = totalPrincipal - monthlyPayments; //calculates the new principal after a payment.
		return updatedPrincipal;
	}

	public Double getMonthlyPayments() {
		
			interestPercent = interestRateValue/100; //changes number received into percent;
			totalInterest = interestPercent * totalPrincipal; //calculates the total interest for loan.
			
			totalDue = totalPrincipal + totalInterest;
			monthlyPayments = totalDue/termMosValue;

			double newMonthlyPayments = Math.round(monthlyPayments*100.0)/100.0;
		
 			monthlyPayments = newMonthlyPayments;
 
 			System.out.println("monthlyPayments (Math.round) : " + newMonthlyPayments);
			
			return newMonthlyPayments;
			
	}
	
	
	public Double getTotalInterest() {
		totalInterest = totalPrincipal * interestPercent;
		
		double newTotalInterest = Math.round(totalInterest*100.0)/100.0;
		
		totalInterest = newTotalInterest;
		System.out.println(newTotalInterest);
		return newTotalInterest;
	}
	
}
