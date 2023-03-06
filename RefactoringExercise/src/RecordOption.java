/* Student Name: Megan Cash
 * Student Number: C19317723
 * */

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

public class RecordOption {
	CheckInput check = new CheckInput();
	EmployeeDetails parent;
	Employee currentEmployee;
	RecordDetails recordDetails;
	
	

	void checkOptionClicked(ActionEvent e, JMenuItem first, JMenuItem second) {
		if (e.getSource() == first || e.getSource() == second) {
			if (check.checkInput() && !check.checkForChanges())
				returnAction(recordDetails);
		}
	}

	void returnAction(RecordDetails recordDetails) {
	}

	void returnAction(EmployeeDetails parent) {

	}
}

class AddRecord extends RecordOption {
	@Override
	void returnAction(EmployeeDetails parent) {
		new AddRecordDialog(parent);
	}
}

class ModifyRecord extends RecordOption {
	@Override
	void returnAction(RecordDetails recordDetails) {
		recordDetails.editDetails();
	}
}

class DeleteRecord extends RecordOption {
	@Override
	void returnAction(RecordDetails recordDetails) {
		recordDetails.deleteRecord();
	}
}
