import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DIYInfoEdit {
	
	private DIYProjectInfo myProjectInfo;
	private JFrame frame;
	//private ArrayList<MaterialInfo> myListOfProjects;
	
	public DIYInfoEdit(ArrayList projectInfoList) {
		
		//myListOfProjects = new ArrayList<>();
		//myListOfProjects.addAll(projectInfoList);
		
		frame.setSize(800, 600);
		frame.setTitle("Project Information (Edit-mode)");
		frame.setLayout(new BorderLayout());
		
		setUpComponents();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setUpComponents() {
		
		GridLayout buttonGrid = new GridLayout();
		buttonGrid.setColumns(1);
		buttonGrid.setRows(10);
		
		JPanel westPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		
		westPanel.setSize(100, 800);
		centerPanel.setSize(450, 800);
		eastPanel.setSize(50, 800);
		
		eastPanel.setLayout(buttonGrid);
		
		JButton addButton = new JButton("Add Material");
		JButton viewButton = new JButton("View Material");
		JButton removeButton = new JButton("Remove Material");
		JButton backButton = new JButton("Back");
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				
			}
		});
		
		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				
			}
		});
		
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				
			}
		});
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				frame.setVisible(false);
			}
			
		});
		
		westPanel.add(backButton);
		eastPanel.add(addButton, 7);
		eastPanel.add(viewButton, 8);
		eastPanel.add(removeButton, 9);
		
		frame.add(westPanel, BorderLayout.WEST);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(eastPanel, BorderLayout.EAST);
	}

}
