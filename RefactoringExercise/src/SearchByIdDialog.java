/* Student Name: Megan Cash
 * Student Number: C19317723
 * This is the dialog for Employee search by ID
 * */

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SearchByIdDialog extends JDialog implements ActionListener {
	Color red = new Color(255,150,150);
	EmployeeDetails parent;
	JButton search, cancel;
	JTextField searchField;
	Font font1 = new Font("SansSerif", Font.BOLD, 16);
	JTextField searchByIdField;
	SearchRecord searchId;
	SearchPanel searchPanel;

	// constructor for SearchByIdDialog
	public SearchByIdDialog(EmployeeDetails employeeDetails) {
		setTitle("Search by Id");
		JScrollPane scrollPane = new JScrollPane(searchPane());
		setContentPane(scrollPane);
		searchPanel.search();

	}

	// initialize search container
	public Container searchPane() {
		JPanel searchPanel = new JPanel(new GridLayout(3, 1));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel searchLabel;

		searchPanel.add(new JLabel("Search by ID"));
		textPanel.add(searchLabel = new JLabel("Enter ID:"));

		return searchPanel;
	}

	// action listener for save and cancel button
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == search) {
			
			try {
				Double.parseDouble(searchField.getText());
				searchByIdField.setText(searchField.getText());
				searchId.searchEmployeeById();
				dispose();
			} 
			catch (NumberFormatException num) {
				
				searchField.setBackground(red);
				JOptionPane.showMessageDialog(null, "Wrong ID format!");
			} 
		} 
		
		else if (e.getSource() == cancel)
			dispose();
	}
}
