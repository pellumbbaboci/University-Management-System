package com.university.presantation;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.university.model.LoggedInUser;
import com.university.model.Professor;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogAddProfessor extends JDialog {

	private UniversityService uniService = new UniversityServiceImpl();

	private JTextField txtUserId;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtSalary;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JButton btnCancel;
	private JLabel lblAddprofessor;
	private JButton btnAddProfessor;
	private JLabel lblSalary;
	private JLabel lblUserID;

	/**
	 * Create the dialog.
	 */
	public JDialogAddProfessor() {
		setTitle("Add Professor");
		setModal(true);
		txtUserId = new JTextField();
		txtName = new JTextField();
		txtSurname = new JTextField();
		lblLastName = new JLabel("Last Name");
		lblFirstName = new JLabel("First Name");
		txtSalary = new JTextField();
		btnCancel = new JButton("Cancel");
		lblAddprofessor = new JLabel("AddProfessor");
		btnAddProfessor = new JButton("Add");
		lblSalary = new JLabel("Salary");
		lblLastName = new JLabel("Surname");
		lblFirstName = new JLabel("Name");
		lblUserID = new JLabel("User ID");

		btnCancel.setBounds(60, 260, 136, 36);
		btnAddProfessor.setBounds(190, 260, 136, 36);
		lblAddprofessor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddprofessor.setBounds(148, 13, 145, 36);
		setBounds(100, 100, 467, 429);
		txtUserId.setColumns(10);
		txtUserId.setBounds(190, 95, 136, 22);
		txtName.setColumns(10);
		txtName.setBounds(190, 130, 136, 22);
		txtSurname.setColumns(10);
		txtSurname.setBounds(190, 165, 136, 22);
		txtSalary.setColumns(10);
		txtSalary.setBounds(190, 200, 136, 22);
		lblUserID.setBounds(60, 98, 56, 16);
		lblFirstName.setBounds(60, 133, 56, 16);
		lblLastName.setBounds(60, 174, 56, 16);
		lblSalary.setBounds(60, 203, 56, 16);

		getContentPane().setLayout(null);
		getContentPane().add(btnCancel);
		getContentPane().add(btnAddProfessor);
		getContentPane().add(lblAddprofessor);
		getContentPane().add(txtUserId);
		getContentPane().add(txtName);
		getContentPane().add(txtSurname);
		getContentPane().add(txtSalary);
		getContentPane().add(lblUserID);
		getContentPane().add(lblFirstName);
		getContentPane().add(lblLastName);
		getContentPane().add(lblSalary);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});

		btnAddProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Professor p = new Professor();

				try {

					int id = Integer.parseInt(txtUserId.getText());
					p.setuID(id);
					p.setSalary(txtSalary.getText());
					p.setName(txtName.getText());
					p.setSurname(txtSurname.getText());

					if (LoggedInUser.getInstance().getUser().getDivision().equals("Professor")
							|| LoggedInUser.getInstance().getUser().getDivision().equals("Admin")) {
						uniService.addProfessor(p);
						JOptionPane.showMessageDialog(null, "Professor Added !!!");
						//JFrameMain.fieldNoProf.setText("Number of Professors : " + uniService.countProfessors());
					} else {
						JOptionPane.showMessageDialog(null, "You are not allowed to add Professor !", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					txtUserId.setText("");
					txtName.setText("");
					txtSurname.setText("");
					txtSalary.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}

			}
		});

	}
}
