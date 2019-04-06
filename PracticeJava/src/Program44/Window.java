package Program44;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8308477127432068804L;

	private JTextField textField;
	private JTextArea chatArea;
	private JButton login;

	public Window() {

		setLayout(new BorderLayout());
		setSize(400, 400);

		this.textField = new JTextField(10);
		this.chatArea = new JTextArea(20, 20);
		this.login = new JButton("Send");

		this.login.addActionListener(this);

		add(textField, BorderLayout.NORTH);
		add(this.chatArea, BorderLayout.CENTER);
		add(login, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Extracting the user's text
		String text = this.textField.getText();

		String currentChat = this.chatArea.getText() + "\n" + text;
		this.textField.setText("");
		this.chatArea.setText(currentChat);
	}

	public static void main(String[] args) {
		new Window();
	}
}
