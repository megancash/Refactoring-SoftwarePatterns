/* Student Name: Megan Cash
 * Student Number: C19317723
 * */

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

public class SearchOption {

	CheckInput check = new CheckInput();
	Employee currentEmployee;
	SearchRecord serach;
	
	

	void checkoptionclicked(ActionEvent e, JMenuItem first, JMenuItem secound) {
		if (e.getSource() == first || e.getSource() == secound) {

			returnAction(serach);
		}
	}

	void returnAction(SearchRecord search) {

	}
}
class SearchSurname extends SearchOption {
	@Override
	void returnAction(SearchRecord search) {
		serach.searchEmployeeBySurname();
	}

class SearchId extends SearchOption {
	@Override
	void returnAction(SearchRecord search) {
		serach.searchEmployeeById();
	}
}}
