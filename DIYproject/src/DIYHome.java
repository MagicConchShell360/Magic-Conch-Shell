import javax.swing.*;

public class DIYHome extends JFrame {
	/* Serial UID*/
	private static final long serialVersionUID = 1L;
	/* Button for the home screen*/
	private JButton myHomeButton;
	/* Panel to add to the frame. */
	private JPanel myMainJPanel;
	/* Frame for the overall window. */
	private JFrame myJFrame;
	
	public DIYHome() {
		myHomeButton = new JButton("Welcome!");
		myMainJPanel = new JPanel();
		myJFrame = new JFrame("DIY Project");
		initiate();
	}

	private void initiate() {
		myJFrame.add(myMainJPanel);
		myMainJPanel.add(myHomeButton);
		myJFrame.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		myJFrame.setVisible(true);
//		myJFrame.add(myMainJPanel);
//		myMainJPanel.add(myHomeButton);
//	}

}
