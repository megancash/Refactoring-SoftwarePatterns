/* Student Name: Megan Cash
 * Student Number: C19317723
 * */

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

abstract class FileOption {
	Actions option = new Actions();
	CheckInput check = new CheckInput();

	public boolean change = false;

	void checkOptionClicked(ActionEvent e, JMenuItem menuItem) {
		if (e.getSource() == menuItem) {
			if (check.checkInput() && !check.checkForChanges())
				returnAction(option);
		}
	}

	void returnAction(Actions option) {
	}
}

class OpenFile extends FileOption {
	@Override
	void returnAction(Actions option) {
		option.openFile();
	}
}

class SaveAs extends FileOption {
	@Override
	void returnAction(Actions option) {
		option.saveFileAs();
		change = false;
	}
}

class SaveFile extends FileOption {
	@Override
	void returnAction(Actions option) {
		option.saveFile();
		change = false;
	}
}



