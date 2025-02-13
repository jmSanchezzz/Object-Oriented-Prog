package assignment1_2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentDA {
	private ArrayList<Student> studentList;
	HashMap<String, ArrayList<Student>> studentPerBlock;

	public StudentDA() {
		studentList = new ArrayList<>();
		studentPerBlock = new HashMap<>();

		try (Scanner reader = new Scanner(Paths.get("studentInfo.csv"))) {
			while (reader.hasNext()) {

				String rowStudent = new String();
				rowStudent = reader.nextLine();
				String[] records = rowStudent.split(",");
				String blockCode = records[0].trim();
				Student student = new Student(Integer.parseInt(records[1].trim()), records[2].trim(),
						records[3].trim());
				addToBlockSection(blockCode, student);
				CourseDA courseDA = new CourseDA(student.getStudentNumber());
				student.setCourseList(courseDA.getCourseList());
				studentList.add(student);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addToBlockSection(String blockCode, Student student) {
		if (studentPerBlock.containsKey(blockCode)) {
			studentPerBlock.get(blockCode).add(student);
		} else {
			ArrayList<Student> studentGroup = new ArrayList<>();
			studentGroup.add(student);
			studentPerBlock.put(blockCode, studentGroup);
		}
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public ArrayList<Student> getStudentsByBlock(String blockCode) {
		return studentPerBlock.getOrDefault(blockCode, new ArrayList<>());
	}

	public void addCourseList() {
		for (Student student : studentList) {
			CourseDA courseDA = new CourseDA(student.getStudentNumber());
			student.setCourseList(courseDA.getCourseList());
		}
	}
}
