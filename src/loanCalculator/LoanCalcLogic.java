package loanCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LoanCalcLogic {

	

	private Double monthlyPayments;   // Monthly payments
	private Double principal;         // loan principal
	private Double interestRateValue; // Interest rate as a number
//	private Double interestPercent;   // interestRateValue number converted to a percent
	private Double totalInterest;     // total interest for the entire loan 
	private Double updatedTotalDue;   // The amount of loan left after each payment
	private Double monthlyInterest;   // The amount of interest per each monthly payment
	private Double totalDue;          // total principal + total interest
	
	/////////////////////////////////////////////////////////
	private Double interest;          // interest
	private Double updatedPrincipal; 
	
	private Double calcPayment;
	private Double term;
	private Double loanBalance;
	
	///////////////////////////////////////////////////////
	
	private int months;               // loan term in months

	DecimalFormat dollar = new DecimalFormat("#,##0.00");
	
	public LoanCalcLogic(String termMosFld, String principalFld, String interestRateFld) {
		months = Integer.parseInt(termMosFld);                      // Loan terms input by user, parsed to Double.
		principal = Double.parseDouble(principalFld);               // Principal input by user, parsed to Double.
		interestRateValue = Double.parseDouble(interestRateFld);    // Interest rate as a number, input by user, parsed to Double.
		interestRateValue /= 100.0;                                 // Converts interestRateValue to a percent
		loanBalance = principal;
		getAmortizationTable();
	}

/* 
 * returns the number of months 	
 */
	public int getMonths() {
		return months;
	}

/*
 * returns the principal of the loan.
 */
	public Double getPrincipal() { 
		
		return principal;
	}

	//////////////////////////////////////////////////////////////////////////////////
	
/*	public Double getPrincipalBalance() {
		for(int i=0; i<=months; i++) {
			updatedPrincipal = principal - (monthlyPayments - interest);
		}
		return updatedPrincipal;
	}
	*/
	public Double getInterest() {
		int time = months/12;
		interest = principal * interestRateValue * time;
		System.out.println("yaya" + interest);
		return interest;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	 public Double getCalcPayment()
	   {
	      // Calculate value of Term
	      term = Math.pow((1+interestRateValue/12.0), months);

	      // Calculate monthly payment
	      calcPayment = (principal * interestRateValue/12.0 * term) / (term - 1);
	      
	      System.out.println("new method MonthlyPayments " + calcPayment);
	      System.out.println("term " + term);
	      
	      return calcPayment;
	   }
	
	 // Display the amortization table.
	 public void getAmortizationTable() {
     for (int month = 1; month <= getMonths(); month++)
     {
    	 	loanBalance = principal;
        // Calculate monthly interest.
        monthlyInterest = interestRateValue / 12.0 * loanBalance;

        if (month != getMonths())
        { if (principal == null) {
     	   System.out.println("principal is null");
        } else if (calcPayment == null) {
     	   System.out.println("calcPayment is null");
        } else if (monthlyInterest == null) {
     	   System.out.println("monthlyInterest is null");
        } else {
     	   System.out.println("All good");
        }
        	
           // Calculate payment applied to principal
           principal = getCalcPayment() - monthlyInterest;
        }
        else    // This is the last month.
        {
           principal = loanBalance;
           monthlyPayments = loanBalance + monthlyInterest;
        }

        // Calculate the new loan balance.
        loanBalance -= principal;

        // Display a line of data.
        System.out.println(month +
                           "\t" +
                           dollar.format(monthlyInterest) +
                           "\t\t" +
                           dollar.format(principal) +
                           "\t\t" +
                           dollar.format(loanBalance));
     }

	 }
// Calculates the new total amount due after the previous payment.
	
/*	//TODO get return value to format correctly.
	public Double getUpdatedTotalDue() {
		/*
		 * calculate the monthly interest for that month
		 * subtract the monthly payment amount
		 * calculate how much of the monthly payment is principal and how much is interest
		 * 
		 * save the new principal amount
		 * 
		 */
		
	/*	
		System.out.println(monthlyPayments);
		System.out.println(months);
		Double principal;
		
		
	//	principal = Double.valueOf(dollar.format(updatedPrincipal));

		for(int i=0; i<=months; i++) {
			
			updatedTotalDue = totalDue - i*monthlyPayments;
			//principal = Double.valueOf(dollar.format(updatedPrincipal));
			
	//		if(updatedPrincipal < monthlyPayments) {
	//			System.out.println("Your remaining payment is: $" + principal);
	//		} else {
	//		String formatP = dollar.format(updatedPrincipal);
	//		principal = Double.valueOf(formatP);
	//		System.out.println(principal);
				System.out.println("Payment Number: " + i + " remaining Principal after payment " + i + " is: $" + updatedTotalDue);
			
				
			
		}
		principal = Double.valueOf(dollar.format(updatedTotalDue));
		System.out.println(principal);
		return principal;
	}
	*/
	
	// Calculates the payment amount per month

	public Double getMonthlyPayments() {
			
			//interestPercent = interestRateValue/100; //changes number received into percent;
			totalInterest = interestRateValue * principal; //calculates the total interest for loan.
			
			totalDue = principal + totalInterest;
			monthlyPayments = totalDue/months;
			
			Double payment; // monthlyPayments value formatted to 0.00
			
			payment = Double.valueOf(dollar.format(monthlyPayments));
			return payment;
			
	}
//  Calculates the 
/*	
	public Double getMonthlyInterest() {
//	interestPercent = interestRateValue/100;    // converts interestRateValue number to a percent
	Double monthlyIntRate = interestRateValue/12; // calculates the interest rate per month.
	
		for(int i=1; i<=months; i++) {
				monthlyInterest = monthlyIntRate * updatedTotalDue;	
				System.out.println("This is interest per month" + monthlyInterest);
			}
			
			System.out.println("this is monthlyInterest: " + monthlyInterest);
			return monthlyInterest;

		
		
	}
*/
//  Calculates total interest

	public Double getTotalInterest() {
		totalInterest = principal * interestRateValue;
		
		double newTotalInterest;
		
		newTotalInterest = Double.valueOf(dollar.format(totalInterest));
		//double newTotalInterest = Math.round(totalInterest*100.0)/100.0;
		
		//totalInterest = newTotalInterest;
		System.out.println(newTotalInterest);
		return newTotalInterest;
	}
	
}
