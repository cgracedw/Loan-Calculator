package loanCalculator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoanCalculator extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new MainFrame("Loan Calculator");
	    SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			frame.pack();
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setVisible(true);
			
		}
	});

	
	}
	
}
