package model.version.strategies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Document;

public class StableVersionsStrategy implements VersionsStrategy{
	
	private String versionID = "";
	
	@Override
	public void putVersionID(Document document) {
		
		String filename = document.getVersionID() + ".tex";
		writeDocumentToFile(document, filename);
		
		versionID = document.getVersionID();
	}
	
	public void writeDocumentToFile(Document document, String filename) {
		try {
			
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(filename));
			
			printWriter.write(document.getContents());
			printWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Document getDocumentOfLastVersion() {
		
		if(!isExistVersionID()) {
			return null;
		}
		
		Document document = creaetDocumentWithContentsOfVersion(Integer.parseInt(versionID));
		return document;
	}

	private boolean isExistVersionID() {
		return !versionID.equals("");
	}


	@Override
	public void setEntireHistory(List<Document> documents) {
		
		for(int i = 0; i < documents.size(); i++) {
			Document doc = documents.get(i);
			writeDocumentToFile(doc,doc.getVersionID() +".tex");
		}
		
		if(documents.size() > 0) {
			versionID = documents.get(documents.size()-1).getVersionID();
		}
		else {
			versionID = "";
		}
	}

	@Override
	public List<Document> getEntireHistory() {

		List<Document> documents = new ArrayList<Document>();
		
		if(!isExistVersionID()) {
			return documents;
		}
		
		int lastVersion = Integer.parseInt(versionID);
		for(int version = 0; version <= lastVersion; version++) {
			
			Document document = creaetDocumentWithContentsOfVersion(version);
			documents.add(document);
		}
		
		return documents;
	}

	private Document creaetDocumentWithContentsOfVersion(int versionOfDocument) {
		
		String fileContents = readContentsFromLatexFile(String.valueOf(versionOfDocument));
		
		Document document = new Document();
		document.setContents(fileContents);
		
		return document;
	}
	
	
	private String readContentsFromLatexFile(String versionID) {
		
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(versionID + ".tex"));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileContents;
		
	}

	public void removeVersion() {
		
		int lastVersion = Integer.parseInt(versionID);
		
		if(lastVersion == 0) {
			versionID = "";
		}
		else {
			versionID = (lastVersion-1) + "";
		}
	}
}
