/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class InputField {

	JButton searchId, searchSurname, saveChange, cancelChange;
	JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	JTextField idField, ppsField, surnameField, firstNameField, salaryField, searchByIdField, searchBySurnameField;
	JTextField[] textFields = { idField, ppsField, surnameField, firstNameField, salaryField };
	JComboBox[] comboBoxes = { genderCombo, departmentCombo, fullTimeCombo };

	// set text field background colour to white
	public void setToWhite() {

		for (int i = 0; i <= textFields.length; i++) {
			textFields[i].setBackground(Color.WHITE);
		}

		for (int i = 0; i <= comboBoxes.length; i++) {
			comboBoxes[i].setBackground(Color.WHITE);
		}
	}

	// enable text fields for editing
	public void setEnabled(boolean booleanValue) {

		boolean search;
		if (booleanValue)
			search = false;
		else
			search = true;

		setEnabledTextFields(booleanValue, search);
		setEnabledComboBoxes(booleanValue);
		setEnabledButtons(booleanValue, search);
	}

	public void setEnabledTextFields(boolean booleanValue, boolean search) {
		JTextField[] textFieldAll = { idField, ppsField, surnameField, firstNameField, salaryField, searchByIdField,
				searchBySurnameField };

		for (int i = 0; i <= textFields.length; i++) {
			if (textFieldAll[i] == searchByIdField || textFieldAll[i] == searchBySurnameField) {
				textFieldAll[i].setEnabled(search);
			} else {
				textFieldAll[i].setEditable(booleanValue);
			}
		}
	}

	public void setEnabledComboBoxes(boolean booleanValue) {
		for (int i = 0; i <= comboBoxes.length; i++) {
			comboBoxes[i].setEnabled(booleanValue);
		}
	}

	public void setEnabledButtons(boolean booleanValue, boolean search) {
		JButton[] btn = { saveChange, cancelChange, searchId, searchSurname };
		for (int i = 0; i <= btn.length; i++) {

			if (btn[i] == saveChange || btn[i] == cancelChange) {
				btn[i].setVisible(booleanValue);
			} else {
				btn[i].setEnabled(search);
			}
		}
	}
}

