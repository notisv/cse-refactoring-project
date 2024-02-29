package view;

import java.awt.EventQueue;
import javax.swing.JFrame;

import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorHandler;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;


public class OpeningWindow {

	private JFrame openingWindowFrame;
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningWindow window = new OpeningWindow();
					window.openingWindowFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/*
	 * Create the application.
	 */
	public OpeningWindow() {
		
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance() ;

		initializeGuiComponents();
		openingWindowFrame.setVisible(true);
	}


	private void initializeGuiComponents() {
		
		initFrame();
		
		initCreateNewDocumentButton();
		initOpenExistingDocumentButton();
		initExitButton();
	}

	private void initFrame() {
		
		openingWindowFrame = new JFrame();
		openingWindowFrame.setBounds(100, 100, 450, 300);
		openingWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openingWindowFrame.getContentPane().setLayout(null);
	}

	private void initExitButton() {
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnExit.setBounds(99, 169, 268, 25);
		openingWindowFrame.getContentPane().add(btnExit);
	}

	private void initOpenExistingDocumentButton() {
		
		JButton btnOpenExistingDocument = new JButton("Open Existing LaTeX Document");
		
		btnOpenExistingDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
				
				File file = fileChooser.getSelectedFile();
				if(file == null) {
					return ;
				}
				
				String filename = file.toString() ;
				
				UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().setFilename(filename);
				LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().setLoadStrategy(findInfix(filename));
				LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().executeCommand("load");

				new MainWindow() ;
				openingWindowFrame.dispose();
				
			}
		});
		
		btnOpenExistingDocument.setBounds(89, 92, 278, 36);
		openingWindowFrame.getContentPane().add(btnOpenExistingDocument);
	}
	
	private String findInfix(String filename) {
		
		int infixPosition = filename.lastIndexOf(".");
	    return filename.substring(infixPosition);
	}

	private void initCreateNewDocumentButton() {
		
		JButton btnCreateNewDocument = new JButton("Create New LaTeX Document");
		
		btnCreateNewDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseTemplateWindow chooseTemplate = new ChooseTemplateWindow("opening");
				openingWindowFrame.dispose();
			}
		});
		
		btnCreateNewDocument.setBounds(89, 26, 278, 36);
		openingWindowFrame.getContentPane().add(btnCreateNewDocument);
	}
	
}
