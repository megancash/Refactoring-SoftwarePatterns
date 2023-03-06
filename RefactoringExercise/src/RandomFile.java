/* Student Name: Megan Cash
 * Student Number: C19317723
 * This class is for accessing, creating and modifying records in a file
 * 
 * */

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RandomFile {
	private RandomAccessFile output, input;


	// Create new file
	public void createFile(String fileName) {
		RandomAccessFile file = null;

		try 
		{
			file = new RandomAccessFile(fileName, "rw");

		} 
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error processing the file!");
			System.exit(1);
		}

		finally {
			try {
				if (file != null)
					file.close(); 
			} 
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(null, "Error closing the file!");
				System.exit(1);
			} 
		} 
	} 

	// Open file for adding or changing records
	public void openWriteFile(String fileName) {
		try 
		{
			output = new RandomAccessFile(fileName, "rw");
		} 
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error, File does not exist!");
		} }

	// Close file for adding or changing records
	public void closeWriteFile() {
		try 
		{
			if (output != null)
				output.close();
		}
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error closing file!");
			System.exit(1);
		}
	} 

	// Add records to file
	public long addRecords(Employee employeeToAdd) {
		Employee newEmployee = employeeToAdd;
		long currentRecordStart = 0;

		RandomAccessEmployeeRecord record;

		try 
		{
			record = new RandomAccessEmployeeRecord(newEmployee.getEmployeeId(), newEmployee.getPps(),
					newEmployee.getSurname(), newEmployee.getFirstName(), newEmployee.getGender(),
					newEmployee.getDepartment(), newEmployee.getSalary(), newEmployee.getFullTime());

			output.seek(output.length());
			record.write(output);
			currentRecordStart = output.length();
		} 
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error writing to file!");
		} 

		return currentRecordStart - RandomAccessEmployeeRecord.SIZE;
	}

	// Change details for existing object
	public void changeRecords(Employee newDetails, long byteToStart) {
		long currentRecordStart = byteToStart;

		RandomAccessEmployeeRecord record;
		Employee oldDetails = newDetails;
		try 
		{
			record = new RandomAccessEmployeeRecord(oldDetails.getEmployeeId(), oldDetails.getPps(),
					oldDetails.getSurname(), oldDetails.getFirstName(), oldDetails.getGender(),
					oldDetails.getDepartment(), oldDetails.getSalary(), oldDetails.getFullTime());

			output.seek(currentRecordStart);
			record.write(output);
		} 
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error writing to file!");
		} 
	}

	// Delete existing object
	public void deleteRecords(long byteToStart) {
		long currentRecordStart = byteToStart;

		RandomAccessEmployeeRecord record;
		

		try 
		{
			record = new RandomAccessEmployeeRecord();
			output.seek(currentRecordStart);
			record.write(output);
		} 
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error writing to file!");
		} 
	}

	// Open file for reading
	public void openReadFile(String fileName) {
		try 
		{
			input = new RandomAccessFile(fileName, "r");
		} 
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "File is not supported!");
		} 
	}

	// Close file
	public void closeReadFile() {
		try 
		{
			if (input != null)
				input.close();
		} 
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error closing file!");
			System.exit(1);
		} 
	} 

	// Get position of first record in file
	public long getFirst() {
		long byteToStart = 0;

		try {
			input.length();
		} 
		catch (IOException e) {
		}
		
		return byteToStart;
	}

	// Get position of last record in file
	public long getLast() {
		long byteToStart = 0;

		try {
			byteToStart = input.length() - RandomAccessEmployeeRecord.SIZE;
		}
		catch (IOException e) {
		}

		return byteToStart;
	}

	// Get position of next record in file
	public long getNext(long readFrom) {
		long byteToStart = readFrom;

		try {
			input.seek(byteToStart);
			// if next position is end of file go to start of file, else get next position
			if (byteToStart + RandomAccessEmployeeRecord.SIZE == input.length())
				byteToStart = 0;
			else
				byteToStart = byteToStart + RandomAccessEmployeeRecord.SIZE;
		} 
		catch (NumberFormatException e) {
		} 
		catch (IOException e) {
		}
		return byteToStart;
	}

	// Get position of previous record in file
	public long getPrevious(long readFrom) {
		long byteToStart = readFrom;

		try {
			input.seek(byteToStart);
		
			if (byteToStart == 0)
				byteToStart = input.length() - RandomAccessEmployeeRecord.SIZE;
			else
				byteToStart = byteToStart - RandomAccessEmployeeRecord.SIZE;
		} 
		catch (NumberFormatException e) {
		} 
		catch (IOException e) {
		}
		return byteToStart;
	}

	// Get object from file in specified position
	public Employee readRecords(long byteToStart) {
		Employee thisEmp = null;
		RandomAccessEmployeeRecord record = new RandomAccessEmployeeRecord();

		try {
			input.seek(byteToStart);
			record.read(input);
		}
		catch (IOException e) {
		}
		
		thisEmp = record;
		return thisEmp;
	}

	// Check if PPS Number already in use
	public boolean isPpsExist(String pps, long currentByteStart) {
		RandomAccessEmployeeRecord record = new RandomAccessEmployeeRecord();
		boolean ppsExist = false;
		long oldByteStart = currentByteStart;
		long currentByte = 0;

		try {
			while (currentByte != input.length() && !ppsExist) {
				
				if (currentByte != oldByteStart) {
					input.seek(currentByte);
					record.read(input);
					
					if (record.getPps().trim().equalsIgnoreCase(pps)) {
						ppsExist = true;
						JOptionPane.showMessageDialog(null, "PPS number already exist!");
					}
				}
				currentByte = currentByte + RandomAccessEmployeeRecord.SIZE;
			}
		} 
		catch (IOException e) {
		}

		return ppsExist;
	}

	// Check if any record contains valid ID - greater than 0
	public boolean isSomeoneToDisplay() {
		boolean someoneToDisplay = false;
		long currentByte = 0;
		RandomAccessEmployeeRecord record = new RandomAccessEmployeeRecord();

		try {
			
			while (currentByte != input.length() && !someoneToDisplay) {
				input.seek(currentByte);
				record.read(input);
				
				if (record.getEmployeeId() > 0)
					someoneToDisplay = true;
				currentByte = currentByte + RandomAccessEmployeeRecord.SIZE;
			}
		}
		catch (IOException e) {
		}

		return someoneToDisplay;
	}
}