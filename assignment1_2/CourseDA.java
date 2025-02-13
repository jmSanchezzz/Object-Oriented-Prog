package assignment1_2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDA {
	private ArrayList<Course> courseList;

	public CourseDA(int studentNumber) {
		courseList = new ArrayList<>();
		try (Scanner reader = new Scanner(Paths.get("scheduleInfo.csv"))) {
			while (reader.hasNext()) {
				String rowCourse = new String();
				rowCourse = reader.nextLine();

				String[] records = rowCourse.split(",");

				if (String.valueOf(studentNumber).equals((records[0]))) {
					Course course = new Course(records[1].trim(), records[2].trim(),
							Integer.parseInt(records[3].trim()), records[4].trim(), records[5].trim());
					courseList.add(course);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}
}
