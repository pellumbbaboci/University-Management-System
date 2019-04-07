package com.university.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.university.datalayer.CourseDAO;
import com.university.datalayer.CourseDAOImpl;
import com.university.datalayer.EnrollDAO;
import com.university.datalayer.EnrollDAOImpl;
import com.university.datalayer.StudentDAO;
import com.university.datalayer.StudentDAOImpl;
import com.university.model.Enroll;
import com.university.model.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAO studentDao = new StudentDAOImpl();
	CourseDAO courseDao = new CourseDAOImpl();
	EnrollDAO enrollDao = new EnrollDAOImpl();

	ResultSet resultSet = null;

	@Override
	public void registerToCourse(Enroll e) {
		enrollDao.enrollToCourse(e);
	}

	@Override
	public void dropCourse(int value) {
		enrollDao.dropCourse(value);

	}

	@Override
	public List<Enroll> getEnrolledCourses(int id) {
		List<Enroll> enrolls = new ArrayList<>();

		try {

			resultSet = enrollDao.getEnrolledCourses(id);

			while (resultSet.next()) {
				Enroll e = new Enroll();
				e.setCourseId(resultSet.getInt("CourseID"));
				e.setStudentId(resultSet.getInt("StudentID"));
				e.setCourseName(resultSet.getString("CourseName"));
				e.setHours(resultSet.getInt("Hours"));
				e.setDateOfRegistration(resultSet.getString("DateOfRegistration"));

				enrolls.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enrolls;
	}

	@Override
	public void updateStudent(Student s, int id) {
		studentDao.updateStudentNameSurname(s, id);

	}

	@Override
	public String getStudentNumber(int id) {
		return studentDao.getStudentNumber(id);
		
	}

}
