/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

public class CloseOption {

	CheckInput check = new CheckInput();
	Actions option = new Actions();
	

	void checkOptionClicked(ActionEvent e, JMenuItem menuItem) {
		if (e.getSource() == menuItem) {
			if (check.checkInput() && !check.checkForChanges())
				returnAction(option);
		}
	}

	void returnAction(Actions option) {
	}
}

class CloseApp extends CloseOption {
	@Override
	void returnAction(Actions option) {
		option.exitApp();
	}
}
