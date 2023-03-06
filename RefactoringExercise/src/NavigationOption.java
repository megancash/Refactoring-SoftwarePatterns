/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JMenuItem;

public class NavigationOption {

	Employee currentEmployee;
	DisplayRecord empRecord;
	NavigateRecords navigate;
	SearchRecord search;

	DisplayDialog displayDialog = new DisplayDialog();
	CheckInput check = new CheckInput();
	

	void checkOptionClickedSearch(ActionEvent e, JMenuItem first) {
		if (e.getSource() == first) {
			if (check.checkInput() && !check.checkForChanges())
				returnActionDialogs(displayDialog);
		}
	}

	void checkOptionClicked(ActionEvent e, JMenuItem first, JButton second) {
		if (e.getSource() == first || e.getSource() == second) {
			if (check.checkInput() && !check.checkForChanges())
				returnAction(navigate);
			empRecord.displayRecord(currentEmployee);

		}
	}


	void returnAction(NavigateRecords navigate) {
	}

	void returnActionDialogs(DisplayDialog displayDialog) {
	}

	void returnActionDialogs() {
	}

}

class SearchById extends NavigationOption {
	@Override
	void returnActionDialogs(DisplayDialog displayDialog) {

		displayDialog.displaySearchByIdDialog();
	}
}

class SearchBySurname extends NavigationOption {

	EmployeeDetails parent;

	@Override
	void returnActionDialogs(DisplayDialog displayDialog) {
		displayDialog.displaySearchByIdDialog();
	}

	@Override
	void returnActionDialogs() {

		new SearchBySurnameDialog(parent);
	}
}

class DisplayEmployees extends NavigationOption {
	@Override
	void returnActionDialogs(DisplayDialog displayDialog) {

		if (check.isSomeoneToDisplay())
			displayDialog.displayEmployeeSummaryDialog();
	}
}

class FirstRecord extends NavigationOption {
	@Override
	void returnAction(NavigateRecords navigate) {
		navigate.firstRecord();
	}
}

class NextRecord extends NavigationOption {
	@Override
	void returnAction(NavigateRecords navigate) {
		navigate.nextRecord();
	}
}

class PreviousRecord extends NavigationOption {
	@Override
	void returnAction(NavigateRecords navigate) {
		navigate.previousRecord();
	}
}

class LastRecord extends NavigationOption {
	@Override
	void returnAction(NavigateRecords navigate) {
		navigate.lastRecord();
	}
}
