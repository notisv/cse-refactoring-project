package model.version.strategies;

import java.util.List;

import model.Document;

public interface VersionsStrategy {
	
	public void putVersionID(Document document);
	public void removeVersion();
	public void setEntireHistory(List<Document> documents);

	public List<Document> getEntireHistory();
	public Document getDocumentOfLastVersion();
	
}
