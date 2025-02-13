package assignment1_2;

public class Course {
	private String courseCode;
	private String description;
	private int unit;
	private String day;
	private String time;

	public Course(String courseCode, String description, int unit, String day, String time) {
		this.courseCode = courseCode;
		this.description = description;
		this.unit = unit;
		this.day = day;
		this.time = time;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getDescription() {
		return description;
	}

	public Integer getUnit() {
		return unit;
	}

	public String getDay() {
		return day;
	}

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-20s %-10s %-10s %-15s%n", getCourseCode(), getDescription(), getUnit(), getDay(),
				getTime());
	}
}
