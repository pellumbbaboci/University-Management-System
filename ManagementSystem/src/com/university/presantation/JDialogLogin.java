package com.university.presantation;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import com.university.datalayer.ConnectionFactory;
import com.university.model.LoggedInUser;
import com.university.model.Users;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import javax.swing.JPasswordField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class JDialogLogin extends JDialog implements ActionListener {

	private UniversityService uniService = new UniversityServiceImpl();
	private Users u = new Users();

	Container c = getContentPane();

	private JLabel fieldNoStudentJDialogLogin;
	private JLabel fieldNoCourseJDialogLogin;
	private JLabel fieldNoProfJDialogLogin;
	private JLabel fieldWelcomeJDialogLogin;

	private JButton btnLoginJDialogLogin;
	private JButton btnCancelJDialogLogin;
	private JLabel lblUNameJDialogLogin;
	private JLabel lblPasswdJDialogLogin;
	private JTextField txtUNameJDialogLogin;
	private JPasswordField txtPasswdJDialogLogin;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		new JDialogLogin().setVisible(true);
	}

	public JDialogLogin() {

		setTitle("Login...");
		this.setSize(350, 200);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocation((Settings.getScreenSize().width / 2) - 175, (Settings.getScreenSize().height / 2) - 150);

		fieldNoStudentJDialogLogin = new JLabel("Number of Students   :");
		fieldNoStudentJDialogLogin.setBackground(Color.BLUE);
		fieldNoCourseJDialogLogin = new JLabel("Number of Courses    :");
		fieldNoCourseJDialogLogin.setBackground(Color.BLUE);
		fieldNoProfJDialogLogin = new JLabel("Number of Professors :");
		fieldNoProfJDialogLogin.setBackground(Color.BLUE);
		fieldWelcomeJDialogLogin = new JLabel("Welcome : ");
		lblUNameJDialogLogin = new JLabel("Username");
		lblPasswdJDialogLogin = new JLabel("Password");
		txtUNameJDialogLogin = new JTextField();
		txtPasswdJDialogLogin = new JPasswordField();
		btnLoginJDialogLogin = new JButton("Login");
		btnCancelJDialogLogin = new JButton("Cancel");

		fieldNoStudentJDialogLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		fieldNoStudentJDialogLogin.setBounds(126, 161, 191, 55);
		fieldNoCourseJDialogLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		fieldNoCourseJDialogLogin.setBounds(126, 231, 191, 55);
		fieldNoProfJDialogLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		fieldNoProfJDialogLogin.setBounds(126, 301, 191, 55);
		fieldWelcomeJDialogLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		fieldWelcomeJDialogLogin.setBounds(640, 13, 191, 55);
		lblUNameJDialogLogin.setBounds(50, 40, 140, 25);
		txtUNameJDialogLogin.setBounds(175, 40, 134, 25);
		lblPasswdJDialogLogin.setBounds(50, 80, 140, 25);
		txtPasswdJDialogLogin.setBounds(175, 80, 134, 25);
		btnLoginJDialogLogin.setBounds(50, 118, 124, 25);
		btnCancelJDialogLogin.setBounds(175, 118, 134, 25);
		btnLoginJDialogLogin.addActionListener(this);
		btnCancelJDialogLogin.addActionListener(this);

		getContentPane().add(lblUNameJDialogLogin);
		getContentPane().add(lblPasswdJDialogLogin);
		getContentPane().add(txtUNameJDialogLogin);
		getContentPane().add(txtPasswdJDialogLogin);
		getContentPane().add(btnLoginJDialogLogin);
		getContentPane().add(btnCancelJDialogLogin);

		
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLoginJDialogLogin) {
			try {

				u.setUserName(txtUNameJDialogLogin.getText());
				u.setPassword(txtPasswdJDialogLogin.getText());

				if (uniService.loginControl(u).equals("Admin")) {

					JFrameMain main = new JFrameMain();
					main.setVisible(true);
					main.pack();
					main.setLocationRelativeTo(null);
					main.setExtendedState(JFrame.MAXIMIZED_BOTH);

					fieldWelcomeJDialogLogin.setText("Welcome :" + LoggedInUser.getInstance().getUser().getName());
					fieldNoCourseJDialogLogin.setText("Number of Courses    : " + uniService.countCourses());
					fieldNoProfJDialogLogin.setText("Number of Professors : " + uniService.countProfessors());
					fieldNoStudentJDialogLogin.setText("Number of Students   : " + uniService.countStudents());

					main.getContentPane().add(fieldNoCourseJDialogLogin);
					main.getContentPane().add(fieldNoProfJDialogLogin);
					main.getContentPane().add(fieldWelcomeJDialogLogin);
					main.getContentPane().add(fieldNoStudentJDialogLogin);

					dispose();
				} else if (uniService.loginControl(u).equals("Professor")) {
					JFrameMain main = new JFrameMain();
					main.setVisible(true);
					main.pack();
					main.setLocationRelativeTo(null);
					main.setExtendedState(JFrame.MAXIMIZED_BOTH);

					fieldWelcomeJDialogLogin.setText("Welcome :" + LoggedInUser.getInstance().getUser().getName());
					fieldNoCourseJDialogLogin.setText("Number of Courses    : " + uniService.countCourses());
					fieldNoStudentJDialogLogin.setText("Number of Students   : " + uniService.countStudents());

					main.getContentPane().add(fieldNoCourseJDialogLogin);
					main.getContentPane().add(fieldNoProfJDialogLogin);
					main.getContentPane().add(fieldWelcomeJDialogLogin);
					main.getContentPane().add(fieldNoStudentJDialogLogin);

					dispose();

				} else if (uniService.loginControl(u).equals("Student")) {
					JFrameMain main = new JFrameMain();
					main.setVisible(true);
					main.pack();
					main.setLocationRelativeTo(null);
					main.setExtendedState(JFrame.MAXIMIZED_BOTH);

					fieldWelcomeJDialogLogin.setText("Welcome :" + LoggedInUser.getInstance().getUser().getName());

					main.getContentPane().add(fieldWelcomeJDialogLogin);

					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Invalid Login details ", "Login Error",
							JOptionPane.ERROR_MESSAGE);

					txtUNameJDialogLogin.setText("");
					txtPasswdJDialogLogin.setText("");
				}

				ConnectionFactory.getConnection().close();

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Invalid Login details !!!", "Login Error",
						JOptionPane.ERROR_MESSAGE);

				txtPasswdJDialogLogin.setText(null);
				txtUNameJDialogLogin.setText(null);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == btnCancelJDialogLogin) {

			System.exit(0);

		}
	}

}
