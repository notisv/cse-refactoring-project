package model;

import constants.StringConstants;

public class Document {
	
	private String author;
	private String dateLastModified;
	private String copyright;
	private String versionID = "0";
	private String contents;
	
	public Document(String author, String date, String copyright, String versionID, String contents) {
		this.author = author;
		this.dateLastModified = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
	}

	public Document() {
		this.contents = "";
	}

	public Document(String templateType) {
		this.contents = StringConstants.CONTENTS_OF_TYPE_TEMPLATE.get(templateType) ;
	}

	public Document clone() {
		return new Document(author, dateLastModified, copyright, versionID, contents);
	}
	
	public void setNextVersionID() {
		int currentVersionID = Integer.parseInt(versionID);
		versionID = (currentVersionID + 1) + "";
	}
	
	public String getVersionID() {
		return versionID;
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
