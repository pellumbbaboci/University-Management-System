package com.university.presantation;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.university.model.LoggedInUser;
import com.university.model.Student;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogAddStudent extends JDialog {

	private UniversityService uniService = new UniversityServiceImpl();

	private JTextField txtStNumber;
	private JTextField txtStName;
	private JTextField txtLastName;
	private JTextField txtUserID;
	private JLabel lblStudentNumber;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblAddStudent;
	private JLabel lblUserId;
	private JButton btnCancel;
	private JButton btnAddStudent;

	/**
	 * Create the dialog.
	 */
	public JDialogAddStudent() {
		setTitle("Add Student");
		setModal(true);
		lblStudentNumber = new JLabel("Student Number");
		txtStNumber = new JTextField();
		txtStName = new JTextField();
		lblFirstName = new JLabel("First Name");
		lblLastName = new JLabel("Last Name");
		txtLastName = new JTextField();
		btnCancel = new JButton("Cancel");
		btnAddStudent = new JButton("Add");
		txtUserID = new JTextField();
		lblAddStudent = new JLabel("Add Student");
		lblUserId = new JLabel("User Id");

		lblStudentNumber.setBounds(75, 141, 101, 16);
		setBounds(100, 100, 450, 464);
		txtStNumber.setColumns(10);
		txtStNumber.setBounds(199, 138, 136, 22);
		txtStName.setColumns(10);
		txtStName.setBounds(199, 173, 136, 22);
		lblFirstName.setBounds(74, 176, 102, 16);
		lblLastName.setBounds(75, 211, 102, 16);
		txtLastName.setColumns(10);
		txtLastName.setBounds(199, 208, 136, 22);
		btnCancel.setBounds(74, 277, 126, 36);
		btnAddStudent.setBounds(198, 277, 136, 36);
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAddStudent.setBounds(158, 37, 114, 36);
		lblUserId.setBounds(75, 109, 101, 16);
		txtUserID.setColumns(10);
		txtUserID.setBounds(199, 106, 136, 22);

		getContentPane().add(btnAddStudent);
		getContentPane().setLayout(null);
		getContentPane().add(lblStudentNumber);
		getContentPane().add(txtStNumber);
		getContentPane().add(txtStName);
		getContentPane().add(lblFirstName);
		getContentPane().add(lblLastName);
		getContentPane().add(txtLastName);
		getContentPane().add(btnCancel);
		getContentPane().add(lblAddStudent);
		getContentPane().add(lblUserId);
		getContentPane().add(txtUserID);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				//
				try {
					s.setuID(Integer.parseInt(txtUserID.getText()));
					s.setStudentNumber(Integer.parseInt(txtStNumber.getText()));
					s.setName(txtStName.getText());
					s.setSurname(txtLastName.getText());
					if (LoggedInUser.getInstance().getUser().getDivision().equals("Professor")
							|| LoggedInUser.getInstance().getUser().getDivision().equals("Admin")) {
						uniService.addStudent(s);
						JOptionPane.showMessageDialog(null, "Student Added!");

					//	JFrameMain.fieldNoStudent.setText("Number of Students   : " + uniService.countStudents());

					} else {
						JOptionPane.showMessageDialog(null, "You are not allowed to add Student  !", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					txtUserID.setText("");
					txtStNumber.setText("");
					txtStName.setText("");
					txtLastName.setText("");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

	}
}
