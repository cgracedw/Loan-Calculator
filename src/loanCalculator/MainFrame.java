package loanCalculator;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
	
	private InfoInputPanel infoInputPanel;
	private InfoOutputPanel infoOutputPanel;
	
	
	private String principalFld;    // Principal input by user
	private String termMosFld;      // Months input by user
	private String interestRateFld; // Interest rate number input by user
	
	private Double monthlyPayments; // Monthly payments
	private Double totalInterest;   // total interest for the entire loan
	private Double principal;       // loan principal
	private Double updatedTotalDue; // The amount of loan left after each payment
	private Double monthlyInterest; // The amount of interest per each monthly payment
	
	private int months;             // loan term in months
	
/////////////////////////////////////////////////////////
private Double interest;          // interest
private Double updatedPrincipal; 
private Double principalBalance;

private Double calcPayment;
///////////////////////////////////////////////////////
	
	private JButton calculate;
	
	private JButton showAmortTable;
	
	public MainFrame(String LoanCalculator) {
		super(LoanCalculator); 
		
		//layout manager
		setLayout(new BorderLayout());
		
		
		//Swing components
		
		infoInputPanel = new InfoInputPanel(); 
		infoOutputPanel = new InfoOutputPanel();
		
			
		calculate = new JButton("Calculate");
		
		showAmortTable = new JButton("Amortization Table");
			
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				principalFld = infoInputPanel.getPrincipal();
				System.out.println(principalFld);
				
				termMosFld = infoInputPanel.getMonths();
				System.out.println(termMosFld);
				
				interestRateFld = infoInputPanel.getInterestRate();		
				System.out.println(interestRateFld);
				
				LoanCalcLogic loanCalcLogic = new LoanCalcLogic(termMosFld, principalFld, interestRateFld);
				
				calcPayment = loanCalcLogic.getCalcPayment();
				
				monthlyPayments = loanCalcLogic.getMonthlyPayments();
				System.out.println(monthlyPayments);
				
				totalInterest = loanCalcLogic.getTotalInterest();
				System.out.println(totalInterest);
				
				months = loanCalcLogic.getMonths();
				System.out.println(months);
				
				principal = loanCalcLogic.getPrincipal();
				System.out.println(principal);
				
			//	updatedTotalDue = loanCalcLogic.getUpdatedTotalDue();
			//	System.out.println(updatedTotalDue);
				
			//	monthlyInterest = loanCalcLogic.getMonthlyInterest();
				
				infoOutputPanel.setValues(monthlyPayments, totalInterest, principal);
				
		//		principalBalance = loanCalcLogic.getPrincipalBalance();
		//		System.out.println("This is principalBalance" + principalBalance);
				
				interest = loanCalcLogic.getInterest();
				System.out.println("this is interest" + interest);
				
				
			}
 
		}); 
		
		showAmortTable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getActionCommand().equals("Amortization Table")) {
					
				}
				
			}
			
		}
				);
		
		//Add Swing components to content pane
		
		Container c = getContentPane();
		c.add(infoOutputPanel, BorderLayout.EAST);
		c.add(infoInputPanel, BorderLayout.WEST);
		c.add(calculate, BorderLayout.SOUTH);
		c.add(showAmortTable, BorderLayout.NORTH);
	}
	

}
		
	/*	showAmortTable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
		/*		if (event.getActionCommand().equals("Amortization Table")) {
					
					AmortizationTable aFrame = new AmortizationTable();
	//				JFrame amortFrame = new JFrame("Amortization Table");
				    SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						aFrame.pack();
						aFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
						aFrame.setVisible(true);
						
				
				
			});
					
		}
				
				    
			}
		//Add Swing components to content pane
		
		Container c = getContentPane();
		c.add(infoOutputPanel, BorderLayout.EAST);
		c.add(infoInputPanel, BorderLayout.WEST);
		c.add(calculate, BorderLayout.SOUTH);
		c.add(showAmortTable, BorderLayout.NORTH);
	}
	

		}
} */