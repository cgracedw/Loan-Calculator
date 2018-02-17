package loanCalculator;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoOutputPanel extends JPanel {
	
	private JLabel monthlyPaymentsLabel;
	private JLabel totalPrincPaidLabel;
	private JLabel totalIntPaidLabel;
	
	private JTextField monthlyPaymentsFld;
	private JTextField totalPrincPaidFld;
	private JTextField totalIntPaidFld;
	
	public void setValues(Double monthlyPayments, Double totalInterest, Double totalPrincipal) {
		monthlyPaymentsFld.setText(monthlyPayments.toString());
		totalPrincPaidFld.setText(totalPrincipal.toString());
		totalIntPaidFld.setText(totalInterest.toString());
	}
		public InfoOutputPanel() {
			Dimension size = getPreferredSize();
			size.width = 320;
			setPreferredSize(size);
			
			monthlyPaymentsLabel = new JLabel("Monthly Payments: $");
			totalPrincPaidLabel = new JLabel("Total Principal Paid: $");
			totalIntPaidLabel = new JLabel("Total Interest Paid: $");
			
			monthlyPaymentsFld = new JTextField(10);
			totalPrincPaidFld = new JTextField(10);
			totalIntPaidFld = new JTextField(10);
			
			monthlyPaymentsFld.setEnabled(false);
			 totalPrincPaidFld.setEnabled(false);
			 totalIntPaidFld.setEnabled(false);
			 
			 
			setLayout(new GridBagLayout());
			
			GridBagConstraints gc = new GridBagConstraints();
			
			/////Column One///////////////////////////
			
			gc.anchor = GridBagConstraints.LINE_END;
			gc.weightx = 0.5;
			gc.weighty = 0.5;
			
			gc.gridx = 0;
			gc.gridy = 0;
			add(monthlyPaymentsLabel, gc);
			
			gc.gridx = 0;
			gc.gridy = 1;
			add(totalPrincPaidLabel, gc);
			
			gc.gridx = 0;
			gc.gridy = 2;
			add(totalIntPaidLabel, gc);
			
			/////Column Two///////////////////////////
			
			gc.anchor = GridBagConstraints.LINE_START;
			gc.gridx = 1;
			gc.gridy = 0;
			add(monthlyPaymentsFld, gc);
			
			gc.gridx = 1;
			gc.gridy = 1;
			add(totalPrincPaidFld, gc);
			
			gc.gridx = 1;
			gc.gridy = 2;
			add(totalIntPaidFld, gc);
			
		}
}
