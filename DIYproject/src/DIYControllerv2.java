import java.awt.FlowLayout;

import javax.swing.*;

public class DIYControllerv2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton myHome; 
	private JPanel myMainPanel;
	
	public DIYControllerv2() {
		super();
		setSize(400, 800);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout(new FlowLayout());
		myMainPanel = new JPanel();
		myHome = new JButton("Home");
		add(myMainPanel);
		add(myHome);
		setVisible(true);
		pack();
	}
	
}
