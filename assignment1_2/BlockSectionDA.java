package assignment1_2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class BlockSectionDA {
	private ArrayList<BlockSection> sections;

	public BlockSectionDA() {
		sections = new ArrayList<>();
		try (Scanner reader = new Scanner(Paths.get("blockSectionInfo.csv"))) {
			while (reader.hasNextLine()) {
				String rowBlockSection = reader.nextLine();
				String[] records = rowBlockSection.split(",");
				createBlockSection(records[0].trim(), records[1].trim(), records[2].trim());
				addStudentsToBlock();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createBlockSection(String blockCode, String description, String adviser) {
		for (BlockSection block : sections) {
			if (block.getBlockCode().equals(blockCode)) {
				return; // Prevent duplicates
			}
		}
		BlockSection blockSection = new BlockSection(blockCode, description, adviser);
		sections.add(blockSection);
	}

	public void addStudentsToBlock() {
		StudentDA studentDA = new StudentDA();
		for (BlockSection block : sections) {
			block.setStudentList(studentDA.getStudentsByBlock(block.getBlockCode()));
		}
	}

	public ArrayList<BlockSection> getSections() {
		return sections;
	}
}
