package assignment1_2;

import java.util.ArrayList;

public class Student {
	private int studentNumber;
	private String name;
	private String program;
	private ArrayList<Course> courseList;
	private int totalUnits;

	public Student(int studentNumber, String name, String program) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.program = program;
		courseList = new ArrayList<>();
		totalUnits = 0;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public String getName() {
		return name;
	}

	public String getProgram() {
		return program;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public int getTotalUnits() {
		for (Course course : courseList) {
			totalUnits += course.getUnit();
		}
		return totalUnits;
	}

	@Override

	public String toString() {
		StringBuilder output = new StringBuilder();

		// Student Details
		output.append("Student number: ").append(getStudentNumber()).append("\n");
		output.append("Student name: ").append(getName()).append("\n");
		output.append("Program: ").append(getProgram()).append("\n");
		output.append("Total units enrolled: ").append(getTotalUnits()).append("\n\n");

		// Table Header
		output.append(
				String.format("%-12s %-25s %-6s %-12s %-15s\n", "Course Code", "Description", "Unit", "Day", "Time"));
		output.append("-----------------------------------------------------------------------\n");
		// Course Details
		if (getCourseList().isEmpty()) {
			output.append("No courses enrolled.\n");
		} else {
			for (Course course : getCourseList()) {
				output.append(String.format("%-12s %-25s %-6d %-12s %-15s\n", course.getCourseCode(),
						course.getDescription(), course.getUnit(), course.getDay(), course.getTime()));
			}
		}
		output.append("-----------------------------------------------------------------------\n\n");
		; // Add space between students

		return output.toString();
	}
}
