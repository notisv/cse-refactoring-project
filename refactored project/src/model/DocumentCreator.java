package model;

import java.util.HashMap;
import constants.StringConstants;

public class DocumentCreator {
	
	private HashMap<String, Document> documentTemplatesMap;
	
	public DocumentCreator() {
		
		initiDocumentTemplates();
	}

	private void initiDocumentTemplates() {
		documentTemplatesMap = new HashMap<String, Document>();
		
		for(String templateType : StringConstants.TEMPLATE_TYPES) {
			documentTemplatesMap.put(templateType, new Document(templateType));
		}
	}
	
	public Document createDocument(String type) {
		return documentTemplatesMap.get(type).clone();
	}
}
