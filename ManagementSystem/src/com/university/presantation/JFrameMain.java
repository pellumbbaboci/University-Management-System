package com.university.presantation;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.university.model.LoggedInUser;
import com.university.model.Student;
import com.university.service.StudentService;
import com.university.service.StudentServiceImpl;

import javax.swing.JMenuBar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
//import java.lang.System.Logger;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameMain extends JFrame {
	private StudentService studentService = new StudentServiceImpl();

	private JPanel adminPanelJFrameMain;
	private JButton btnLogOutJFrameMain;
	private JButton btnCancelJFrameMain;
	private JMenuBar menuBariJFrameMain;
	private JMenuItem mntmRegistrationJFrameMain;
	private JMenu mnStudentJFrameMain;
	private JMenuItem mntmManageStudentJFrameMain;
	private JMenuItem mntmAddStudentJFrameMain;
	private JMenu mnCourseJFrameMain;
	private JMenuItem mntmManageCourseJFrameMain;
	private JMenuItem mntmAddCourseJFrameMain;
	private JMenu mnProfessorJFrameMain;
	private JMenuItem mntmManageProfessorJFrameMain;
	private JMenuItem mntmAddProfessorJFrameMain;
	private JMenu mnLoginInformationJFrameMain;
	private JMenuItem mntmGoToInformationsJFrameMain;
	private JButton btnENJFrameMain;
	private JButton btnALJFrameMain;
	private JTextField txtNameJFrameMain;
	private JTextField txtSurnameJFrameMain;
	private JTextField txtStudentNumberJFrameMain;
	private JLabel lblNameJFrameMain;
	private JLabel lblSurnameJFrameMain;
	private JLabel lblStudentNumberJFrameMain;
	private JButton btnUpdateJFrameMain;

	/**
	 * Create the dialog.
	 */
	public JFrameMain() {
		super("Main menu...");
		adminPanelJFrameMain = new JPanel();
		btnENJFrameMain = new JButton("EN");
		btnALJFrameMain = new JButton("AL");
		lblNameJFrameMain = new JLabel("Name");
		btnUpdateJFrameMain = new JButton("Update");
		txtStudentNumberJFrameMain = new JTextField();
		txtStudentNumberJFrameMain.setEditable(false);
		txtSurnameJFrameMain = new JTextField();
		txtNameJFrameMain = new JTextField();
		lblStudentNumberJFrameMain = new JLabel("Student Number");
		lblSurnameJFrameMain = new JLabel("Surname");
		btnLogOutJFrameMain = new JButton("Logout");
		btnCancelJFrameMain = new JButton("Cancel");
		menuBariJFrameMain = new JMenuBar();
		mntmRegistrationJFrameMain = new JMenuItem("Registration");

		setBounds(MAXIMIZED_BOTH, MAXIMIZED_BOTH, 825, 571);
		adminPanelJFrameMain.setBounds(0, 0, 1500, 2000);

		btnLogOutJFrameMain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogOutJFrameMain.setBounds(1435, 740, 85, 40);
		btnCancelJFrameMain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelJFrameMain.setBounds(1350, 740, 85, 40);

		setContentPane(adminPanelJFrameMain);
		getContentPane().setLayout(null);
		getContentPane().add(btnLogOutJFrameMain);
		getContentPane().add(btnCancelJFrameMain);
		getContentPane().add(menuBariJFrameMain);

		btnENJFrameMain.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnENJFrameMain.setForeground(Color.RED);
		btnENJFrameMain.setBackground(Color.LIGHT_GRAY);
		btnENJFrameMain.setBounds(1466, 10, 54, 38);
		getContentPane().add(btnENJFrameMain);

		btnALJFrameMain.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnALJFrameMain.setForeground(Color.RED);
		btnALJFrameMain.setBackground(Color.LIGHT_GRAY);
		btnALJFrameMain.setBounds(1411, 10, 54, 38);
		getContentPane().add(btnALJFrameMain);

		lblNameJFrameMain.setBounds(640, 126, 94, 16);
		lblSurnameJFrameMain.setBounds(640, 190, 94, 16);
		lblStudentNumberJFrameMain.setBounds(640, 257, 94, 16);
		txtNameJFrameMain.setBounds(740, 123, 116, 22);
		txtNameJFrameMain.setColumns(10);
		txtSurnameJFrameMain.setBounds(740, 187, 116, 22);
		txtSurnameJFrameMain.setColumns(10);
		txtStudentNumberJFrameMain.setBounds(740, 254, 116, 22);
		txtStudentNumberJFrameMain.setColumns(10);
		btnUpdateJFrameMain.setBounds(740, 304, 116, 25);

		mnStudentJFrameMain = new JMenu("Student");
		mntmManageStudentJFrameMain = new JMenuItem("Manage");
		mntmAddStudentJFrameMain = new JMenuItem("Add");
		mnCourseJFrameMain = new JMenu("Course");
		mntmManageCourseJFrameMain = new JMenuItem("Manage");
		mntmAddCourseJFrameMain = new JMenuItem("Add");
		mnProfessorJFrameMain = new JMenu("Professor");
		mntmManageProfessorJFrameMain = new JMenuItem("Manage");
		mntmAddProfessorJFrameMain = new JMenuItem("Add");
		mnLoginInformationJFrameMain = new JMenu("User Information");
		mntmGoToInformationsJFrameMain = new JMenuItem("Go to Informations");

		mnStudentJFrameMain.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnCourseJFrameMain.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnLoginInformationJFrameMain.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnProfessorJFrameMain.setFont(new Font("Segoe UI", Font.BOLD, 15));

		if (LoggedInUser.getInstance().getUser().getDivision().equals("Admin")) {
			mnLoginInformationJFrameMain.add(mntmGoToInformationsJFrameMain);
			menuBariJFrameMain.add(mnProfessorJFrameMain);
			mnProfessorJFrameMain.add(mntmAddProfessorJFrameMain);
			menuBariJFrameMain.add(mnLoginInformationJFrameMain);
			menuBariJFrameMain.add(mnCourseJFrameMain);
			mnCourseJFrameMain.add(mntmManageCourseJFrameMain);
			mnCourseJFrameMain.add(mntmAddCourseJFrameMain);
			mnProfessorJFrameMain.add(mntmManageProfessorJFrameMain);
			menuBariJFrameMain.add(mnStudentJFrameMain);
			mnStudentJFrameMain.add(mntmManageStudentJFrameMain);
			mnStudentJFrameMain.add(mntmAddStudentJFrameMain);

			menuBariJFrameMain.setBounds(0, 0, 370, 26);

		} else if (LoggedInUser.getInstance().getUser().getDivision().equals("Professor")) {
			menuBariJFrameMain.add(mnStudentJFrameMain);
			mnStudentJFrameMain.add(mntmManageStudentJFrameMain);
			mnStudentJFrameMain.add(mntmAddStudentJFrameMain);
			menuBariJFrameMain.add(mnCourseJFrameMain);
			mnCourseJFrameMain.add(mntmManageCourseJFrameMain);
			mnCourseJFrameMain.add(mntmAddCourseJFrameMain);

			menuBariJFrameMain.setBounds(0, 0, 200, 26);

		} else if (LoggedInUser.getInstance().getUser().getDivision().equals("Student")) {
			menuBariJFrameMain.add(mnStudentJFrameMain);
			menuBariJFrameMain.setBounds(0, 0, 100, 26);
			mnStudentJFrameMain.add(mntmRegistrationJFrameMain);

			adminPanelJFrameMain.add(lblNameJFrameMain);
			adminPanelJFrameMain.add(lblSurnameJFrameMain);
			adminPanelJFrameMain.add(lblStudentNumberJFrameMain);
			adminPanelJFrameMain.add(txtSurnameJFrameMain);
			adminPanelJFrameMain.add(txtStudentNumberJFrameMain);
			adminPanelJFrameMain.add(btnUpdateJFrameMain);
			adminPanelJFrameMain.add(txtNameJFrameMain);

			txtNameJFrameMain.setText(LoggedInUser.getInstance().getUser().getName());
			txtSurnameJFrameMain.setText(LoggedInUser.getInstance().getUser().getSurname());
			txtStudentNumberJFrameMain
					.setText(studentService.getStudentNumber(LoggedInUser.getInstance().getUser().getuID()));

		}
		btnUpdateJFrameMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student s = new Student();
				try {
					s.setName(txtNameJFrameMain.getText());
					s.setSurname(txtSurnameJFrameMain.getText());

					studentService.updateStudent(s, LoggedInUser.getInstance().getUser().getuID());
					JOptionPane.showMessageDialog(null, "Name and Surname Updated");

					txtNameJFrameMain.setText(LoggedInUser.getInstance().getUser().getName());
					txtSurnameJFrameMain.setText(LoggedInUser.getInstance().getUser().getSurname());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		btnALJFrameMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResourceBundle mybundle;
				Locale.setDefault(new Locale("sq", "AL"));
				mybundle = ResourceBundle.getBundle("Bundle");
				setTitle(mybundle.getString("titleMainMenu"));
				btnLogOutJFrameMain.setText(mybundle.getString("btnLogOutJFrameMain"));
				btnCancelJFrameMain.setText(mybundle.getString("btnCancelJFrameMain"));
				mntmRegistrationJFrameMain.setText(mybundle.getString("mntmRegistrationJFrameMain"));
				mntmManageStudentJFrameMain.setText(mybundle.getString("mntmManageStudentJFrameMain"));
				mntmAddStudentJFrameMain.setText(mybundle.getString("mntmAddStudentJFrameMain"));
				mntmManageCourseJFrameMain.setText(mybundle.getString("mntmManageCourseJFrameMain"));
				mntmAddCourseJFrameMain.setText(mybundle.getString("mntmAddCourseJFrameMain"));
				mntmManageProfessorJFrameMain.setText(mybundle.getString("mntmManageProfessorJFrameMain"));
				mntmAddProfessorJFrameMain.setText(mybundle.getString("mntmAddProfessorJFrameMain"));
				mnCourseJFrameMain.setText(mybundle.getString("mnCourseJFrameMain"));
				mnLoginInformationJFrameMain.setText(mybundle.getString("mnLoginInformationJFrameMain"));
				mntmGoToInformationsJFrameMain.setText(mybundle.getString("mntmGoToInformationsJFrameMain"));
				btnUpdateJFrameMain.setText(mybundle.getString("btnUpdateJFrameMain"));
				lblStudentNumberJFrameMain.setText(mybundle.getString("lblStudentNumberJFrameMain"));
				lblSurnameJFrameMain.setText(mybundle.getString("lblSurnameJFrameMain"));
				lblNameJFrameMain.setText(mybundle.getString("lblNameJFrameMain"));

				menuBariJFrameMain.setBounds(0, 0, 450, 26);
				LoggedInUser.getInstance().setLanguage("AL");
			}
		});
		LoggedInUser.getInstance().setLanguage("EN");
		btnENJFrameMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResourceBundle mybundle;
				Locale.setDefault(new Locale("en", "US"));
				mybundle = ResourceBundle.getBundle("Bundle");
				setTitle(mybundle.getString("titleMainMenu"));
				btnLogOutJFrameMain.setText(mybundle.getString("btnLogOutJFrameMain"));
				btnCancelJFrameMain.setText(mybundle.getString("btnCancelJFrameMain"));
				mntmRegistrationJFrameMain.setText(mybundle.getString("mntmRegistrationJFrameMain"));
				mntmManageStudentJFrameMain.setText(mybundle.getString("mntmManageStudentJFrameMain"));
				mntmAddStudentJFrameMain.setText(mybundle.getString("mntmAddStudentJFrameMain"));
				mntmManageCourseJFrameMain.setText(mybundle.getString("mntmManageCourseJFrameMain"));
				mntmAddCourseJFrameMain.setText(mybundle.getString("mntmAddCourseJFrameMain"));
				mntmManageProfessorJFrameMain.setText(mybundle.getString("mntmManageProfessorJFrameMain"));
				mntmAddProfessorJFrameMain.setText(mybundle.getString("mntmAddProfessorJFrameMain"));
				mnCourseJFrameMain.setText(mybundle.getString("mnCourseJFrameMain"));
				mnLoginInformationJFrameMain.setText(mybundle.getString("mnLoginInformationJFrameMain"));
				mntmGoToInformationsJFrameMain.setText(mybundle.getString("mntmGoToInformationsJFrameMain"));
				btnUpdateJFrameMain.setText(mybundle.getString("btnUpdateJFrameMain"));
				lblStudentNumberJFrameMain.setText(mybundle.getString("lblStudentNumberJFrameMain"));
				lblSurnameJFrameMain.setText(mybundle.getString("lblSurnameJFrameMain"));
				lblNameJFrameMain.setText(mybundle.getString("lblNameJFrameMain"));
				
				LoggedInUser.getInstance().setLanguage("EN");
			}
		});

		mntmRegistrationJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogStudentRegistration registration = new JDialogStudentRegistration();
				registration.setVisible(true);
				registration.pack();
				registration.setBounds(700, 500, 1000, 500);
			}
		});
		mntmManageProfessorJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogManageProfessor manageProf = new JDialogManageProfessor();
				manageProf.setVisible(true);
				manageProf.pack();
				manageProf.setBounds(700, 500, 1000, 500);

			}
		});

		mntmAddProfessorJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogAddProfessor addProf = new JDialogAddProfessor();
				addProf.setVisible(true);
				addProf.pack();
				addProf.setBounds(700, 300, 450, 400);
			}
		});

		mntmManageStudentJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogManageStudent mnStudent = new JDialogManageStudent();
				mnStudent.setVisible(true);
				mnStudent.pack();
				mnStudent.setLocationRelativeTo(null);
				mnStudent.setBounds(500, 300, 1000, 500);
			}
		});

		mntmAddStudentJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogAddStudent addStudent = new JDialogAddStudent();
				addStudent.setVisible(true);
				addStudent.pack();
				addStudent.setLocationRelativeTo(null);
				addStudent.setBounds(700, 300, 450, 400);
			}
		});

		mntmManageCourseJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogManageCourse mnCourse = new JDialogManageCourse();
				mnCourse.setVisible(true);
				mnCourse.pack();
				mnCourse.setLocationRelativeTo(null);
				mnCourse.setBounds(500, 300, 1000, 500);
			}
		});

		mntmAddCourseJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogAddCourse addCourse = new JDialogAddCourse();
				addCourse.setVisible(true);
				addCourse.pack();
				addCourse.setLocationRelativeTo(null);
				addCourse.setBounds(700, 300, 450, 400);
			}
		});
		mntmGoToInformationsJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialogUsers logInfo = new JDialogUsers();
				logInfo.setVisible(true);
				logInfo.pack();
				logInfo.setBounds(500, 300, 1000, 500);

			}
		});

		btnCancelJFrameMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnLogOutJFrameMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoggedInUser.getInstance().logOut();

				JDialogLogin out = new JDialogLogin();
				out.setVisible(true);
				out.pack();
				out.setBounds(((Settings.getScreenSize().width / 2) - 175),
						((Settings.getScreenSize().height / 2) - 150), 350, 200);
				dispose();
			}
		});

	}
}
