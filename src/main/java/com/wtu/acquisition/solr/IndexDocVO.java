package com.wtu.acquisition.solr;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class IndexDocVO implements Serializable{

	private static final long serialVersionUID = -8067408371153775675L;
   private String id;
   private String content;
   private String title;
   private String url;
   private Set<String> label;
   private Integer view;
   private Integer prasie;
   private Integer discuss;
   private String shareurl;
   public String getShareurl() {
	return shareurl;
}
public void setShareurl(String shareurl) {
	this.shareurl = shareurl;
}
public String getId() {
	return id;
}

@Override
public String toString() {
	return "IndexDocVO [id=" + id + ", content=" + content + ", title=" + title + ", url=" + url + ", label=" + label
			+ ", view=" + view + ", prasie=" + prasie + ", discuss=" + discuss + ", shareurl=" + shareurl
			+ ", Extends_Data=" + Extends_Data + "]";
}
public void setId(String id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Set<String> getLabel() {
	return label;
}
public void setLabel(Set<String> label) {
	this.label = label;
}
public Integer getView() {
	return view;
}
public void setView(Integer view) {
	this.view = view;
}
public Integer getPrasie() {
	return prasie;
}
public void setPrasie(Integer prasie) {
	this.prasie = prasie;
}
public Integer getDiscuss() {
	return discuss;
}
public void setDiscuss(Integer discuss) {
	this.discuss = discuss;
}
public HashMap<String, String> getExtends_Data() {
	return Extends_Data;
}
public void setExtends_Data(HashMap<String, String> extends_Data) {
	Extends_Data = extends_Data;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
private HashMap<String,String> Extends_Data;
   
}
