/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.awt.Color;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckInput {

	
	File file;
	InputField edit;
	DisplayRecord display;
	Actions save;
	Employee currentEmployee;
	RandomFile application = new RandomFile();
	Color red = new Color(255,150,150);
	JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	private boolean change = false;
	long currentByteStart = 0;
	

	// check if any of records in file is active - ID is not 0
	public boolean isSomeoneToDisplay() {
		boolean someoneToDisplay = false;
		application.openReadFile(file.getAbsolutePath());
		someoneToDisplay = application.isSomeoneToDisplay();
		application.closeReadFile();
		if (!someoneToDisplay) {
			emptyTextFields();
			JOptionPane.showMessageDialog(null, "No Employees are registered!");
		}
		return someoneToDisplay;
	}

	public void emptyTextFields() {
		currentEmployee = null;
		idField.setText("");
		ppsField.setText("");
		surnameField.setText("");
		firstNameField.setText("");
		salaryField.setText("");
		genderCombo.setSelectedIndex(0);
		departmentCombo.setSelectedIndex(0);
		fullTimeCombo.setSelectedIndex(0);
	}

	// check for correct PPS format and look if PPS already in use
	public boolean correctPps(String pps, long currentByte) {
		boolean ppsExist = false;

		if (pps.length() == 8 || pps.length() == 9) {
			if (Character.isDigit(pps.charAt(0)) && Character.isDigit(pps.charAt(1)) && Character.isDigit(pps.charAt(2))
					&& Character.isDigit(pps.charAt(3)) && Character.isDigit(pps.charAt(4))
					&& Character.isDigit(pps.charAt(5)) && Character.isDigit(pps.charAt(6))
					&& Character.isLetter(pps.charAt(7)) && (pps.length() == 8 || Character.isLetter(pps.charAt(8)))) {

				application.openReadFile(file.getAbsolutePath());

				ppsExist = application.isPpsExist(pps, currentByte);
				application.closeReadFile();
			} else
				ppsExist = true;
		} else
			ppsExist = true;

		return ppsExist;
	}
	
	// check if any changes text field where made
	public boolean checkForChanges() {
		boolean anyChanges = false;
		if (change) {
			save.saveChanges();
			anyChanges = true;
		}

		else {
			edit.setEnabled(false);
			display.displayRecord(currentEmployee);
		}

		return anyChanges;
	}

	// check if file name has extension .dat
	public boolean checkFileName(File name) {
		boolean checkFile = false;
		int length = name.toString().length();
		if (name.toString().charAt(length - 4) == '.' && name.toString().charAt(length - 3) == 'd'
				&& name.toString().charAt(length - 2) == 'a' && name.toString().charAt(length - 1) == 't')
			checkFile = true;
		return checkFile;
	}

	public boolean checkInput() {
		boolean valid = true;

		if (ppsField.isEditable() && ppsField.getText().trim().isEmpty()) {
			ppsField.setBackground(red);
			valid = false;
		} 

		if (ppsField.isEditable() && correctPps(ppsField.getText().trim(), currentByteStart)) {
			ppsField.setBackground(red);
			valid = false;
		} 
		if (surnameField.isEditable() && surnameField.getText().trim().isEmpty()) {
			surnameField.setBackground(red);
			valid = false;
		} 
		if (firstNameField.isEditable() && firstNameField.getText().trim().isEmpty()) {
			firstNameField.setBackground(red);
			valid = false;
		} 
		if (genderCombo.getSelectedIndex() == 0 && genderCombo.isEnabled()) {
			genderCombo.setBackground(red);
			valid = false;
		} 
		if (departmentCombo.getSelectedIndex() == 0 && departmentCombo.isEnabled()) {
			departmentCombo.setBackground(red);
			valid = false;
		} 
		try {
			Double.parseDouble(salaryField.getText());
			// check if salary is greater than 0
			if (Double.parseDouble(salaryField.getText()) < 0) {
				salaryField.setBackground(red);
				valid = false;
			}
		}
		catch (NumberFormatException num) {
			if (salaryField.isEditable()) {
				salaryField.setBackground(red);
				valid = false;
			}
		}
		if (fullTimeCombo.getSelectedIndex() == 0 && fullTimeCombo.isEnabled()) {
			fullTimeCombo.setBackground(red);
			valid = false;
		} 
			// display message if any input or format is wrong
		if (!valid)
			JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
		// set text field to white colour if text fields are editable
		if (ppsField.isEditable())
			edit.setToWhite();

		return valid;
	}
}
