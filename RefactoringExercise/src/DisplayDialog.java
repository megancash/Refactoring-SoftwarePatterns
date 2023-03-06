/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
public class DisplayDialog {

	EmployeeDetails parent;
	CheckInput checkInput = new CheckInput();
	RecordDetails displayeEmployeeRecords = new RecordDetails();

	public void displayEmployeeSummaryDialog() {
		// display Employee summary dialog if these is someone to display
		//if (checkInput.isSomeoneToDisplay())
			//new EmployeeSummaryDialog(displayeEmployeeRecords.getAllEmloyees());
	}
	
	// display search by surname dialog
		public void displaySearchBySurnameDialog() {
			if (checkInput.isSomeoneToDisplay())
				new SearchBySurnameDialog(parent);
		}

	// display search by ID dialog
	public void displaySearchByIdDialog() {
		if (checkInput.isSomeoneToDisplay())
			new SearchByIdDialog(parent);
	}

	
}
