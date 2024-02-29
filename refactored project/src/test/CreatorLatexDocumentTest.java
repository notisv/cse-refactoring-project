package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import constants.StringConstants;
import model.Document;
import model.DocumentCreator;

/*
 * Test user story 1
 */

class CreatorLatexDocumentTest {

	@Test
	void test() {
		
		DocumentCreator documentCreator = new DocumentCreator() ;

		shouldCreateEmptyDocument();
		
		for(String typeOfTemplate: StringConstants.TEMPLATE_TYPES) {
			shouldCreateDocumentSpecificType(documentCreator, typeOfTemplate);
		}
	}

	private void shouldCreateEmptyDocument() {
		
		Document document;
		
		document = new Document() ;
		assertEquals(document.getContents(), "");
	}

	private void shouldCreateDocumentSpecificType(DocumentCreator documentCreator, String typeOfTemplate) {
		
		Document document;
		
		document = documentCreator.createDocument(typeOfTemplate) ;
		assertEquals(StringConstants.CONTENTS_OF_TYPE_TEMPLATE.get(typeOfTemplate), document.getContents());
	}

}
