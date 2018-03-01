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
	
	
	private String principalFld;
	private String termYrsFld;
	private String termMosFld;
	private String interestRateFld;
	
	private Double interestPercent;
	private Double principalValue;
	private Double monthlyPayments;
	private Double totalInterest;
	private Double totalPrincipal;
	private Double updatedPrincipal;
	private Double monthlyInterest;
	
	private int termMonths;
	private int loanTermMosValue;
	
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
				
				monthlyPayments = loanCalcLogic.getMonthlyPayments();
				System.out.println(monthlyPayments);
				
				totalInterest = loanCalcLogic.getTotalInterest();
				System.out.println(totalInterest);
				
				termMonths = loanCalcLogic.getTermMonths();
				System.out.println(termMonths);
				
				totalPrincipal = loanCalcLogic.getTotalPrincipal();
				System.out.println(totalPrincipal);
				
				updatedPrincipal = loanCalcLogic.getUpdatedPrincipal();
				System.out.println(updatedPrincipal);
				
				monthlyInterest = loanCalcLogic.getMonthlyInterest();
				
				infoOutputPanel.setValues(monthlyPayments, totalInterest, totalPrincipal);
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