/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class UpdateOption {
	Actions option = new Actions();
	CheckInput check = new CheckInput();
	RecordDetails cancel = new RecordDetails();

	public boolean change = false;

	void checkoptionclicked(ActionEvent e, JButton menuItem) {
		if (e.getSource() == menuItem) {
			returnAction(option);
		}
	}

	void returnAction(Actions option) {
	}
}
class CancelChanges extends UpdateOption {
	@Override
	void returnAction(Actions fileOption) {
		cancel.cancelChange();
	}
}


class SaveChanges extends UpdateOption {
	@Override
	void returnAction(Actions option) {
		if (check.checkInput() && !check.checkForChanges())
			;
	}
}


