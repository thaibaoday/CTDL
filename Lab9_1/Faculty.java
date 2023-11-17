package Lab9_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course maxCourse = null;
		int maxStudents = 0;
		for (Course course : courses) {
			if (course.getType().equals("thực hành") && course.students.size() > maxStudents) {
				maxStudents = course.students.size();
				maxCourse = course;
			}
		}
		return maxCourse;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> studentsByYear = new HashMap<>();
		for (Course course : courses) {
			for (Student student : course.students) {
				if (!studentsByYear.containsKey(student.getYear())) {
					studentsByYear.put(student.getYear(), new ArrayList<>());
				}
				studentsByYear.get(student.getYear()).add(student);
			}
		}
		return studentsByYear;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> filteredCourses = new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				return c2.students.size() - c1.students.size();
			}
		});
		for (Course course : courses) {
			if (course.getType().equals(type)) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

}
