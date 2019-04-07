package com.university.datalayer;

public enum Queries {
	//User Queries -----------------------------------------------------------------------------------------------------------
	
	QUERYLOGINCONTROL("SELECT * FROM User WHERE userName = ? AND password = ? "),
	QUERYSELECTUSERID("SELECT idUser FROM User"),
	QUERYSELECTUSER("SELECT * FROM User"),	
	QUERYINSERTUSER("INSERT INTO User (idUser , userName, password,division, name , surname ,dateOfRegistration)"+ "VALUES (NULL, ?, ?, ?, ?,?,? )"),
	QUERYDELETEUSER("DELETE FROM User "),
	QUERYDELETECONTROL("SELECT * FROM User WHERE idUser = ?"),
	QUERYADDCONTROL("SELECT * FROM User WHERE idUser = ?"),
	QUERYDELETEUSERSELECTED("DELETE FROM User Where idUser = ? "),
	QUERYUPDATEUSER("UPDATE User SET userName = ? ,password = ? ,division = ? , name = ? , surname = ? WHERE idUser = ? "),
	
	// Student Queries------------------------------------------------------------------------------------------------------------
	
	QUERYGETNAMESTUDENT("SELECT User.name FROM User INNER JOIN Student ON ( User.idUser = Student.idUser ) WHERE Student.idUser = ? "),
	QUERYDELETESTUDENTSELECTED("DELETE FROM Student Where idUser = ? "),
	QUERYSELECTSTUDENTJOIN("SELECT User.name , User.surname , Student.idUser , Student.studentNumber FROM User"
                                                      + " INNER JOIN Student ON User.idUser = Student.idUser "),
	QUERYCOUNTSTUDENTS("SELECT count(*) AS total FROM Student"),
	
	QUERYSELECTSTUDENT("SELECT * FROM Student"),
	QUERYINSERTSTUDENT("INSERT INTO Student VALUES (? ,?)"),
	QUERYDELETESTUDENT("DELETE FROM Student WHERE idUser = ?"),
	QUERYUPDATESTUDENT("UPDATE Student SET studentNumber = ? WHERE idUser = ? "),
	QUERYUPDATESTUDENTINNER("UPDATE User INNER JOIN Student ON (User.idUser = Student.idUser)    "
			+ " SET User.name = ? , User.surname = ? , Student.studentNumber = ?  WHERE User.idUser = ? "),
	QUERYUPDATESTUDENTNAMESURNAME("UPDATE User INNER JOIN Student ON (User.idUser = Student.idUser)    "
			+ " SET User.name = ? , User.surname = ?   WHERE User.idUser = ? "),
	QUERYGETSTUDENTNUMBER("SELECT studentNumber FROM Student WHERE idUser = ? "),
	
	//Professor Queries-------------------------------------------------------------------------------------------------------
	
	QUERYGETNAMEPROFESSOR("SELECT User.name FROM User INNER JOIN Professor ON ( User.idUser = Professor.idUser ) WHERE Professor.idUser = ? "),
	QUERYDELETEPROFESSORSELECTED("DELETE FROM Professor Where idUser = ? "),
	QUERYCOUNTPROFESSORS("SELECT count(*) AS total FROM Professor"),
	QUERYSELECTPROFESSOR("SELECT * FROM Professor"),
	QUERYSELECTPROFESSORJOIN("SELECT User.name , User.surname , Professor.idUser , Professor.Salary FROM User"
			                                       + " INNER JOIN Professor ON User.idUser = Professor.idUser "),
	QUERYINSERTPROFESSOR("INSERT INTO Professor (idUser , Salary) VALUES ( ?,?)"),
	QUERYDELETEPROFESSOR("DELETE FROM Professor WHERE name = ? "),
	QUERYUPDATEPROFESSOR("UPDATE Professor SET Salary = ? WHERE idUser = ? "),
	QUERYUPDATEPROFESSORINNER("UPDATE User INNER JOIN Professor ON (User.idUser = Professor.idUser)    "
			+ " SET User.name = ? , User.surname = ?, Professor.Salary = ?  WHERE User.idUser = ? "),
	
	//Course  Queries---------------------------------------------------------------------------------------------------------------
	
	QUERYSELECTCOURSE("SELECT * FROM Course"),
	QUERYCOUNTCOURSES("SELECT count(*) AS total FROM Course"),
	QUERYINSERTCOURSE("INSERT INTO Course VALUES (NULL,?,?,?)"),
	QUERYDELETECOURSE("DELETE FROM Course WHERE ID = ? "),
	QUERYUPDATECOURSE("UPDATE Course SET CourseName = ?,CreditHours = ?, Professor_idUser = ?  WHERE ID= ? "),
	
	// Enroll Queries----------------------------------------------------------------------------------------------------------
	
	QUERYINSERTENROLL("INSERT INTO Enroll (ID  , CourseID , StudentID, CourseName , Hours ,DateOfRegistration)"+ "VALUES ( NULL,?, ?, ?, ?,? )"),
	QUERYDELETEENROLLSELECTED("DELETE FROM Enroll Where CourseID = ? "),
	QUERYSELECTENROLL("SELECT * FROM Enroll WHERE StudentID = ?");

	

	private String text;
	private Queries(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {    
		return text;    
	}
	
	

}
