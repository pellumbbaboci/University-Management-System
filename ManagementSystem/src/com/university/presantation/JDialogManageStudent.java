package com.university.presantation;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.university.model.LoggedInUser;
import com.university.model.Student;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class JDialogManageStudent extends JDialog {

	private UniversityService uniService = new UniversityServiceImpl();

	private JTextField txtStNumber;
	private JTextField txtStName;
	private JTextField txtStSurname;
	private JTextField txtUserID;
	private JLabel lblStudentNumber;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblManageStudent;
	private JLabel lblUserID;
	private JButton btnRemoveStudent;
	private JButton btnEditStudent;
	private JButton btnAddStudent;
	private JButton btnListAllStudent;
	private JPanel panel;
	private JTable table;

	/**
	 * Create the dialog.
	 * 
	 */
	public JDialogManageStudent() {
		setTitle("Manage Student");
		setModal(true);
		txtUserID = new JTextField();
		panel = new JPanel();
		lblStudentNumber = new JLabel("Student Number");
		lblFirstName = new JLabel("First Name");
		lblLastName = new JLabel("Last Name");
		txtStNumber = new JTextField();
		txtStName = new JTextField();
		txtStSurname = new JTextField();
		btnRemoveStudent = new JButton("Remove");
		btnEditStudent = new JButton("Edit");
		btnAddStudent = new JButton("Add");
		lblManageStudent = new JLabel("Manage Student");
		btnListAllStudent = new JButton("List All Student");
		lblUserID = new JLabel("User Id");

		txtUserID.setColumns(10);
		txtUserID.setBounds(180, 83, 136, 22);
		lblUserID.setBounds(56, 86, 101, 16);
		setBounds(100, 100, 938, 497);
		lblStudentNumber.setBounds(56, 122, 101, 16);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblFirstName.setBounds(55, 157, 102, 16);
		panel.setBounds(12, 13, 896, 412);
		lblLastName.setBounds(56, 192, 102, 16);
		txtStNumber.setColumns(10);
		txtStNumber.setBounds(180, 119, 136, 22);
		txtStName.setColumns(10);
		txtStName.setBounds(180, 154, 136, 22);
		txtStSurname.setColumns(10);
		txtStSurname.setBounds(180, 189, 136, 22);
		btnRemoveStudent.setBounds(180, 290, 136, 38);
		btnAddStudent.setBounds(242, 241, 74, 36);
		lblManageStudent.setForeground(Color.DARK_GRAY);
		btnListAllStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListAllStudent.setBounds(328, 83, 136, 30);
		lblManageStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblManageStudent.setBounds(237, 13, 186, 44);
		btnEditStudent.setBounds(180, 241, 68, 36);

		getContentPane().setLayout(null);
		getContentPane().add(panel);

		panel.add(lblStudentNumber);
		panel.add(lblFirstName);
		panel.add(lblLastName);
		panel.add(txtStNumber);
		panel.add(txtStName);
		panel.add(txtStSurname);
		panel.add(btnRemoveStudent);
		panel.add(btnListAllStudent);
		panel.add(btnEditStudent);
		panel.add(btnAddStudent);
		panel.add(lblManageStudent);
		panel.add(txtUserID);
		panel.add(lblUserID);

		String[] header = { "User Id", "Student Number", "Name", "Surname" };
		String[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, header);

		table = new JTable(model);
		table.setBounds(304, 122, 547, 227);
		table.setPreferredScrollableViewportSize(new Dimension(450, 63));
		table.setFillsViewportHeight(true);

		JScrollPane js = new JScrollPane(table);
		js.setBounds(328, 118, 547, 210);
		panel.add(js);
		js.setVisible(true);

		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				int value = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
				Student s = new Student();

				try {
					s.setuID(Integer.parseInt(txtUserID.getText()));
					s.setStudentNumber(Integer.parseInt(txtStNumber.getText()));
					s.setName(txtStName.getText());
					s.setSurname(txtStSurname.getText());

					uniService.updateStudent(s, value);

					JOptionPane.showMessageDialog(null, "Student Updated!");

					model.setValueAt(txtStNumber.getText(), row, 1);
					model.setValueAt(txtUserID.getText(), row, 0);
					model.setValueAt(txtStName.getText(), row, 2);
					model.setValueAt(txtStSurname.getText(), row, 3);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}

			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				txtStNumber.setText(model.getValueAt(row, 1).toString());
				txtUserID.setText(model.getValueAt(row, 0).toString());
				txtStName.setText(model.getValueAt(row, 2).toString());
				txtStSurname.setText(model.getValueAt(row, 3).toString());

			}
		});

		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				try {

					s.setuID(Integer.parseInt(txtUserID.getText()));
					s.setStudentNumber(Integer.parseInt(txtStNumber.getText()));
					if (LoggedInUser.getInstance().getUser().getDivision().equals("Admin")
							|| LoggedInUser.getInstance().getUser().getDivision().equals("Professor")) {

						uniService.addStudent(s);
						JOptionPane.showMessageDialog(null, "Student Added!");
						//JFrameMain.fieldNoStudent.setText("Number of Students   : " + uniService.countStudents());
					} else {
						JOptionPane.showMessageDialog(null, "You are not allowed to add Student !", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					txtUserID.setText("");
					txtStNumber.setText("");
					txtStName.setText("");
					txtStSurname.setText("");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int column = 0;
					int row = table.getSelectedRow();
					String value = table.getModel().getValueAt(row, column).toString();
					uniService.deleteStudent(value);
					Methods.removeSelectedFromTable(table);

					JOptionPane.showMessageDialog(null, "Student Deleted!!!");

				//	JFrameMain.fieldNoStudent.setText("Number of Students   : " + uniService.countStudents());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		btnListAllStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (model.getRowCount() > 0)
						model.setNumRows(0);

					List<Student> students = uniService.getAllStudents();
					List<Object> mappedData = students.stream().map(toObject()).collect(Collectors.toList());

					mappedData.forEach(data -> model.addRow((Object[]) data));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			private Function<Student, Object> toObject() {
				return student -> {
					Object[] data = { student.getuID(), student.getStudentNumber(), student.getName(),
							student.getSurname() };
					return data;
				};
			}
		});

	}
}
