package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import controller.LatexEditorController;
import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorController;
import controller.UserInterfaceInformationCollectorHandler;

import javax.swing.JCheckBoxMenuItem;

public class MainWindow {

	private JFrame frame;
	private JEditorPane editorPane = new JEditorPane();

	private LatexEditorController latexEditorController;
	private UserInterfaceInformationCollectorController userInterfaceInformationCollectorController ;
	
	/*
	 * Create the application.
	 */
	public MainWindow() {
		
		this.latexEditorController = LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance() ;
		this.userInterfaceInformationCollectorController = UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance() ;
		
		initialize();
		
		frame.setVisible(true);
	}


	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 805, 26);
		frame.getContentPane().add(menuBar);

		
		JMenu mnFile = new JMenu("File");
		JMenuItem mntmNewFile = new JMenuItem("New File");
		JMenuItem mntmSave = new JMenuItem("Save Changes");
		JMenuItem addChapter = new JMenuItem("Add chapter");

		
		JMenu mnCommands = new JMenu("Commands");
		
		JMenu loadFromMenu = new JMenu("Load from");
		JMenuItem mntmLoadFromLatexFile = new JMenuItem("Load From Latex");
		JMenuItem mntmLoadFromHTMLFile = new JMenuItem("Load From HTML");
		
		JMenu saveAsSubMenu = new JMenu("Save As") ;
		JMenuItem mntmSaveAsLatexFile = new JMenuItem("Save As Latex");
		JMenuItem mtnSaveAsHTMLFile = new JMenuItem("Save As HTML") ;
		
		JMenu addSection = new JMenu("Add section");
		JMenuItem mntmAddSection = new JMenuItem("Add section");
		JMenuItem mntmAddSubsection = new JMenuItem("Add subsection");
		JMenuItem mntmAddSubsubsection = new JMenuItem("Add subsubsection");
		
		
		JMenu addEnumerationList = new JMenu("Add enumeration list");
		JMenuItem mntmItemize = new JMenuItem("Itemize");
		JMenuItem mntmEnumerate = new JMenuItem("Enumerate");
		JMenuItem addTable = new JMenuItem("Add table");
		JMenuItem addFigure = new JMenuItem("Add figure");
		
		
		JMenu mnStrategy = new JMenu("Versioning Strategy");
		JMenu mnEnable = new JMenu("Enable");
		
		JCheckBoxMenuItem menuVolatile = new JCheckBoxMenuItem("Volatile");
		JCheckBoxMenuItem menuStable = new JCheckBoxMenuItem("Stable");
		
		JMenuItem mntmDisable = new JMenuItem("Disable");
		JMenuItem mntmRollback = new JMenuItem("Rollback to previous version");

		
		menuBar.add(mnFile);
		mnFile.add(mntmNewFile);
		mnFile.add(mntmSave);
		
		loadFromMenu.add(mntmLoadFromHTMLFile) ;
		loadFromMenu.add(mntmLoadFromLatexFile) ;
		
		saveAsSubMenu.add(mntmSaveAsLatexFile) ;
		saveAsSubMenu.add(mtnSaveAsHTMLFile) ;
		
		mnFile.add(saveAsSubMenu) ;
		mnFile.add(loadFromMenu) ;
		
		menuBar.add(mnCommands);
		mnCommands.add(addChapter);
		mnCommands.add(addSection);
		
		addSection.add(mntmAddSection);
		addSection.add(mntmAddSubsection);
		addSection.add(mntmAddSubsubsection);
		
		mnCommands.add(addEnumerationList);
		
		addEnumerationList.add(mntmItemize);
		addEnumerationList.add(mntmEnumerate);
		
		mnCommands.add(addTable);
		mnCommands.add(addFigure);
		menuBar.add(mnStrategy);
		mnStrategy.add(mnEnable);
		
		mnEnable.add(menuVolatile);
		mnEnable.add(menuStable);
	
		mnStrategy.add(mntmDisable);
		mnStrategy.add(mntmRollback);


		mntmNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseTemplateWindow chooseTemplate = new ChooseTemplateWindow("main");
				frame.dispose();
			}
		});

	
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userInterfaceInformationCollectorController.setText(editorPane.getText());
				latexEditorController.executeCommand("edit");
				
			}
		});
		

		mntmLoadFromLatexFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeLoad(addChapter, mnCommands , ".tex");
			}
		});
		
		mntmLoadFromHTMLFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				executeLoad(addChapter, mnCommands , ".html");
			}
		});
		

		mntmSaveAsLatexFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setFileProperties(".tex");
			}
		});	
		
		mtnSaveAsHTMLFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setFileProperties(".html");
			}
		});

		
		if(userInterfaceInformationCollectorController.getTypeOfTemplate().equals("letterTemplate")) {
			mnCommands.setEnabled(false);
		}
		
		addChapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addLatexSubtypeContent("chapter");
			}
		});
		
		
		if(userInterfaceInformationCollectorController.getTypeOfTemplate().equals("articleTemplate")) {
			addChapter.setEnabled(false);
		}

		mntmAddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexSubtypeContent("section");
			}

		});

		mntmAddSubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexSubtypeContent("subsection");
			}
		});

		
		mntmAddSubsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexSubtypeContent("subsubsection");
			}
		});
		
		
		mntmItemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexSubtypeContent("itemizeContent");
			}
		});
		

		mntmEnumerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexSubtypeContent("enumerateConent");
			}
		});
		
		addTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexSubtypeContent("tableConent");
			}
		});
		
		
		addFigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexSubtypeContent("figureContent");
			}
		});
		

		menuStable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userInterfaceInformationCollectorController.setCommandStrategy("stable");
				updateContollerForStrategy(menuVolatile, menuStable);
			}

		});

		
		menuVolatile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userInterfaceInformationCollectorController.setCommandStrategy("volatile");
				updateContollerForStrategy(menuVolatile, menuStable);

			}
		});


		mntmDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorController.executeCommand("disableVersionsManagement");
			}
		});
		
		mntmRollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorController.executeCommand("rollbackToPreviousVersion");
				editorPane.setText(LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().getCurrentDocumentContents());
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 783, 467);
		
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(editorPane);
		
		editorPane.setText(latexEditorController.getCurrentDocumentContents());
	}

	private void setFileProperties(String fileType) {
		
		JFileChooser filechooser = new JFileChooser();
		int option = filechooser.showSaveDialog(null);
		
		if(option == JFileChooser.APPROVE_OPTION) {
			
			String filename = filechooser.getSelectedFile().toString();
			filename = filename + fileType ;

			userInterfaceInformationCollectorController.setFilename(filename);
			
			latexEditorController.setSaveStrategy(fileType);
			latexEditorController.executeCommand("save");
		}
	}
	
	private void addLatexSubtypeContent(String latexSubtype) {
		
		userInterfaceInformationCollectorController.setEditorPaneText(editorPane.getText());
		userInterfaceInformationCollectorController.setEditorPaneCaretPosition(editorPane.getCaretPosition());
		userInterfaceInformationCollectorController.setTypeOfSubtype(latexSubtype);
		
		latexEditorController.executeCommand("addLatex");
		editorPane.setText(userInterfaceInformationCollectorController.getText());
	}
	
	private void setLoadCommandProperties(JMenuItem addChapter, JMenu mnCommands, String filename, String typeOfFile) {
		
		userInterfaceInformationCollectorController.setFilename(filename);
		latexEditorController.setLoadStrategy(typeOfFile);
		latexEditorController.executeCommand("load");
		
		mnCommands.setEnabled(true);
		addChapter.setEnabled(true);
		
		if(userInterfaceInformationCollectorController.getTypeOfTemplate().equals("letterTemplate")) {
			mnCommands.setEnabled(false);
		}
		
		if(userInterfaceInformationCollectorController.getTypeOfTemplate().equals("articleTemplate")) {
			addChapter.setEnabled(false);
		}
	}
	
	private void updateContollerForStrategy(JCheckBoxMenuItem menuVolatile, JCheckBoxMenuItem menuStable) {
		
		if(!latexEditorController.isVerionMangerEnabled()) {
			latexEditorController.executeCommand("enableVersionsManagement");
		}
		else {
			latexEditorController.executeCommand("changeVersionsStrategy");
		}
		
		
		updateGraphicInterfaceFromStrategyProperties(menuVolatile, menuStable);
	}


	private void updateGraphicInterfaceFromStrategyProperties(JCheckBoxMenuItem menuVolatile,JCheckBoxMenuItem menuStable) {
		
		menuVolatile.setSelected(false);
		menuStable.setEnabled(false);
		menuVolatile.setEnabled(true);
	}
	
	private void executeLoad(JMenuItem addChapter, JMenu mnCommands, String infixOfFile) {
		JFileChooser filechooser = new JFileChooser();
		
		int option = filechooser.showOpenDialog(null);
		
		if(option == JFileChooser.APPROVE_OPTION) {
			String filename = filechooser.getSelectedFile().toString();
			
			setLoadCommandProperties(addChapter, mnCommands, filename, infixOfFile);

			editorPane.setText(latexEditorController.getCurrentDocumentContents());
		}
	}
}
	
