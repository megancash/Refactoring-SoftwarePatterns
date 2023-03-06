import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
public class DisplayRecord {

	JTextField searchByIdField, searchBySurnameField;

	private boolean change = false;

	private static final DecimalFormat format = new DecimalFormat("\u20ac ###,###,##0.00");
	String[] department = { "", "Administration", "Production", "Transport", "Management" };
	String[] gender = { "", "M", "F" };
	String[] fullTime = { "", "Yes", "No" };

	private JButton first, previous, next, last, add, edit, deleteButton, displayAll, searchId, searchSurname, saveChange, cancelChange;
	private JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	private JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;

	// display current Employee details
	public void displayRecord(Employee thisEmployee) {
		boolean found = false;
		int countDepartment = 0;
		int countGender = 0;
		
		

		searchByIdField.setText("");
		searchBySurnameField.setText("");

		if (thisEmployee == null || thisEmployee.getEmployeeId() == 0) {
		} else {

			findGenderValue(countGender, found, thisEmployee);
			found = false;
			findDeptartmentValue(countDepartment, found, thisEmployee);
			setFields(thisEmployee, countDepartment, countGender);
			// set corresponding full time combo box value to current employee
			if (thisEmployee.getFullTime() == true)
				fullTimeCombo.setSelectedIndex(1);
			else
				fullTimeCombo.setSelectedIndex(2);
		}
		change = false;
	}

	public void setFields(Employee thisEmployee, int countGender, int countDep) {
		idField.setText(Integer.toString(thisEmployee.getEmployeeId()));
		ppsField.setText(thisEmployee.getPps().trim());
		surnameField.setText(thisEmployee.getSurname().trim());
		firstNameField.setText(thisEmployee.getFirstName());
		salaryField.setText(format.format(thisEmployee.getSalary()));

	}
	
	// find corresponding department combo box value to current employee
	public void findDeptartmentValue(int countDep, boolean found, Employee thisEmployee) {
		while (!found && countDep < department.length - 1) {
			if (thisEmployee.getDepartment().trim().equalsIgnoreCase(department[countDep]))
				found = true;
			else
				countDep++;
		}
	}

	// find corresponding gender combo box value to current employee
	public void findGenderValue(int countGender, boolean found, Employee thisEmployee) {
		while (!found && countGender < gender.length - 1) {
			if (Character.toString(thisEmployee.getGender()).equalsIgnoreCase(gender[countGender]))
				found = true;
			else
				countGender++;
		}
	}


}
