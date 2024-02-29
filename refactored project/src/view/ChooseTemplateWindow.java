package view;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import controller.LatexEditorController;
import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorController;
import controller.UserInterfaceInformationCollectorHandler;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ChooseTemplateWindow {

	private JFrame frame;
	
	private JRadioButton bookRadioButton ;
	private JRadioButton articleRadioButton ;
	private JRadioButton reportRadioButton ;
	private JRadioButton letterRadioButton ;
	
	private JLabel chooseTemplateLabel ;
	
	private JButton backButton ;
	private JButton createButton ;

	private UserInterfaceInformationCollectorController userInfromationController ;
	private LatexEditorController latexEditorController ;
	private String previous;

	/*
	 * Create the application.
	 */
	public ChooseTemplateWindow(String previous) {
		
		userInfromationController = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance() ;
		latexEditorController = LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance() ;
		
		this.previous = previous;
		
		initialize();
		
		frame.setVisible(true);
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		createComponents();
		setComponentsBounds();
		addComponentsToFrame();
		
		initRadioButtons() ;
		initCreateButton();
		initBackButton();
	}

	
	private void diselectAllRadioButtonsExceptFrom(JRadioButton enableRadioButton) {
		
		bookRadioButton.setSelected(false);
		articleRadioButton.setSelected(false);
		reportRadioButton.setSelected(false);
		letterRadioButton.setSelected(false);
		
		enableRadioButton.setSelected(true);
	}
	
	private void createComponents() {
		
		bookRadioButton = new JRadioButton("Book");
		articleRadioButton = new JRadioButton("Article");
		reportRadioButton = new JRadioButton("Report");
		letterRadioButton = new JRadioButton("Letter");

		createButton = new JButton("Create");
		backButton = new JButton("Back");
		
		chooseTemplateLabel = new JLabel("Choose template. (Leave empty for blank document)");

	}
	
	private void setComponentsBounds() {
		
		chooseTemplateLabel.setBounds(42, 13, 332, 16);
		
		letterRadioButton.setBounds(213, 137, 127, 25);
		reportRadioButton.setBounds(213, 51, 127, 25);
		articleRadioButton.setBounds(42, 137, 127, 25);
		bookRadioButton.setBounds(42, 51, 127, 25);
		
		createButton.setBounds(213, 196, 97, 25);
		backButton.setBounds(46, 196, 97, 25);
		
	}
	
	private void addComponentsToFrame() {

		frame.getContentPane().add(chooseTemplateLabel);
		
		frame.getContentPane().add(letterRadioButton);
		frame.getContentPane().add(reportRadioButton);
		frame.getContentPane().add(articleRadioButton);
		frame.getContentPane().add(bookRadioButton);
		
		frame.getContentPane().add(createButton);
		frame.getContentPane().add(backButton);
		
	}

	private void initCreateButton() {

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(bookRadioButton.isSelected()) {
					userInfromationController.setType("bookTemplate");
				}
				else if(reportRadioButton.isSelected()) {
					userInfromationController.setType("reportTemplate");
				}
				else if(articleRadioButton.isSelected()) {
					userInfromationController.setType("articleTemplate");
				}
				else if(letterRadioButton.isSelected()) {
					userInfromationController.setType("letterTemplate");
				}
				else {
					userInfromationController.setType("emptyTemplate");
				}

				latexEditorController.executeCommand("create");
				
				MainWindow mainWindow = new MainWindow();
				frame.dispose();
			}
		});
	}

	private void initBackButton() {

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(previous.equals("main")) {
					MainWindow mainWindow = new MainWindow();
					frame.dispose();
				}
				else {
					OpeningWindow openingWindow = new OpeningWindow();
					frame.dispose();
				}
			}
		});
	}
	
	private void initRadioButtons() {
		bookRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				diselectAllRadioButtonsExceptFrom(bookRadioButton);
			}
		});
		
		articleRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				diselectAllRadioButtonsExceptFrom(articleRadioButton);
				
			}
		});
		
		reportRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				diselectAllRadioButtonsExceptFrom(reportRadioButton);
			}
		});
		
		letterRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				diselectAllRadioButtonsExceptFrom(letterRadioButton);
			}
		});
		
	}
}
