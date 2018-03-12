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

	private JButton calculate;
	
	public MainFrame(String LoanCalculator) {
		super(LoanCalculator); 
		
		//layout manager
		setLayout(new BorderLayout());
		
		
		//Swing components
		
		infoInputPanel = new InfoInputPanel(); 
		infoOutputPanel = new InfoOutputPanel();
		
			
		calculate = new JButton("Calculate");
			
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				principalFld = infoInputPanel.getPrincipal();
				
				termMosFld = infoInputPanel.getMonths();
				
				interestRateFld = infoInputPanel.getInterestRate();		
				
				LoanCalcLogic loanCalcLogic = new LoanCalcLogic(termMosFld, principalFld, interestRateFld);
				
				String calcPayment = loanCalcLogic.getCalcPayment();
				
				String totalInterest = loanCalcLogic.getTotalInterest();
				
				
				String principal = loanCalcLogic.getPrincipal();
				
				infoOutputPanel.setValues(calcPayment, totalInterest, principal);
	
				
				
			}
 
		}); 

		//Add Swing components to content pane
		
		Container c = getContentPane();
		c.add(infoOutputPanel, BorderLayout.EAST);
		c.add(infoInputPanel, BorderLayout.WEST);
		c.add(calculate, BorderLayout.SOUTH);
	}
	

}