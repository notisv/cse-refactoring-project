package model.save.load.strategies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorHandler;

public class LoadLatexFile extends LoadStrategy{

	@Override
	public void loadFile() {
		
		String fileContents = "";
		
		try {
			Scanner scanner = new Scanner(new FileInputStream(UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getFilename()));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().setCurrentDocumentContents(fileContents);
		
		setTypeOfTemplate(fileContents);
		
	}
}
