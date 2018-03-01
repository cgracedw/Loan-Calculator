package loanCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

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
	
	DecimalFormat dollar = new DecimalFormat("#,##0.00");
	
	public LoanCalcLogic(String termMosFld, String principalFld, String interestRateFld) {
		termMosValue = Integer.parseInt(termMosFld);
		totalPrincipal = Double.parseDouble(principalFld);
		interestRateValue = Double.parseDouble(interestRateFld);
	}

/* 
 * returns the number of months 	
 */
	public int getTermMonths() {
		return termMosValue;
	}

/*
 * returns the total principal of the loan.
 */
	public Double getTotalPrincipal() { 
		
		return totalPrincipal;
	}
	
// Calculates the new principal at the beginning of each month.
	//TODO get return value to format correctly.
	public Double getUpdatedPrincipal() {
		/*
		 * calculate the monthly interest for that month
		 * subtract the monthly payment amount
		 * calculate how much of the monthly payment is principal and how much is interest
		 * 
		 * save the new principal amount
		 * 
		 */
		
		
		System.out.println(monthlyPayments);
		System.out.println(termMosValue);
		Double principal;
		Double updatedPayments;
		
	//	principal = Double.valueOf(dollar.format(updatedPrincipal));

		for(int i=0; i<=termMosValue; i++) {
			
			updatedPayments = i*monthlyPayments;
			updatedPrincipal = totalDue - updatedPayments;
			//principal = Double.valueOf(dollar.format(updatedPrincipal));
			
	//		if(updatedPrincipal < monthlyPayments) {
	//			System.out.println("Your remaining payment is: $" + principal);
	//		} else {
	//		String formatP = dollar.format(updatedPrincipal);
	//		principal = Double.valueOf(formatP);
	//		System.out.println(principal);
				System.out.println("Payment Number: " + i + " remaining Principal after payment " + i + " is: $" + updatedPrincipal);
			
				
			
		}
		principal = Double.valueOf(dollar.format(updatedPrincipal));
		System.out.println(principal);
		return principal;
	}

	public Double getMonthlyPayments() {
			
			interestPercent = interestRateValue/100; //changes number received into percent;
			totalInterest = interestPercent * totalPrincipal; //calculates the total interest for loan.
			
			totalDue = totalPrincipal + totalInterest;
			monthlyPayments = totalDue/termMosValue;
			
			Double payment;
			
			//DecimalFormat dollar = new DecimalFormat("#,##0.00");
			
			payment = Double.valueOf(dollar.format(monthlyPayments));
			
			//NumberFormat formatter = NumberFormat.getCurrencyInstance();
			//System.out.println(formatter.format(monthlyPayments));
			
			//BigDecimal monthlyPayments = new BigDecimal();
			
			//double newMonthlyPayments = Math.round(monthlyPayments*100.0)/100.0;
		
 			//monthlyPayments = newMonthlyPayments;
 
 			//System.out.println("monthlyPayments (Math.round) : " + newMonthlyPayments);
			//String newMonthlyPayments = dollar.format(monthlyPayments);
			
			//monthlyPayments = newMonthlyPayments;
			
			//return dollar.format(monthlyPayments);
			return payment;
			
	}
	
public Double getMonthlyInterest() {
	interestPercent = interestRateValue/100;
	Double monthlyIntRate = interestPercent/12; //calculates the interest rate per month.
	
		for(int i=1; i<=termMosValue; i++) {
				monthlyInterest = monthlyIntRate * updatedPrincipal;	
			}
			
			System.out.println("this is monthlyInterest: " + monthlyInterest);
			return monthlyInterest;

		
		
	}

//  Calculates total interest

	public Double getTotalInterest() {
		totalInterest = totalPrincipal * interestPercent;
		
		double newTotalInterest;
		
		newTotalInterest = Double.valueOf(dollar.format(totalInterest));
		//double newTotalInterest = Math.round(totalInterest*100.0)/100.0;
		
		//totalInterest = newTotalInterest;
		System.out.println(newTotalInterest);
		return newTotalInterest;
	}
	
}
