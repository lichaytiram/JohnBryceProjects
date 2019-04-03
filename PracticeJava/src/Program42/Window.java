package Program42;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Window extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5400649692920309485L;
	private JLabel yossiStatus;
	private JButton yossi;
	private JButton avi;
	
	private AviThread aviThread;
	private YossiThread yossiThread;
	
	
	public Window() 
	{	
		super("Threads example");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		yossiStatus = new JLabel("Yossi is stuck on something pretty bad");
		yossi = new JButton("Yossi started working");
		avi = new JButton("Avi started working on it");
				
		yossiThread = new YossiThread(this.yossiStatus);
		aviThread = new AviThread(yossiThread);
				
		
		setLayout(new FlowLayout());
		
		add(yossiStatus);
		add(yossi);
		add(avi);
		
		yossi.addActionListener(this);
		avi.addActionListener(this);
		
		setSize(300,150);
		setVisible(true);	
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == yossi)
		{
			if (!this.yossiThread.isAlive())
				this.yossiThread.start();
		}
		else if (!this.aviThread.isAlive())
		{
			this.aviThread = new AviThread(this.yossiThread);
			aviThread.start();
		}
	}

}
