package model;

public class Newspaper {

	private int id;
	private String title;
	private String content;

	public Newspaper(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Newspaper(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Newspaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		return "id: " + id + " title: " + title + " content: " + content;
	}

}
