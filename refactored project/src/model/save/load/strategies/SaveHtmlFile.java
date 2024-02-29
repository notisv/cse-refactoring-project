package model.save.load.strategies;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import constants.StringConstants;
import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorHandler;

public class SaveHtmlFile extends SaveStrategy{

	public void saveFile() {
		
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getFilename()));

			Scanner scanner = new Scanner(LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().getCurrentDocumentContents());
			
			printWriter.write("<html>\n") ;
			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				
				printWriter.write("<!-- " + line + " --> ") ;
				line = convertLatexToHtml(line) ;
				
				printWriter.write(line + "\n") ;
			}
			printWriter.write("</html>");
			
			scanner.close();
			printWriter.close();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String convertLatexToHtml(String line) {
		
		String latexTag = findLatexTagInLine(line) ;
		line = line.replace(latexTag, "") ;
		
		return createHTMLTagFromLatexContents(line, latexTag);
	}


	private String createHTMLTagFromLatexContents(String line, String latexTag) {
		String htmlLine = "" ;
		
		if(isNotLineEmpty(line, latexTag)) {
			
			// Create HTML Tag
			htmlLine = StringConstants.LATEX_TO_HTML_TAGS_MAP.get(latexTag) ;
			
			String endTag = htmlLine ;
			endTag = createEndHTMLTag(endTag) ;
			
			line = getLatexContentOfBrackets(line);
			
			htmlLine+= line + endTag;
		}
		
		return htmlLine;
	}

	private boolean isNotLineEmpty(String line, String latexTag) {
		return !line.equals("") && !latexTag.equals("");
	}

	private String createEndHTMLTag(String endTag) {
		return endTag.substring(0,1) + "/" + endTag.substring(1,endTag.length());
	}

	private String getLatexContentOfBrackets(String line) {
		
		int afterBracketCharacterPosition = 1 ;
		
		line = line.substring(line.indexOf("{") + afterBracketCharacterPosition);			
		line = line.substring(0, line.indexOf("}"));
		return line;
	}
	
	public String findLatexTagInLine(String line) {

		String latexTag = "" ;
				
		if(line.equals("")) {
			return "" ;
		}
		
		for(String symbol : StringConstants.SYMBOLS_AFTER_LATEX_TAG) {
			
			if(isLineContainsSymbolRequiedForTag(line, symbol)) {
				
				latexTag = removeLineInformationExceptNameTag(line, symbol);
				if(StringConstants.LATEX_TO_HTML_TAGS_MAP.containsKey(latexTag)) {
					return latexTag ;
				}
			}
		}
		return "" ;
		
	}

	private String removeLineInformationExceptNameTag(String line, String symbol) {
		return line.substring(0,line.indexOf(symbol));
	}

	private boolean isLineContainsSymbolRequiedForTag(String line, String symbol) {
		return line.indexOf(symbol) != -1;
	}
	

}
