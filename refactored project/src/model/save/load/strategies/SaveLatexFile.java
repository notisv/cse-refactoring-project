package model.save.load.strategies;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import controller.LatexEditorControllerHandler;
import controller.UserInterfaceInformationCollectorHandler;

public class SaveLatexFile extends SaveStrategy{

	@Override
	public void saveFile() {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(UserInterfaceInformationCollectorHandler.USER_INTERFACE_INFORMATION_COLLECTOR.getInstance().getFilename()));
					
			printWriter.write(LatexEditorControllerHandler.LATEX_EDITOR_CONTROLLER.getInstance().getCurrentDocumentContents());
			printWriter.close();
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
