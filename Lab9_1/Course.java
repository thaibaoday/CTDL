package Lab9_1;

import java.util.List;

public class Course {
	private String id;
	private String title;
	private String type;
	private String lectuer;
	List<Student> students;

	public Course(String id, String title, String type, String lectuer, List<Student> students) {
		super();
		this.id = id;
		this.title = title;
		this.setType(type);
		this.lectuer = lectuer;
		this.students = students;
	}

	public Object getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
