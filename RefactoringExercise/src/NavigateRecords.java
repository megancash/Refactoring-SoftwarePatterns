/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.io.File;

public class NavigateRecords {

	Employee currentEmployee;
	CheckInput check = new CheckInput();
	private RandomFile application = new RandomFile();
	private long currentByteStart = 0;
	private File file;
	
	

	// find byte start in file for first active record
	public void firstRecord() {
	
		if (check.isSomeoneToDisplay()) {
			
			application.openReadFile(file.getAbsolutePath());
			currentByteStart = application.getFirst();
			currentEmployee = application.readRecords(currentByteStart);
			application.closeReadFile();
			
			if (currentEmployee.getEmployeeId() == 0)
				nextRecord();
		} 
	} 

	// find byte start in file for previous active record
	public void previousRecord() {
		// if any active record in file look for first record
		if (check.isSomeoneToDisplay()) {
	
			application.openReadFile(file.getAbsolutePath());
			currentByteStart = application.getPrevious(currentByteStart);
			currentEmployee = application.readRecords(currentByteStart);
			while (currentEmployee.getEmployeeId() == 0) {
				currentByteStart = application.getPrevious(currentByteStart);
				currentEmployee = application.readRecords(currentByteStart);
			} 
			application.closeReadFile();
		}
	}

	// find byte start in file for next active record
	public void nextRecord() {
		
		if (check.isSomeoneToDisplay()) {
		
			application.openReadFile(file.getAbsolutePath());
			currentByteStart = application.getNext(currentByteStart);
			currentEmployee = application.readRecords(currentByteStart);
			while (currentEmployee.getEmployeeId() == 0) {
				currentByteStart = application.getNext(currentByteStart);
				currentEmployee = application.readRecords(currentByteStart);
			} 
			application.closeReadFile();
		}
	}

	// find byte start in file for last active record
	public void lastRecord() {
		
		if (check.isSomeoneToDisplay()) {

			application.openReadFile(file.getAbsolutePath());
			currentByteStart = application.getLast();
			currentEmployee = application.readRecords(currentByteStart);
			application.closeReadFile();
		
			if (currentEmployee.getEmployeeId() == 0)
				previousRecord();
		}
	}
}
