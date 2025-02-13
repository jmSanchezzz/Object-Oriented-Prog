package assignment1_2;



public class COMReportVersion2 {

	public static void main(String[] args) {
		 String output = "";
		 BlockSectionDA blockSection = new BlockSectionDA();
	      for (BlockSection section : blockSection.getSections()) {
	            output += section.toString();
	            for (Student student : section.getStudentList()) {
	                output += student.toString();
	            }
	        }
	        System.out.println(output);
	       
		
	}

}
