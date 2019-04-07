package com.university.presantation;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;

import com.university.model.LoggedInUser;
import com.university.model.Professor;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class JDialogManageProfessor extends JDialog {
	private UniversityService uniService = new UniversityServiceImpl();

	private JTextField txtUserId;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtSalary;
	private JLabel lblProfessorNumber ;
	private JLabel lblFirstName ;
	private JLabel lblLastName ;
	private JLabel lblSalary; 
	private JLabel lblManageProfessor;
	private JButton btnListAllProfessors ;
	private JButton btnEditProfessor ;
	private JButton btnAddProfessor;
	private JButton btnRemoveProfessor;
	private JTable table;
	/**
	 * Create the dialog.
	 */
	public JDialogManageProfessor() {
		setTitle("Manage Professor");
		setModal(true);
		lblProfessorNumber = new JLabel("User ID");
		txtUserId = new JTextField();
		txtName = new JTextField();
		lblFirstName = new JLabel("First Name");
		lblLastName = new JLabel("Last Name");
		txtSurname = new JTextField();
		btnListAllProfessors = new JButton("List All Professors");
		lblManageProfessor = new JLabel("Manage Professor");
		btnEditProfessor = new JButton("Edit");
		btnAddProfessor = new JButton("Add");
		btnRemoveProfessor = new JButton("Remove");
		lblSalary = new JLabel("Salary");
		txtSalary = new JTextField();

		setBounds(100, 100, 903, 469);
		lblProfessorNumber.setBounds(13, 98, 112, 16);
		txtUserId.setColumns(10);
		txtUserId.setBounds(137, 95, 136, 22);
		txtName.setColumns(10);
		txtName.setBounds(137, 130, 136, 22);
		lblFirstName.setBounds(12, 133, 102, 16);
		lblLastName.setBounds(13, 168, 102, 16);
		txtSurname.setColumns(10);
		txtSurname.setBounds(137, 165, 136, 22);
		btnListAllProfessors.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListAllProfessors.setBounds(304, 95, 149, 20);
		lblManageProfessor.setForeground(Color.DARK_GRAY);
		lblManageProfessor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblManageProfessor.setBounds(329, 13, 186, 44);
		btnEditProfessor.setBounds(137, 262, 68, 36);
		btnAddProfessor.setBounds(199, 262, 74, 36);
		btnRemoveProfessor.setBounds(137, 311, 136, 38);
		txtSalary.setColumns(10);
		txtSalary.setBounds(137, 200, 136, 22);
		lblSalary.setBounds(13, 203, 112, 16);

		getContentPane().setLayout(null);
		getContentPane().add(lblProfessorNumber);
		getContentPane().add(txtUserId);
		getContentPane().add(txtName);
		getContentPane().add(lblFirstName);
		getContentPane().add(lblLastName);
		getContentPane().add(txtSurname);

		getContentPane().add(btnListAllProfessors);
		getContentPane().add(lblSalary);
		getContentPane().add(lblManageProfessor);
		getContentPane().add(btnEditProfessor);
		getContentPane().add(btnAddProfessor);
		getContentPane().add(btnRemoveProfessor);
		getContentPane().add(txtSalary);

		String[] header = { "User Id", "Salary", "Name", "Surname" };
		String[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, header);
		table = new JTable(model);
		table.setBounds(304, 122, 547, 227);
		table.setPreferredScrollableViewportSize(new Dimension(450, 63));
		table.setFillsViewportHeight(true);

		JScrollPane js = new JScrollPane(table);
		js.setVisible(true);
		js.setBounds(304, 122, 547, 227);
		getContentPane().add(js);

		btnEditProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				int value = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
				Professor p = new Professor();
				try {
					p.setuID(Integer.parseInt(txtUserId.getText()));
					p.setSalary(txtSalary.getText());
					p.setName(txtName.getText());
					p.setSurname(txtSurname.getText());

					uniService.updateProfessor(p, value);

					JOptionPane.showMessageDialog(null, "Professor Updated");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				model.setValueAt(txtUserId.getText(), row, 0);
				model.setValueAt(txtSalary.getText(), row, 1);
				model.setValueAt(txtName.getText(), row, 2);
				model.setValueAt(txtSurname.getText(), row, 3);

			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				txtSalary.setText((String) model.getValueAt(row, 1));
				txtUserId.setText(model.getValueAt(row, 0).toString());
				txtName.setText(model.getValueAt(row, 2).toString());
				txtSurname.setText(model.getValueAt(row, 3).toString());

			}
		});

		btnAddProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						JOptionPane.showMessageDialog(null, "You are not allowed to add Professor !",
								"Error", JOptionPane.ERROR_MESSAGE);

					}

					txtUserId.setText("");
					txtName.setText("");
					txtSurname.setText("");
					txtSalary.setText("");
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					evt.printStackTrace();
				}
			}
		});

		btnListAllProfessors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (model.getRowCount() > 0)
						model.setNumRows(0);
					List<Professor> professors = uniService.getAllProfessors();
					List<Object> mappedData = professors.stream().map(toObject()).collect(Collectors.toList());

					mappedData.forEach(data -> model.addRow((Object[]) data));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			private Function<Professor, Object> toObject() {
				return professor -> {
					Object[] data = { professor.getuID(), professor.getSalary(), professor.getName(),
							professor.getSurname() };
					return data;
				};
			}
		});

		btnRemoveProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int column = 0;
					int row = table.getSelectedRow();
					String value = table.getModel().getValueAt(row, column).toString();
					uniService.deleteProfessor(value);
					Methods.removeSelectedFromTable(table);

					JOptionPane.showMessageDialog(null, "Professor Deleted!!!");

					//JFrameMain.fieldNoProf.setText("Number of Professors : " + uniService.countProfessors());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

	}
}
