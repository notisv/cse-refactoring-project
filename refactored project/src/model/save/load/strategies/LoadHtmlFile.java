package model.save.load.strategies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorHandler;

public class LoadHtmlFile extends LoadStrategy{

	public void loadFile() {
		String fileContents = "";
		
		try {
			Scanner scanner = new Scanner(new FileInputStream(UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getFilename()));
			while(scanner.hasNextLine()) {
				
				fileContents = loadFileContents(fileContents, scanner);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().setCurrentDocumentContents(fileContents);
	}


	private String loadFileContents(String fileContents, Scanner scanner) {
		String line = scanner.nextLine() ;
		line = convertHTMLToLatex(line) ;
		
		fileContents = fileContents + line ;
		return fileContents;
	}

	
	public String convertHTMLToLatex(String line) {
		
		
		if(isTagNonConvertedToLatex(line)){
			return "" ;
		}
		
		line = getContentFromHTMLComments(line);
		if(isLatexTagDefineTypeOfTemplate(line)) {
			setTypeOfTemplate(line);
		}
		
		return line + "\n" ;
	}


	private boolean isLatexTagDefineTypeOfTemplate(String line) {
		return line.startsWith("\\documentclass");
	}


	private String getContentFromHTMLComments(String line) {
		
		int startLatexTagPosition = 5 ;
		
		line = line.substring(line.indexOf("<!--") + startLatexTagPosition);			
		line = line.substring(0, line.indexOf("-->"));
		return line;
	}


	private boolean isTagNonConvertedToLatex(String line) {
		return line.contains("<html>") || line.contains("</html>");
	}

}
