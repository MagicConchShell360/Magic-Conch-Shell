import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DIYInfoRead {
	
	private DIYProjectInfo myProjectInfo;
	private JFrame frame;
	
	public DIYInfoRead() {
		frame.setSize(800, 600);
		frame.setTitle("Project Information (Edit-mode)");
		frame.setLayout(new BorderLayout());
		
		setUpComponents();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public void setUpComponents() {

		JPanel panel = new JPanel();
		panel.setSize(100, 800);
		panel.setLayout(new GridLayout());

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				frame.setVisible(false);
			}

		});

		panel.add(backButton, 0);
		frame.add(panel, BorderLayout.WEST);
	}
}
