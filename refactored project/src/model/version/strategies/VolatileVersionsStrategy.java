package model.version.strategies;

import java.util.ArrayList;
import java.util.List;

import model.Document;

public class VolatileVersionsStrategy implements VersionsStrategy {
	
	private ArrayList<Document> history;
	
	public VolatileVersionsStrategy() {
		history = new ArrayList<Document>();
	}

	@Override
	public void putVersionID(Document document) {
		history.add(document.clone());
	}

	@Override
	public Document getDocumentOfLastVersion() {
		if(isHistoryEmpty()) {
			return null;
		}
		
		return history.get(lastVersionInHistory());
	}

	private boolean isHistoryEmpty() {
		return history.size() == 0;
	}

	private int lastVersionInHistory() {
		return history.size() - 1;
	}

	@Override
	public void setEntireHistory(List<Document> documents) {
		history.clear();
		history.addAll(documents);
	}

	@Override
	public List<Document> getEntireHistory() {
		return history;
	}

	@Override
	public void removeVersion() {
		history.remove(lastVersionInHistory());
	}

}
