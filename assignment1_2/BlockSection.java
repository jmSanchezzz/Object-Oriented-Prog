package assignment1_2;

import java.util.ArrayList;

public class BlockSection {
	private String blockCode;
	private String description;
	private String adviser;
	private ArrayList<Student> studentList;
	private int totalStudents;

	public BlockSection(String blockCode, String description, String adviser) {
		this.blockCode = blockCode;
		this.description = description;
		this.adviser = adviser;
		studentList = new ArrayList<>();
		totalStudents = 0;
	}

	public String getBlockCode() {
		return blockCode;
	}

	public String getDescription() {
		return description;
	}

	public String getAdviser() {
		return adviser;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public String toString() {
		totalStudents = studentList.size();
		StringBuilder output = new StringBuilder();

		output.append("=======================================================================\n");
		output.append("Block Section: ").append(getBlockCode()).append("\n");
		output.append("Block Section Description: ").append(getDescription()).append("\n");
		output.append("Class Adviser: ").append(getAdviser()).append("\n\n");
		output.append("Total Students: ").append(totalStudents).append("\n");
		output.append("=======================================================================\n\n");

		return output.toString();
	}
}