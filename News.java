package MainPackage;

import java.util.Objects;

public class News {
	String title;
	String content;
	
	public News(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(content, other.content) && Objects.equals(title, other.title);
	}
	
	
	
}

