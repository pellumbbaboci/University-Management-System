package com.university.presantation;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.university.model.Course;
import com.university.model.LoggedInUser;
import com.university.service.UniversityService;
import com.university.service.UniversityServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class JDialogManageCourse extends JDialog {
	private UniversityService uniService = new UniversityServiceImpl();

	private JTextField txtProfUserID;
	private JTextField txtCName;
	private JTextField txtHours;
	private JLabel lblProfessorUserID;
	private JLabel lblCourseName;
	private JLabel lblManageCourse;
	private JLabel lblHours;
	private JPanel panel;
	private JButton btnRemoveCourse;
	private JButton btnAddCourse;
	private JButton btnEditCourse;
	private JButton btnListAllCourses;
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public JDialogManageCourse() {
		
		setTitle("Manage Course");
		setModal(true);
		panel = new JPanel();
		lblProfessorUserID = new JLabel("Professor User ID");
		lblCourseName = new JLabel("Course Name");
		lblManageCourse = new JLabel("Manage Course");
		txtProfUserID = new JTextField();
		btnRemoveCourse = new JButton("Remove");
		btnAddCourse = new JButton("Add");
		btnEditCourse = new JButton("Edit");
		btnListAllCourses = new JButton("List All Courses");
		txtCName = new JTextField();
		txtHours = new JTextField();
		lblHours = new JLabel("Hours");

		lblCourseName.setBounds(45, 107, 77, 16);
		lblProfessorUserID.setBounds(45, 68, 109, 16);
		lblManageCourse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblManageCourse.setBounds(188, 13, 159, 41);
		txtProfUserID.setColumns(10);
		txtProfUserID.setBounds(155, 65, 136, 22);
		txtCName.setColumns(10);
		txtCName.setBounds(155, 104, 136, 22);
		btnAddCourse.setBounds(217, 179, 74, 36);
		btnEditCourse.setBounds(155, 179, 68, 36);
		btnRemoveCourse.setBounds(155, 228, 136, 38);
		btnListAllCourses.setBounds(303, 64, 129, 25);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(12, 13, 862, 305);
		setBounds(100, 100, 904, 385);
		txtHours.setColumns(10);
		txtHours.setBounds(155, 144, 136, 22);
		lblHours.setBounds(45, 147, 56, 16);

		panel.add(lblProfessorUserID);
		panel.add(lblCourseName);
		panel.add(lblManageCourse);
		panel.add(txtProfUserID);
		panel.add(txtCName);
		panel.add(btnEditCourse);
		panel.add(btnAddCourse);
		panel.add(btnRemoveCourse);
		panel.add(btnListAllCourses);
		panel.add(lblHours);
		panel.add(txtHours);

		getContentPane().setLayout(null);
		getContentPane().add(panel);

		String[] header = { "Course Id", "Course name", "Professor User Id", "Credit Hours" };
		String[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, header);
		table = new JTable(model);
		table.setBounds(304, 122, 547, 227);
		table.setPreferredScrollableViewportSize(new Dimension(450, 63));
		table.setFillsViewportHeight(true);

		JScrollPane js = new JScrollPane(table);
		js.setBounds(303, 93, 547, 174);
		panel.add(js);
		js.setVisible(true);

		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int column = 0;
					int row = table.getSelectedRow();
					int value = (int) table.getModel().getValueAt(row, column);
					uniService.deleteCourse(value);
					Methods.removeSelectedFromTable(table);

					JOptionPane.showMessageDialog(null, "Course Deleted!!!");

				//	JFrameMain.fieldNoCourse.setText("Number of Courses    : " + uniService.countCourses());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				int value = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
				Course c = new Course();
				try {
					c.setCourseName(txtCName.getText());
					c.setProfUserID(Integer.parseInt(txtProfUserID.getText()));
					c.setHours(Integer.parseInt(txtHours.getText()));

					uniService.updateCourse(c, value);
					JOptionPane.showMessageDialog(null, "Course Updated");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				model.setValueAt(txtCName.getText(), row, 1);
				model.setValueAt(txtProfUserID.getText(), row, 2);
				model.setValueAt(txtHours.getText(), row, 3);

			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtCName.setText((String) model.getValueAt(row, 1));
				txtHours.setText(model.getValueAt(row, 3).toString());
				txtProfUserID.setText(model.getValueAt(row, 2).toString());

			}
		});

		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course c = new Course();
				try {

					c.setCourseName(txtCName.getText());
					c.setHours(Integer.parseInt(txtHours.getText()));
					c.setProfUserID(Integer.parseInt(txtProfUserID.getText()));

					if (LoggedInUser.getInstance().getUser().getDivision().equals("Professor")
							|| LoggedInUser.getInstance().getUser().getDivision().equals("Admin")) {
						uniService.addCourse(c);
						JOptionPane.showMessageDialog(null, "Course Added !!!");

					//	JFrameMain.fieldNoCourse.setText("Number of Courses    : " + uniService.countCourses());

					} else {
						JOptionPane.showMessageDialog(null, "You must be Admin or Professor to add a Course !", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					txtCName.setText("");
					txtHours.setText("");
					txtProfUserID.setText("");

				} catch (Exception evt) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					evt.printStackTrace();
				}
			}
		});

		btnListAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (model.getRowCount() > 0)
						model.setNumRows(0);

					List<Course> courses = uniService.getAllCourses();
					List<Object> mappedData = courses.stream().map(toObject()).collect(Collectors.toList());

					mappedData.forEach(data -> model.addRow((Object[]) data));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			private Function<Course, Object> toObject() {

				return course -> {
					Object[] data = { course.getcID(), course.getCourseName(), course.getProfUserID(),
							course.getHours() };

					return data;
				};
			}

		});

	}
}
