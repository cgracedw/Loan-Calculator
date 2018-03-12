package loanCalculator;

import java.text.DecimalFormat;

public class LoanCalcLogic {


	private final Double principal;        
	private final Double interestRateValue;
	private Double totalInterest = 0.0;     
	private Double monthlyInterest;   // The amount of interest per each monthly payment
	private Double interest;        
	private Double calcPayment;       // Monthly payments
	private Double principalPerMonth;
	private final int months;               // loan term in months

	DecimalFormat dollar = new DecimalFormat("#,##0.00");
	
	public LoanCalcLogic(String termMosFld, String principalFld, String interestRateFld) {
		months = Integer.parseInt(termMosFld);                      // Loan terms input by user, parsed to Double.
		principal = Double.parseDouble(principalFld);               // Principal input by user, parsed to Double.
		interestRateValue = Double.parseDouble(interestRateFld)/100;    // Interest rate as a number, input by user, parsed to Double.
		printLabels();
		  Double term;
			 term = Math.pow((1+interestRateValue/12.0), months);
		      // Calculates monthly payment
			 calcPayment = (principal * (interestRateValue/12.0) * term) / (term - 1);
		getAmortizationTable();
		
	}

 
 // returns the number of months 	
 
	public int getMonths() {
		return months;
	}


 // returns the principal of the loan.
 
	public String getPrincipal() { 
		
		return dollar.format(principal);
	}

	 
	public Double getInterest() {
		int time = months/12;
		interest = principal * interestRateValue * time;
		return interest;
	}
	
	
	 public String getCalcPayment()
	   {
	      String payment; // calcPayment value formatted to 0.00
			
			payment = dollar.format(calcPayment);
			return payment;
	   }
	 public void printLabels() {
	 System.out.println("Payment" + "\t" + "Total Interest" + "\t" + "Interest" + "\t\t" + "Principal" + "\t" + "Remaining Balance");
	 }
	 
	 // Display the amortization table.
	 public void getAmortizationTable() {
		 Double loanBalance = principal;
     for (int month = 1; month <= months; month++)
     {
    	 loanBalance = loanBalance*(1+(interestRateValue/12));
        // Calculate monthly interest.
        monthlyInterest = loanBalance * (interestRateValue / 12.0);
           principalPerMonth = calcPayment - monthlyInterest;
           
        // Calculate the new loan balance.
        loanBalance = loanBalance - calcPayment;
        totalInterest = monthlyInterest + totalInterest;
        
       
        // Display data for payment number. 
        System.out.println(month +
                           "\t" +
                           dollar.format(totalInterest) +
                           "\t\t" + 
                           dollar.format(monthlyInterest) +
                           "\t\t" +
                           dollar.format(principalPerMonth) +
                           "\t\t" +
                           dollar.format(loanBalance));
     }

	 }
//  Returns total interest
	public String getTotalInterest() {
		
		return dollar.format(totalInterest);
	}
	
}
