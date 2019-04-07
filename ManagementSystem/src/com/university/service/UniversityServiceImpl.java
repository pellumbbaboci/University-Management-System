package com.university.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.university.datalayer.CourseDAO;
import com.university.datalayer.CourseDAOImpl;
import com.university.datalayer.ProfessorDAO;
import com.university.datalayer.ProfessorDAOImpl;
import com.university.datalayer.StudentDAO;
import com.university.datalayer.StudentDAOImpl;
import com.university.datalayer.UserDAO;
import com.university.datalayer.UserDAOImpl;
import com.university.model.Course;
import com.university.model.Professor;
import com.university.model.Student;
import com.university.model.Users;

public class UniversityServiceImpl implements UniversityService {
	ProfessorDAO professorDao = new ProfessorDAOImpl();
	UserDAO userDao = new UserDAOImpl();
	StudentDAO studentDao = new StudentDAOImpl();
	CourseDAO courseDao = new CourseDAOImpl();

	ResultSet resultSet = null;

	@Override
	public void addStudent(Student s) {
		studentDao.insertStudent(s);
	}

	@Override
	public void addUser(Users u) {
		userDao.addNewUser(u);
	}

	@Override
	public void addProfessor(Professor p) {
		professorDao.insertProfessor(p);
	}

	@Override
	public void addCourse(Course c) {
		courseDao.insertCourse(c);
	}

	@Override
	public List<Users> readUsers() {
		List<Users> users = new ArrayList<>();
		resultSet = userDao.readUser();
		try {

			while (resultSet.next()) {
				Users u = new Users();

				u.setuID(resultSet.getInt("idUser"));
				u.setUserName(resultSet.getString("userName"));
				u.setPassword(resultSet.getString("password"));
				u.setDivision(resultSet.getString("division"));
				u.setName(resultSet.getString("name"));
				u.setSurname(resultSet.getString("surname"));
				u.setDateOfRegistration(resultSet.getString("dateOfRegistration"));

				users.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public List<Professor> getAllProfessors() {
		List<Professor> profesors = new ArrayList<>();

		resultSet = professorDao.readProfessors();
		try {

			while (resultSet.next()) {
				Professor p = new Professor();

				p.setuID(resultSet.getInt("idUser"));
				p.setSalary(resultSet.getString("Salary"));
				p.setName(resultSet.getString("name"));
				p.setSurname(resultSet.getString("surname"));

				profesors.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profesors;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();

		try {
			resultSet = studentDao.readStudent();
			while (resultSet.next()) {
				Student s = new Student();
				s.setStudentNumber(resultSet.getInt("studentNumber"));
				s.setuID(resultSet.getInt("idUser"));
				s.setName(resultSet.getString("name"));
				s.setSurname(resultSet.getString("surname"));

				students.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		try {

			resultSet = courseDao.readCourse();
			while (resultSet.next()) {
				Course c = new Course();
				c.setcID(resultSet.getInt("ID"));
				c.setCourseName(resultSet.getString("CourseName"));
				c.setHours(resultSet.getInt("CreditHours"));
				c.setProfUserID(resultSet.getInt("Professor_idUser"));

				courses.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}

	@Override
	public String loginControl(Users u) {
		return userDao.loginControl(u);
	}

	@Override
	public void deleteProfessor(String id) {
		professorDao.deleteProfessor(id);
	}

	@Override
	public void deleteStudent(String id) {
		studentDao.deleteStudent(id);
	}

	@Override
	public void deleteCourse(int id) {
		courseDao.deleteCourse(id);
	}

	@Override
	public void updateProfessor(Professor p, int id) {
		professorDao.updateProfessor(p, id);
	}

	@Override
	public void updateStudent(Student s, int id) {
		studentDao.updateStudent(s, id);
	}

	@Override
	public void updateCourse(Course c, int id) {
		courseDao.updateCourse(c, id);
	}

	@Override
	public void updateUser(Users u, int id) {
		userDao.updateUser(u, id);
	}

	@Override
	public int countStudents() {
		return studentDao.numberOfStudents();
	}

	@Override
	public int countProfessors() {
		return professorDao.numberOfProfessors();
	}

	@Override
	public int countCourses() {
		return courseDao.numberOfCourses();
	}

}
