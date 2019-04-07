package com.university.presantation;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.university.model.Course;
import com.university.model.LoggedInUser;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class JDialogAddCourse extends JDialog {

	private UniversityService uniService = new UniversityServiceImpl();

	private JTextField txtCourseName;
	private JTextField txtHours;
	private JTextField txtProfUserID;
	private JLabel lblCourseName;
	private JLabel lblCourseHours;
	private JLabel lblAddCourse;
	private JButton btnCancel;
	private JButton btnAddCourse;
	private JLabel lblProfessorUserId;

	/**
	 * Create the dialog.
	 * 
	 * @param string
	 */
	public JDialogAddCourse() {
		setTitle("Add Course");
		setModal(true);
		txtCourseName = new JTextField();
		lblCourseName = new JLabel("Course Name");
		lblCourseHours = new JLabel("Hours");
		lblAddCourse = new JLabel("Add Course");
		btnCancel = new JButton("Cancel");
		btnAddCourse = new JButton("Add");
		txtHours = new JTextField();
		txtProfUserID = new JTextField();
		lblProfessorUserId = new JLabel("Professor User ID");

		txtHours.setColumns(10);
		txtHours.setBounds(150, 173, 136, 22);
		txtCourseName.setColumns(10);
		txtCourseName.setBounds(150, 133, 136, 22);
		setBounds(100, 100, 420, 384);
		lblCourseName.setBounds(40, 136, 77, 16);
		lblCourseHours.setBounds(40, 176, 56, 16);
		lblAddCourse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddCourse.setBounds(111, 33, 159, 41);
		btnAddCourse.setBounds(163, 229, 123, 36);
		btnCancel.setBounds(40, 229, 123, 36);
		lblProfessorUserId.setBounds(40, 103, 111, 16);
		txtProfUserID.setColumns(10);
		txtProfUserID.setBounds(150, 100, 136, 22);

		getContentPane().setLayout(null);
		getContentPane().add(txtCourseName);
		getContentPane().add(lblCourseName);
		getContentPane().add(lblCourseHours);
		getContentPane().add(btnCancel);
		getContentPane().add(btnAddCourse);
		getContentPane().add(lblAddCourse);
		getContentPane().add(txtHours);
		getContentPane().add(txtProfUserID);
		getContentPane().add(lblProfessorUserId);

		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course c = new Course();
				try {

					c.setCourseName(txtCourseName.getText());
					c.setHours(Integer.parseInt(txtHours.getText()));
					c.setProfUserID(Integer.parseInt(txtProfUserID.getText()));

					if (LoggedInUser.getInstance().getUser().getDivision().equals("Professor")
							|| LoggedInUser.getInstance().getUser().getDivision().equals("Admin")) {
						uniService.addCourse(c);
						JOptionPane.showMessageDialog(null, "Course Added !!!");
						// JFrameMain.fieldNoCourse.setText("Number of Courses : " +
						// uniService.countCourses());

					} else {
						JOptionPane.showMessageDialog(null, "You must be Admin or Professor to add a Course !", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					txtCourseName.setText("");
					txtHours.setText("");
					txtProfUserID.setText("");

				} catch (Exception evt) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					evt.printStackTrace();
				}

			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
