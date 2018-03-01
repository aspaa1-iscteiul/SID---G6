package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class AuthenticationGui {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private JButton login;
	private JButton signUp;

	public AuthenticationGui() {

		frame = new JFrame("Monitorização de culturas");
		JPanel overallPanel = new JPanel(new GridLayout(3,1));
		JPanel usernamePanel = new JPanel(new FlowLayout());
		JPanel passwordPanel = new JPanel(new FlowLayout());
		JPanel buttonPanel = new JPanel(new FlowLayout());

		usernamePanel.add(new JLabel("Username:"));
		username = new JTextField();
		username.setPreferredSize(new Dimension(168,20));
		usernamePanel.add(username);

		passwordPanel.add(new JLabel("Password:"));
		password = new JPasswordField(15);
		passwordPanel.add(password);

		login = new JButton("Login");

		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DBconnector().connect(username.getText(), charArrayToString(password.getPassword()));
					setConnectionBackgroudColor(overallPanel, usernamePanel, passwordPanel, buttonPanel);
				} catch (SQLException e1) {
					setDisconnectionBackgroudColor(usernamePanel, passwordPanel, buttonPanel);
					JOptionPane.showMessageDialog(null, "Não foi possível efectuar o login");
				}
			}
		});

		signUp = new JButton("Sign Up");
		buttonPanel.add(login);
		buttonPanel.add(signUp);

		overallPanel.add(usernamePanel);
		overallPanel.add(passwordPanel);
		overallPanel.add(buttonPanel);

		frame.add(overallPanel);
	}

	public void open(){
		frame.setSize(400,150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		centreWindow(frame);
	}

	public static void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	private String charArrayToString(char[] array) {
		String string = "";
		for(int i=0; i<array.length;i++) {
			string = string + array[i];
		}
		return string;
	}

	private void setDisconnectionBackgroudColor(JPanel usernamePanel, JPanel passwordPanel, JPanel buttonPanel){
		Color color = new Color(219,151,149).brighter();
		usernamePanel.setBackground(color);
		passwordPanel.setBackground(color);
		buttonPanel.setBackground(color);
	}

	private void setConnectionBackgroudColor(JPanel overallPanel, JPanel usernamePanel, JPanel passwordPanel, JPanel buttonPanel){
		Color color = new Color(155, 226, 155).brighter();
		usernamePanel.setBackground(color);
		passwordPanel.setBackground(color);
		buttonPanel.setBackground(color);
	}


	public static void main(String[] args) {

		AuthenticationGui authenticationWindow = new AuthenticationGui();
		authenticationWindow.open();
	}

}
