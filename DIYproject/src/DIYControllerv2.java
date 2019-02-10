import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DIYControllerv2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton myButton; 
	private JPanel myMainPanel;
	
	public DIYControllerv2() {
		super();
		setSize(400, 800);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout(new FlowLayout());
		myMainPanel = new JPanel();
		myButton = new JButton("About");
		myButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				DIYAbout about = new DIYAbout();
				about.showAbout();
			}
		});
		add(myMainPanel);
		add(myButton);
		setVisible(true);
		pack();
	}
	
}
