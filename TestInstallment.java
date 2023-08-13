package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TestInstallment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TestInstallment dialog = new TestInstallment();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TestInstallment() {
		setTitle("Test Installmentation");
		setBounds(100, 100, 766, 538);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblid = new JLabel("Installment ID:");
		lblid.setBounds(10, 39, 93, 20);
		contentPanel.add(lblid);
		
		JLabel lblstu = new JLabel("Student ID:");
		lblstu.setBounds(10, 71, 93, 20);
		contentPanel.add(lblstu);
		
		JLabel lblstuName = new JLabel("Student Name:");
		lblstuName.setBounds(10, 103, 93, 20);
		contentPanel.add(lblstuName);
		
		JLabel lblnrc = new JLabel("NRC No:");
		lblnrc.setBounds(10, 134, 93, 20);
		contentPanel.add(lblnrc);
		
		JLabel lblph = new JLabel("Phone No:");
		lblph.setBounds(10, 165, 93, 20);
		contentPanel.add(lblph);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setBounds(10, 196, 93, 20);
		contentPanel.add(lblemail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 230, 93, 20);
		contentPanel.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 261, 93, 20);
		contentPanel.add(lblGender);
		
		JLabel lblFather = new JLabel("Father:");
		lblFather.setBounds(10, 292, 93, 20);
		contentPanel.add(lblFather);
		
		JLabel lblid1 = new JLabel("");
		lblid1.setBounds(141, 42, 93, 20);
		contentPanel.add(lblid1);
		Border b=BorderFactory.createLineBorder(Color.BLACK);
		
		JLabel lbldob = new JLabel("Date of Birth:");
		lbldob.setBounds(10, 323, 93, 20);
		contentPanel.add(lbldob);
		
		JLabel lblinstallment = new JLabel("Installment Payment:");
		lblinstallment.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblinstallment.setBounds(10, 11, 178, 14);
		contentPanel.add(lblinstallment);
		
		JComboBox cbostuid = new JComboBox();
		cbostuid.setBounds(141, 70, 105, 22);
		contentPanel.add(cbostuid);
		
		JLabel stuName1 = new JLabel("");
		stuName1.setBounds(141, 103, 93, 20);
		contentPanel.add(stuName1);
		
		JLabel stunrc1 = new JLabel("");
		stunrc1.setBounds(141, 134, 93, 20);
		contentPanel.add(stunrc1);
		
		JLabel stuph1 = new JLabel("");
		stuph1.setBounds(141, 165, 93, 20);
		contentPanel.add(stuph1);
		
		JLabel stuEmail1 = new JLabel("");
		stuEmail1.setBounds(141, 196, 93, 20);
		contentPanel.add(stuEmail1);
		
		JLabel lblAddress1 = new JLabel("");
		lblAddress1.setBounds(141, 227, 93, 20);
		contentPanel.add(lblAddress1);
		
		JLabel lblGender1 = new JLabel("");
		lblGender1.setBounds(141, 261, 93, 20);
		contentPanel.add(lblGender1);
		
		JLabel lblFather1 = new JLabel("");
		lblFather1.setBounds(141, 292, 93, 20);
		contentPanel.add(lblFather1);
		
		JLabel lbldob1 = new JLabel("");
		lbldob1.setBounds(141, 323, 93, 20);
		contentPanel.add(lbldob1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 308, 353);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(367, 30, 350, 393);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblstuName_1 = new JLabel("Student Name:");
		lblstuName_1.setBounds(10, 11, 93, 20);
		panel_1.add(lblstuName_1);
		
		JLabel lblid1_1 = new JLabel("");
		lblid1_1.setBounds(151, 11, 93, 20);
		panel_1.add(lblid1_1);
		
		JLabel lblday = new JLabel("Day:");
		lblday.setBounds(10, 42, 93, 20);
		panel_1.add(lblday);
		
		JLabel lblstime = new JLabel("From: Time");
		lblstime.setBounds(10, 73, 93, 20);
		panel_1.add(lblstime);
		
		JLabel lbletime = new JLabel("To: Time");
		lbletime.setBounds(10, 104, 93, 20);
		panel_1.add(lbletime);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setBounds(10, 135, 93, 20);
		panel_1.add(lblFee);
		
		JLabel lblTeacher = new JLabel("Teacher:");
		lblTeacher.setBounds(10, 166, 93, 20);
		panel_1.add(lblTeacher);
		
		JLabel lblRoom = new JLabel("Room:");
		lblRoom.setBounds(10, 200, 93, 20);
		panel_1.add(lblRoom);
		
		JLabel lblEdate = new JLabel("Enrollment Date:");
		lblEdate.setBounds(10, 231, 93, 20);
		panel_1.add(lblEdate);
		
		JLabel lbleFee = new JLabel("Enrollment Fee:");
		lbleFee.setBounds(10, 262, 93, 20);
		panel_1.add(lbleFee);
		
		JLabel lblrest = new JLabel("Rest of Amount:");
		lblrest.setBounds(10, 291, 93, 20);
		panel_1.add(lblrest);
		
		JLabel lblinamount = new JLabel("Installment Amount:");
		lblinamount.setBounds(10, 322, 114, 20);
		panel_1.add(lblinamount);
		
		JLabel lblinDate = new JLabel("Installment Date:");
		lblinDate.setBounds(10, 353, 93, 20);
		panel_1.add(lblinDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 10, 114, 22);
		panel_1.add(comboBox);
		
		JLabel lblday1 = new JLabel("");
		lblday1.setBounds(161, 42, 114, 20);
		panel_1.add(lblday1);
		
		JLabel lblstime1 = new JLabel("");
		lblstime1.setBounds(161, 73, 114, 20);
		panel_1.add(lblstime1);
		
		JLabel lbletime1 = new JLabel("");
		lbletime1.setBounds(161, 104, 114, 20);
		panel_1.add(lbletime1);
		
		JLabel lblfee1 = new JLabel("");
		lblfee1.setBounds(161, 135, 114, 20);
		panel_1.add(lblfee1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(161, 166, 114, 20);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(161, 200, 114, 20);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(161, 231, 114, 20);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(161, 262, 114, 20);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(161, 291, 114, 20);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(161, 353, 114, 20);
		panel_1.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(161, 322, 114, 20);
		panel_1.add(textField);
		textField.setColumns(10);
	}
}
