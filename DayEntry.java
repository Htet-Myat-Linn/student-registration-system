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
import javax.swing.JTextField;

public class DayEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DayEntry dialog = new DayEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DayEntry() {
		setTitle("Day Entry:");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Day ID:");
		lblNewLabel.setBounds(29, 42, 90, 26);
		contentPanel.add(lblNewLabel);
		
		JLabel lblsday = new JLabel("Day Entry:");
		lblsday.setBounds(29, 96, 90, 26);
		contentPanel.add(lblsday);
		
		textField = new JTextField();
		textField.setBounds(183, 96, 131, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lbldid = new JLabel("");
		Border b=BorderFactory.createLineBorder(Color.BLACK);
		lbldid.setBorder(b);
		lbldid.setBounds(183, 42, 131, 26);
		contentPanel.add(lbldid);
	}
}
