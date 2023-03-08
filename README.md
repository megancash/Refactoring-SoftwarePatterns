# Refactoring Assessment Software Patterns

The series of refactoring’s applied to the code:
___________________________________________________
1:

•	Why and how I applied the refactoring: 

When I first Imported the project into eclipse I was getting an error within the Container SummaryPane within the EmployeeSummaryDialog class. 
I then created a Vector of Vectors from the Vector objects which contained all Employees details to resolve this error.
_________________________________________________
 
 
2: Extract Method and Extract class while also improving names and locations of code

•	Why and how I applied the refactoring: 

With many of the original classes from the RefactoringExercise2023 there was a lot going on within each one. In terms of refactoring, I focused on moving features between objects. Adding all the common features to a new class.  
A few examples:
-	CancelChanges & SaveChanges from EmployeeDetails is now in the UpdateOption class.
-	searchEmployeeById & SearchEmployeeBySurname from EmployeeDetails is now in the SearchRecord class
-	The SearchPanel method from the EmployeeDetails is now in its own class (SearchPanel).
New classes created:
-	ActionPerformed - Is for whenever an action is performed by the user.
-	Actions - For when the user selects the File Option, they will be able to open a file, save a file, save changes, save file as or exit the application.
-	ApplicationPanels - For the navigation panel, search panel and buttons panel.
-	CheckInput – Which is for checking the input in the text fields
-	CloseOption – To close the application/window.
-	DisplayDialog – To display the dialog to the user
-	DisplayRecord – To display the employee records to the user.
-	FileOption – An abstract class of the file option so that the other classes can share the methods.
-	InputField  - For the edit text fields that the user inputs into.
-	JMenuBar -Contains the JMenu objects for when a user selects from a popup of JMenuItems.
-	NavigateRecords – To be able to navigate to the next, previous, first or last record.
-	NavigationOption – For the user to be able to search an employee by surname/ID and they can also click the button to display an employee summary or the navigation buttons (first, last, next, previous)
-	RecordDetails – To allow the user to update the details, cancel any changes, retrieve details, delete details or add.
-	RecordOption – Allows the user to do one of the following options add an employee record, modify an employee record and delete a record
-	SearchOption – This is for the SearchBySurname and SearchById classes.
-	SearchRecord
-	UpdateOption
I decided to do this to try improve the applications overall design and make it easier to understand as there were a lot of large classes and long methods. However, I was not able to get my application running. I kept getting errors in the AddRecordDialog class and the EmployeeDetails class. So for submission I just left all of the original content within these classes so it would be able to run. The other classes contain the code that I had hoped to have been working correctly.
•	Code before refactoring:
For example: JMenuBar() within EmployeeDetails took up a lot of space and had a lot going on. So I created a separate class just for the JMenuBar functionality.
 
_________________________________________________________________
 
3: Breaking code apart into more logical pieces

•	Why and how I applied the refactoring:

I did a few small fixes on a lot of the code. For example, one is the setBackground colour for the fields. I initialised the colour red at the start of the class so I could just pass in red for each time I wanted to set the colour rather than typing out 

 
 

