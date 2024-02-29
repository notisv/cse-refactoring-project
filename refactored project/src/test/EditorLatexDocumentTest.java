package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import constants.StringConstants;
import model.Document;
import model.DocumentCreator;

/*
 * Test user story 2
 */

class EditorLatexDocumentTest {
	
	DocumentCreator documentCreator = new DocumentCreator(); 
	Document document = null ;
	
	@Test
	void test() {
		
		for(String typeOfTemplate : StringConstants.LATEX_TEMPLATE_TO_EDITED_CONTENT_MAP.keySet()) {
			shouldEditFileContent(typeOfTemplate, "begin", "KEYWORD", StringConstants.LATEX_TEMPLATE_TO_EDITED_CONTENT_MAP.get(typeOfTemplate));
		}
	}
	
	public void shouldEditFileContent(String typeOfTemplate, String initialWord, String finalWord ,String expectedEesult) {
		
		document = documentCreator.createDocument(typeOfTemplate) ;
		
		String newContents = document.getContents().replaceAll(initialWord, finalWord) ;
		document.setContents(newContents);
			
		assertEquals(expectedEesult, document.getContents());
	}

}
