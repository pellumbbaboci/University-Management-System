package com.university.presantation;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.university.model.LoggedInUser;
import com.university.model.Users;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class JDialogUsers extends JDialog {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	private UniversityService uniService = new UniversityServiceImpl();
	private JTextField txtUserJDialogUsers;
	private JPasswordField txtPassJDialogUsers;
	private JTextField txtNameJDialogUsers;
	private JTextField txtLastNameJDialogUsers;
	private JLabel lblSelectUserJDialogUsers;
	private JLabel lblUserNameJDialogUsers;
	private JLabel lblPasswordJDialogUsers;
	private JComboBox<String> comboSelectJDialogUsers;
	private JLabel lblNameJDialogUsers;
	private JButton btnAddJDialogUsers;
	private JButton btnDeleteJDialogUsers;
	private JButton btnEditJDialogUsers;
	private JLabel lblLoginInformationJDialogUsers;
	private JButton btnShowAllUsersJDialogUsers;
	private JLabel lblLastNameJDialogUsers;
	private JTable tableJDialogUsers;

	/**
	 * Create the dialog.
	 */
	public JDialogUsers() {
		setTitle("User Informations");
		setModal(true);
		lblNameJDialogUsers = new JLabel("Name");
		txtNameJDialogUsers = new JTextField();
		txtLastNameJDialogUsers = new JTextField();
		lblSelectUserJDialogUsers = new JLabel("Select User");
		lblUserNameJDialogUsers = new JLabel("User Name");
		lblPasswordJDialogUsers = new JLabel("Password");
		comboSelectJDialogUsers = new JComboBox<String>();
		txtUserJDialogUsers = new JTextField();
		txtPassJDialogUsers = new JPasswordField();
		btnAddJDialogUsers = new JButton("Add");
		btnDeleteJDialogUsers = new JButton("Delete");
		btnEditJDialogUsers = new JButton("Edit");
		lblLoginInformationJDialogUsers = new JLabel("Admin");
		btnShowAllUsersJDialogUsers = new JButton("Show All Users");
		lblLastNameJDialogUsers = new JLabel("Last Name");

		setBounds(100, 100, 854, 404);
		lblSelectUserJDialogUsers.setBounds(12, 77, 79, 16);
		lblUserNameJDialogUsers.setBounds(12, 106, 79, 16);
		lblPasswordJDialogUsers.setBounds(12, 135, 79, 16);
		comboSelectJDialogUsers.setBounds(103, 71, 145, 22);
		txtUserJDialogUsers.setBounds(103, 100, 145, 22);
		lblNameJDialogUsers.setBounds(12, 164, 79, 16);
		lblLastNameJDialogUsers.setBounds(12, 199, 79, 16);
		txtNameJDialogUsers.setColumns(10);
		txtNameJDialogUsers.setBounds(103, 170, 145, 22);
		txtLastNameJDialogUsers.setColumns(10);
		txtLastNameJDialogUsers.setBounds(103, 196, 145, 22);
		txtUserJDialogUsers.setColumns(10);
		txtPassJDialogUsers.setBounds(103, 135, 145, 22);
		btnDeleteJDialogUsers.setBounds(129, 241, 119, 33);
		btnShowAllUsersJDialogUsers.setBounds(260, 69, 128, 33);
		lblLoginInformationJDialogUsers.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
		lblLoginInformationJDialogUsers.setBounds(12, 0, 189, 33);
		btnEditJDialogUsers.setBounds(12, 276, 236, 33);
		btnAddJDialogUsers.setBounds(12, 241, 119, 33);

		getContentPane().setLayout(null);
		getContentPane().add(lblSelectUserJDialogUsers);
		getContentPane().add(lblUserNameJDialogUsers);
		getContentPane().add(lblPasswordJDialogUsers);
		getContentPane().add(comboSelectJDialogUsers);
		getContentPane().add(btnEditJDialogUsers);
		getContentPane().add(btnDeleteJDialogUsers);
		getContentPane().add(btnAddJDialogUsers);
		getContentPane().add(btnShowAllUsersJDialogUsers);
		getContentPane().add(lblLoginInformationJDialogUsers);
		getContentPane().add(txtUserJDialogUsers);
		getContentPane().add(txtPassJDialogUsers);
		getContentPane().add(lblNameJDialogUsers);
		getContentPane().add(lblLastNameJDialogUsers);
		getContentPane().add(txtNameJDialogUsers);
		getContentPane().add(txtLastNameJDialogUsers);
		comboSelectJDialogUsers.addItem("Admin");
		comboSelectJDialogUsers.addItem("Professor");
		comboSelectJDialogUsers.addItem("Student");

		String[] header = { "User Id", "User name", "password", "Name", "Surname", "Division", "Date of Registration" };
		String[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, header);
		tableJDialogUsers = new JTable(model);
		tableJDialogUsers.setBounds(304, 122, 547, 227);
		tableJDialogUsers.setPreferredScrollableViewportSize(new Dimension(450, 63));
		tableJDialogUsers.setFillsViewportHeight(true);

		JScrollPane js = new JScrollPane(tableJDialogUsers);
		js.setVisible(true);
		js.setBounds(260, 106, 533, 199);
		getContentPane().add(js);

		if (LoggedInUser.getInstance().getLanguage().equals("AL")) {
			ResourceBundle mybundle;
			Locale.setDefault(new Locale("sq", "AL"));
			mybundle = ResourceBundle.getBundle("Bundle");
			setTitle(mybundle.getString("titleUserInformation"));
			lblSelectUserJDialogUsers.setText(mybundle.getString("lblSelectUserJDialogUsers"));
			lblUserNameJDialogUsers.setText(mybundle.getString("lblUserNameJDialogUsers"));
			lblPasswordJDialogUsers.setText(mybundle.getString("lblPasswordJDialogUsers"));
			lblNameJDialogUsers.setText(mybundle.getString("lblNameJDialogUsers"));
			lblLastNameJDialogUsers.setText(mybundle.getString("lblLastNameJDialogUsers"));
			btnShowAllUsersJDialogUsers.setText(mybundle.getString("btnShowAllUsersJDialogUsers"));
			btnEditJDialogUsers.setText(mybundle.getString("btnEditJDialogUsers"));
			btnDeleteJDialogUsers.setText(mybundle.getString("btnDeleteJDialogUsers"));
			btnAddJDialogUsers.setText(mybundle.getString("btnAddJDialogUsers"));

		} else if (LoggedInUser.getInstance().getLanguage().equals("EN")) {
			ResourceBundle mybundle;
			Locale.setDefault(new Locale("en", "US"));
			mybundle = ResourceBundle.getBundle("Bundle");
			setTitle(mybundle.getString("titleUserInformation"));
			lblSelectUserJDialogUsers.setText(mybundle.getString("lblSelectUserJDialogUsers"));
			lblUserNameJDialogUsers.setText(mybundle.getString("lblUserNameJDialogUsers"));
			lblPasswordJDialogUsers.setText(mybundle.getString("lblPasswordJDialogUsers"));
			lblNameJDialogUsers.setText(mybundle.getString("lblNameJDialogUsers"));
			lblLastNameJDialogUsers.setText(mybundle.getString("lblLastNameJDialogUsers"));
			btnShowAllUsersJDialogUsers.setText(mybundle.getString("btnShowAllUsersJDialogUsers"));
			btnEditJDialogUsers.setText(mybundle.getString("btnEditJDialogUsers"));
			btnDeleteJDialogUsers.setText(mybundle.getString("btnDeleteJDialogUsers"));
			btnAddJDialogUsers.setText(mybundle.getString("btnAddJDialogUsers"));

		}

		btnEditJDialogUsers.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = tableJDialogUsers.getSelectedRow();
				int value = Integer.parseInt(tableJDialogUsers.getModel().getValueAt(row, column).toString());
				Users u = new Users();
				try {
					u.setName(txtNameJDialogUsers.getText());
					u.setSurname(txtLastNameJDialogUsers.getText());
					u.setUserName(txtUserJDialogUsers.getText());
					u.setPassword(txtPassJDialogUsers.getText());
					u.setDivision((String) comboSelectJDialogUsers.getSelectedItem());

					uniService.updateUser(u, value);
					JOptionPane.showMessageDialog(null, "User Updated");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				model.setValueAt(txtUserJDialogUsers.getText(), row, 1);
				model.setValueAt(txtPassJDialogUsers.getText(), row, 2);
				model.setValueAt(txtNameJDialogUsers.getText(), row, 3);
				model.setValueAt(txtLastNameJDialogUsers.getText(), row, 4);
				model.setValueAt(comboSelectJDialogUsers.getSelectedItem(), row, 5);
			}
		});

		tableJDialogUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableJDialogUsers.getSelectedRow();
				comboSelectJDialogUsers.setSelectedItem(model.getValueAt(row, 5));
				txtNameJDialogUsers.setText((String) model.getValueAt(row, 3));
				txtLastNameJDialogUsers.setText((String) model.getValueAt(row, 4));
				txtUserJDialogUsers.setText((String) model.getValueAt(row, 1));
				txtPassJDialogUsers.setText((String) model.getValueAt(row, 2));

			}
		});

		btnAddJDialogUsers.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Users u = new Users();
				try {
					u.setUserName(txtUserJDialogUsers.getText());
					u.setPassword(txtPassJDialogUsers.getText());
					u.setDivision(comboSelectJDialogUsers.getSelectedItem().toString());
					u.setName(txtNameJDialogUsers.getText());
					u.setSurname(txtLastNameJDialogUsers.getText());
					u.setDateOfRegistration(dateFormat.format(date));

					uniService.addUser(u);
					JOptionPane.showMessageDialog(null, "User Added !!!");

					txtUserJDialogUsers.setText("");
					txtPassJDialogUsers.setText("");
					txtNameJDialogUsers.setText("");
					txtLastNameJDialogUsers.setText("");

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}

			}
		});

		btnDeleteJDialogUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int column = 0;
					int row = tableJDialogUsers.getSelectedRow();
					String value = tableJDialogUsers.getModel().getValueAt(row, column).toString();

					if (!LoggedInUser.getInstance().getUser().getDivision().equals("Admin")) {

						uniService.deleteUser(value);
						Methods.removeSelectedFromTable(tableJDialogUsers);

						JOptionPane.showMessageDialog(null, "User Deleted!!!");

					} else {
						JOptionPane.showMessageDialog(null, "You can not delete Admin !", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		btnShowAllUsersJDialogUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (model.getRowCount() > 0)
						model.setNumRows(0);

					List<Users> users = uniService.readUsers();
					List<Object> mappedData = users.stream().map(toObject()).collect(Collectors.toList());

					mappedData.forEach(data -> model.addRow((Object[]) data));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			private Function<Users, Object> toObject() {
				return user -> {
					Object[] data = { user.getuID(), user.getUserName(), user.getPassword(), user.getName(),
							user.getSurname(), user.getDivision(), user.getDateOfRegistration() };
					return data;
				};
			}

		});

	}
}
