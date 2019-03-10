import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DIYTemplate extends JFrame {

	private static final long serialVersionUID = -3145628090769981498L;
	public JPanel myWestPanel;
	public JPanel myCenterPanel;
	
	public DIYTemplate() {
		super();
		myWestPanel = new JPanel();
		myCenterPanel = new JPanel();
		
		setUpFrame();
		setUpWestPanel();
		setUpCenterPanel();
		
	}
	
	protected void setUpFrame() {
		setTitle("MCS DIY Home Improvement Project Organizer");
		setSize(new Dimension(800, 600));
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		add(myWestPanel, BorderLayout.WEST);
		add(myCenterPanel, BorderLayout.CENTER);
	}
	
	protected void setUpWestPanel() {
		myWestPanel.setLayout(new GridLayout(12, 1));
		myWestPanel.setPreferredSize(new Dimension(100, 800));
		myWestPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	protected void setUpCenterPanel() {
		myCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	

}