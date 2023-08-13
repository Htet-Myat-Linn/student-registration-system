package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainRegistration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainRegistration frame = new MainRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainRegistration() {
		setTitle("STUDENT REGISTRATION :");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setBounds(100, 100, 1363, 721);
		setBounds(100, 100, 1363, 721);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu(" ");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnuTeacher = new JMenu("Teacher Info:");
		mnuTeacher.setForeground(Color.BLUE);
		mnuTeacher.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnuTeacher.setMnemonic('T');
		menuBar.add(mnuTeacher);
		
		JMenuItem teaEntry = new JMenuItem("Teacher Entry:");
		teaEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherEntry te=new TeacherEntry();
				te.show();
			}
		});
		teaEntry.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuTeacher.add(teaEntry);
		
		JMenuItem teaUpdate = new JMenuItem("Teacher Update:");
		teaUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherUpdate tu=new TeacherUpdate();
				tu.show();
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		mnuTeacher.add(separator_2);
		teaUpdate.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuTeacher.add(teaUpdate);
		
		JMenuItem teaList = new JMenuItem("Teacher List:");
		teaList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherList tl = null;
				try {
					tl = new TeacherList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tl.show();
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnuTeacher.add(separator_3);
		teaList.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuTeacher.add(teaList);
		
		JMenu mnNewMenu_4 = new JMenu("");
		menuBar.add(mnNewMenu_4);
		
		JMenu mnuRoom = new JMenu("Room Info:");
		mnuRoom.setForeground(Color.BLUE);
		mnuRoom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnuRoom.setMnemonic('R');
		menuBar.add(mnuRoom);
		
		JMenuItem romEntry = new JMenuItem("Room Entry:");
		romEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomEntry re=new RoomEntry();
				re.show();
			}
			
		});
		romEntry.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuRoom.add(romEntry);
		
		JSeparator separator_1 = new JSeparator();
		mnuRoom.add(separator_1);
		
		JMenuItem romList = new JMenuItem("Room List:");
		romList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomList rl = null;
				try {
					rl = new RoomList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rl.show();
			}
		});
		romList.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuRoom.add(romList);
		
		JMenu mnuCourse = new JMenu("Course Schedule:");
		menuBar.add(mnuCourse);
		mnuCourse.setMnemonic('C');
		mnuCourse.setForeground(Color.BLUE);
		mnuCourse.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JMenuItem courseEntry = new JMenuItem("Course Entry:");
		courseEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseSchedule cs=new CourseSchedule();
				cs.show();
			}
		});
		courseEntry.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuCourse.add(courseEntry);
		
		JMenuItem CourseUpdate = new JMenuItem("Course Update:");
		CourseUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseUpdate cp=new CourseUpdate();
				cp.show();
			}
		});
		
		JSeparator separator_4 = new JSeparator();
		mnuCourse.add(separator_4);
		CourseUpdate.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuCourse.add(CourseUpdate);
		
		JMenuItem courseList = new JMenuItem("Course List:");
		courseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseList cl = null;
				try {
					cl = new CourseList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cl.show();
			}
		});
		
		JSeparator separator_5 = new JSeparator();
		mnuCourse.add(separator_5);
		courseList.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuCourse.add(courseList);
		
		JMenu stuMenu = new JMenu("Student Info:");
		menuBar.add(stuMenu);
		stuMenu.setMnemonic('S');
		stuMenu.setForeground(Color.BLUE);
		stuMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JMenuItem stuEntry = new JMenuItem("Student Entry:");
		stuEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEntry se=new StudentEntry();
				se.show();
			}
		});
		stuEntry.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		stuMenu.add(stuEntry);
		
		JMenuItem stuUpdate = new JMenuItem("Student Update:");
		stuUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUpdate su=new StudentUpdate();
				su.show();
				
			}
		});
		
		JSeparator separator_6 = new JSeparator();
		stuMenu.add(separator_6);
		stuUpdate.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		stuMenu.add(stuUpdate);
		
		JSeparator separator = new JSeparator();
		stuMenu.add(separator);
		
		JMenuItem stuList = new JMenuItem("Student List:");
		stuList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentList sl = null;
				try {
					sl = new StudentList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sl.show();
			}
		});
		stuList.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		stuMenu.add(stuList);
		
		JMenu mnuRegistration = new JMenu("Registration:");
		menuBar.add(mnuRegistration);
		mnuRegistration.setForeground(Color.BLUE);
		mnuRegistration.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnuRegistration.setMnemonic('R');
		
		JMenuItem regEntry = new JMenuItem("Registration Entry:");
		regEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationEntry re=new RegistrationEntry();
				re.show();
			}
		});
		regEntry.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuRegistration.add(regEntry);
		
		JMenuItem regList = new JMenuItem("Registration List:");
		regList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationList rl = null;
				try {
					rl = new RegistrationList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rl.show();
				
			}
		});
		
		JSeparator separator_7 = new JSeparator();
		mnuRegistration.add(separator_7);
		regList.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuRegistration.add(regList);
		
		JMenu mnuInstallment = new JMenu("Installment :");
		menuBar.add(mnuInstallment);
		mnuInstallment.setForeground(Color.BLUE);
		mnuInstallment.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnuInstallment.setMnemonic('I');
		
		JMenuItem insEntry = new JMenuItem("Installment Entry:");
		insEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstallmentPayment ip=new InstallmentPayment();
				ip.show();
			}
		});
		insEntry.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuInstallment.add(insEntry);
		
		JSeparator separator_8 = new JSeparator();
		mnuInstallment.add(separator_8);
		
		JMenuItem insList = new JMenuItem("Installment List:");
		insList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstallmentList il = null;
				try {
					il = new InstallmentList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				il.show();
			}
		});
		insList.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		mnuInstallment.add(insList);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Su Mon Aung\\Downloads\\pic (1).jpg"));
		lblNewLabel.setBounds(10, 11, 1397, 687);
		contentPane.add(lblNewLabel);
	}
}
