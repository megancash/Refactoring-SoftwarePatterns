/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchRecord {

	private JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	JTextField searchByIdField, searchBySurnameField;
	CheckInput check = new CheckInput();
	DisplayRecord display;
	Employee currentEmployee;
	NavigateRecords navigate;
	Color red = new Color(255,150,150);

	public void searchEmployeeById() {
		boolean found = false;

		try {
			if (check.isSomeoneToDisplay()) {
				navigate.firstRecord();
				int firstId = currentEmployee.getEmployeeId();
			
				if (searchByIdField.getText().trim().equals(idField.getText().trim()))
					found = true;
				else if (searchByIdField.getText().trim().equals(Integer.toString(currentEmployee.getEmployeeId()))) {
					found = true;
					display.displayRecord(currentEmployee);
				} else {
					navigate.nextRecord();
					while (firstId != currentEmployee.getEmployeeId()) {
						
						if (Integer.parseInt(searchByIdField.getText().trim()) == currentEmployee.getEmployeeId()) {
							found = true;
							display.displayRecord(currentEmployee);
							break;
						} else
							navigate.nextRecord();
					} 
				} 
				if (!found)
					JOptionPane.showMessageDialog(null, "Employee not found!");
			} 
		} 
		catch (NumberFormatException e) {
			searchByIdField.setBackground(red);
			JOptionPane.showMessageDialog(null, "Wrong ID format!");
		} 
		searchByIdField.setBackground(Color.WHITE);
		searchByIdField.setText("");
	}

	// search Employee by surname
	public void searchEmployeeBySurname() {
		boolean found = false;
		
		if (check.isSomeoneToDisplay()) {
			navigate.firstRecord();
			String firstSurname = currentEmployee.getSurname().trim();
		
			if (searchBySurnameField.getText().trim().equalsIgnoreCase(surnameField.getText().trim()))
				found = true;
			else if (searchBySurnameField.getText().trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
				found = true;
				display.displayRecord(currentEmployee);
			} else {
				navigate.nextRecord();
				while (!firstSurname.trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
					
					if (searchBySurnameField.getText().trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
						found = true;
						display.displayRecord(currentEmployee);
						break;
					} else
						navigate.nextRecord();
				}
			} 
		
			if (!found)
				JOptionPane.showMessageDialog(null, "Employee not found!");
		} 
		searchBySurnameField.setText("");
	}
}
