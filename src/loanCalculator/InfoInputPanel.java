package loanCalculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class InfoInputPanel extends JPanel {
	
	private JLabel principal;
	private JLabel loanTermYrs;
	private JLabel or;
	private JLabel loanTermMos;
	private JLabel interestRate;
	
	private JTextField principalFld;
	private JTextField termYrsFld;
	private JTextField termMosFld;
	private JTextField interestRateFld;
	
	public String getPrincipal() {
		return principalFld.getText();
	}
	
	public String getYears() {
		return termYrsFld.getText();
	}
	
	public String getMonths() {
		return termMosFld.getText();
	}
	
	public String getInterestRate() {
		return interestRateFld.getText();
	}
	
	public InfoInputPanel() {
		Dimension size = getPreferredSize();
		size.width = 320;
		size.height = 320;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		principal = new JLabel("Loan Amount: ");
		loanTermYrs = new JLabel("Loan Term in Years: ");
		or = new JLabel("or");
		loanTermMos = new JLabel("Loan Terms in Months: ");
		interestRate = new JLabel("Interest Rate: ");
		
		principalFld = new JTextField(10);
		termYrsFld = new JTextField(10);
		termMosFld = new JTextField(10);
		interestRateFld = new JTextField(10);
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//// first column //////////////////////////
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(principal, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(loanTermYrs, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(or,gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(loanTermMos, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(interestRate, gc);
		
		////Second Column////////////////////////////
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(principalFld, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(termYrsFld, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(termMosFld, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(interestRateFld, gc);
				
	}
	
}

	
