package com.university.presantation;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.university.model.Course;
import com.university.model.Enroll;
import com.university.model.LoggedInUser;
import com.university.model.Student;
import com.university.service.StudentService;
import com.university.service.StudentServiceImpl;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class JDialogStudentRegistration extends JDialog {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	private JTextField txtNameJDialogStudentRegistration;
	private JTextField txtSurnameJDialogStudentRegistration;
	private JTable firstTableJDialogStudentRegistration;
	private JTable secondTableJDialogStudentRegistration;
	private JPanel panelJDialogStudentRegistration;
	private JPanel panelButtonsJDialogStudentRegistration;
	private JLabel lblSNameJDialogStudentRegistration;
	private JLabel lblSSurnameJDialogStudentRegistration;
	private JLabel lblCoursesYouCanJDialogStudentRegistration;
	private JLabel lblCoursesYouHaveJDialogStudentRegistration;
	private JButton btnRegistJDialogStudentRegistration;
	private JButton btnCancelJDialogStudentRegistration;
	private JButton btnEditJDialogStudentRegistration;
	private JButton btnDropJDialogStudentRegistration;
	private JScrollPane firstScrollJDialogStudentRegistration;
	private JScrollPane secondScrollJDialogStudentRegistration;
	private DefaultTableModel model1JDialogStudentRegistration;
	private DefaultTableModel modelJDialogStudentRegistration;

	private UniversityService uniService = new UniversityServiceImpl();
	private StudentService studentService = new StudentServiceImpl();

	/**
	 * Create the dialog.
	 */

	public JDialogStudentRegistration() {

		setTitle("Student Registration");
		setModal(true);
		lblCoursesYouHaveJDialogStudentRegistration = new JLabel("Courses you have taken");
		lblCoursesYouCanJDialogStudentRegistration = new JLabel("Courses you can take");
		panelJDialogStudentRegistration = new JPanel();
		txtNameJDialogStudentRegistration = new JTextField();
		lblSSurnameJDialogStudentRegistration = new JLabel("Last Name");
		txtSurnameJDialogStudentRegistration = new JTextField();
		btnEditJDialogStudentRegistration = new JButton("Update");
		lblSNameJDialogStudentRegistration = new JLabel("First Name");
		panelButtonsJDialogStudentRegistration = new JPanel();

		btnRegistJDialogStudentRegistration = new JButton("Enroll");
		btnRegistJDialogStudentRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDropJDialogStudentRegistration = new JButton("Drop");
		btnDropJDialogStudentRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelJDialogStudentRegistration = new JButton("Cancel");
		btnCancelJDialogStudentRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblCoursesYouCanJDialogStudentRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCoursesYouCanJDialogStudentRegistration.setBounds(12, 64, 170, 16);
		lblCoursesYouHaveJDialogStudentRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCoursesYouHaveJDialogStudentRegistration.setBounds(451, 64, 189, 16);
		setBounds(100, 100, 933, 399);
		panelJDialogStudentRegistration.setBackground(Color.LIGHT_GRAY);
		panelJDialogStudentRegistration.setBounds(12, 13, 891, 38);
		txtNameJDialogStudentRegistration.setColumns(10);
		btnEditJDialogStudentRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSSurnameJDialogStudentRegistration.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtSurnameJDialogStudentRegistration.setColumns(10);
		lblSNameJDialogStudentRegistration.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panelButtonsJDialogStudentRegistration.setBackground(Color.LIGHT_GRAY);
		panelButtonsJDialogStudentRegistration.setBounds(12, 297, 891, 42);

		panelJDialogStudentRegistration.add(lblSNameJDialogStudentRegistration);
		panelJDialogStudentRegistration.add(txtNameJDialogStudentRegistration);
		panelJDialogStudentRegistration.add(lblSSurnameJDialogStudentRegistration);
		panelJDialogStudentRegistration.add(txtSurnameJDialogStudentRegistration);
		panelJDialogStudentRegistration.add(btnEditJDialogStudentRegistration);

		panelButtonsJDialogStudentRegistration.add(btnRegistJDialogStudentRegistration);
		panelButtonsJDialogStudentRegistration.add(btnDropJDialogStudentRegistration);
		panelButtonsJDialogStudentRegistration.add(btnCancelJDialogStudentRegistration);
		getContentPane().add(lblCoursesYouCanJDialogStudentRegistration);
		getContentPane().add(lblCoursesYouHaveJDialogStudentRegistration);
		getContentPane().setLayout(null);
		getContentPane().add(panelJDialogStudentRegistration);
		getContentPane().add(panelButtonsJDialogStudentRegistration);

		String[] header = { "Course Id ", "Course Name ", "Hours ", "Professor Id " };
		String[][] data = {};
		modelJDialogStudentRegistration = new DefaultTableModel(data, header);
		firstTableJDialogStudentRegistration = new JTable(modelJDialogStudentRegistration);
		firstTableJDialogStudentRegistration.setBounds(304, 122, 547, 227);
		firstTableJDialogStudentRegistration.setPreferredScrollableViewportSize(new Dimension(450, 63));
		firstTableJDialogStudentRegistration.setFillsViewportHeight(true);

		firstScrollJDialogStudentRegistration = new JScrollPane(firstTableJDialogStudentRegistration);
		firstScrollJDialogStudentRegistration.setVisible(true);
		firstScrollJDialogStudentRegistration.setBounds(12, 85, 420, 199);
		getContentPane().add(firstScrollJDialogStudentRegistration);

		String[] header1 = { "Course Id ", "Course Name ", "Hours ", "Student Id ", "Date of Registration" };
		String[][] data1 = {};
		model1JDialogStudentRegistration = new DefaultTableModel(data1, header1);
		secondTableJDialogStudentRegistration = new JTable(model1JDialogStudentRegistration);
		secondTableJDialogStudentRegistration.setBounds(304, 600, 547, 227);
		secondTableJDialogStudentRegistration.setPreferredScrollableViewportSize(new Dimension(450, 63));
		secondTableJDialogStudentRegistration.setFillsViewportHeight(true);

		secondScrollJDialogStudentRegistration = new JScrollPane(secondTableJDialogStudentRegistration);
		secondScrollJDialogStudentRegistration.setVisible(true);
		secondScrollJDialogStudentRegistration.setBounds(451, 85, 452, 199);
		getContentPane().add(secondScrollJDialogStudentRegistration);

		showCourses();
		showEnrolledCourses();

		if (LoggedInUser.getInstance().getLanguage().equals("AL")) {
			ResourceBundle mybundle;
			Locale.setDefault(new Locale("sq", "AL"));
			mybundle = ResourceBundle.getBundle("Bundle");
			setTitle(mybundle.getString("titleRegStudent"));
			lblSNameJDialogStudentRegistration.setText(mybundle.getString("lblSNameJDialogStudentRegistration"));
			lblSSurnameJDialogStudentRegistration.setText(mybundle.getString("lblSSurnameJDialogStudentRegistration"));
			lblCoursesYouCanJDialogStudentRegistration
					.setText(mybundle.getString("lblCoursesYouCanJDialogStudentRegistration"));
			lblCoursesYouHaveJDialogStudentRegistration
					.setText(mybundle.getString("lblCoursesYouHaveJDialogStudentRegistration"));
			btnRegistJDialogStudentRegistration.setText(mybundle.getString("btnRegistJDialogStudentRegistration"));
			btnCancelJDialogStudentRegistration.setText(mybundle.getString("btnCancelJDialogStudentRegistration"));
			btnEditJDialogStudentRegistration.setText(mybundle.getString("btnEditJDialogStudentRegistration"));
			btnDropJDialogStudentRegistration.setText(mybundle.getString("btnDropJDialogStudentRegistration"));

		} else if (LoggedInUser.getInstance().getLanguage().equals("EN")) {
			ResourceBundle mybundle;
			Locale.setDefault(new Locale("en", "US"));
			mybundle = ResourceBundle.getBundle("Bundle");
			setTitle(mybundle.getString("titleRegStudent"));
			lblSNameJDialogStudentRegistration.setText(mybundle.getString("lblSNameJDialogStudentRegistration"));
			lblSSurnameJDialogStudentRegistration.setText(mybundle.getString("lblSSurnameJDialogStudentRegistration"));
			lblCoursesYouCanJDialogStudentRegistration
					.setText(mybundle.getString("lblCoursesYouCanJDialogStudentRegistration"));
			lblCoursesYouHaveJDialogStudentRegistration
					.setText(mybundle.getString("lblCoursesYouHaveJDialogStudentRegistration"));
			btnRegistJDialogStudentRegistration.setText(mybundle.getString("btnRegistJDialogStudentRegistration"));
			btnCancelJDialogStudentRegistration.setText(mybundle.getString("btnCancelJDialogStudentRegistration"));
			btnEditJDialogStudentRegistration.setText(mybundle.getString("btnEditJDialogStudentRegistration"));
			btnDropJDialogStudentRegistration.setText(mybundle.getString("btnDropJDialogStudentRegistration"));

		}

		btnEditJDialogStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student s = new Student();
				try {
					s.setName(txtNameJDialogStudentRegistration.getText());
					s.setSurname(txtSurnameJDialogStudentRegistration.getText());

					studentService.updateStudent(s, LoggedInUser.getInstance().getUser().getuID());
					JOptionPane.showMessageDialog(null, "Name and Surname Updated");

					txtNameJDialogStudentRegistration.setText(LoggedInUser.getInstance().getUser().getName());
					txtSurnameJDialogStudentRegistration.setText(LoggedInUser.getInstance().getUser().getSurname());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		txtNameJDialogStudentRegistration.setText(LoggedInUser.getInstance().getUser().getName());
		txtSurnameJDialogStudentRegistration.setText(LoggedInUser.getInstance().getUser().getSurname());

		btnRegistJDialogStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Enroll e = new Enroll();
					int row = firstTableJDialogStudentRegistration.getSelectedRow();

					int courseId = Integer
							.parseInt(firstTableJDialogStudentRegistration.getModel().getValueAt(row, 0).toString());
					String courseName = firstTableJDialogStudentRegistration.getModel().getValueAt(row, 1).toString();
					int hours = Integer
							.parseInt(firstTableJDialogStudentRegistration.getModel().getValueAt(row, 2).toString());
					int studentId = LoggedInUser.getInstance().getUser().getuID();

					e.setCourseId(courseId);
					e.setCourseName(courseName);
					e.setHours(hours);
					e.setStudentId(studentId);
					e.setDateOfRegistration(dateFormat.format(date));

					studentService.registerToCourse(e);
					JOptionPane.showMessageDialog(null, "You enrolled to Course!");
					Methods.removeSelectedFromTable(firstTableJDialogStudentRegistration);
					showEnrolledCourses();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		btnDropJDialogStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					int column = 0;
					int row = secondTableJDialogStudentRegistration.getSelectedRow();
					int value = Integer.parseInt(
							secondTableJDialogStudentRegistration.getModel().getValueAt(row, column).toString());
					studentService.dropCourse(value);
					JOptionPane.showMessageDialog(null, "Course has been droped!");
					Methods.removeSelectedFromTable(secondTableJDialogStudentRegistration);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		btnCancelJDialogStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	// Constructor Closed

	public void showEnrolledCourses() {
		try {
			int id = LoggedInUser.getInstance().getUser().getuID();

			if (model1JDialogStudentRegistration.getRowCount() > 0)
				model1JDialogStudentRegistration.setNumRows(0);

			List<Enroll> eCourses = studentService.getEnrolledCourses(id);
			List<Object> mappedData = eCourses.stream().map(toObject1()).collect(Collectors.toList());
			mappedData.forEach(data -> model1JDialogStudentRegistration.addRow((Object[]) data));

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}

	}

	private Function<Enroll, Object> toObject1() {
		return cs -> {
			Object[] data = { cs.getCourseId(), cs.getCourseName(), cs.getHours(), cs.getStudentId(),
					cs.getDateOfRegistration() };
			return data;
		};
	}

	public void showCourses() {
		try {

			if (modelJDialogStudentRegistration.getRowCount() > 0)
				modelJDialogStudentRegistration.setNumRows(0);

			List<Course> courses = uniService.getAllCourses();
			List<Object> mappedData = courses.stream().map(toObject()).collect(Collectors.toList());

			mappedData.forEach(data -> modelJDialogStudentRegistration.addRow((Object[]) data));

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}

	}

	private Function<Course, Object> toObject() {
		return cs -> {
			Object[] data = { cs.getcID(), cs.getCourseName(), cs.getHours(), cs.getProfUserID() };
			return data;
		};
	}
}
