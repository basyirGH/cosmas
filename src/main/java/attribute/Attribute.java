package attribute;

import java.util.ArrayList;

public class Attribute {

	private ArrayList<String> predefinedAttributes = new ArrayList<String>();
	
	private String attribute1_1 = "Course Name:";
	private String attribute1_2 = "Course Code:";
	private String attribute1_3 = "Course Classification:";
	private String attribute2 = "Synopsis:";
	private String attribute3 = "Name(s) of Academic Staff:";
	private String attribute4 = "Semester and Year offered:";
	private String attribute5 = "Credit Value:";
	private String attribute6 = "Pre-requisite/ co-requisite (if any):";
	private String attribute7 = "Course Learning Outcomes (CLO)";
	private String attribute8 = "Mapping of the Course Learning Outcomes to the Programme Learning Outcomes, Teaching Methods and Assessment Methods";
	private String attribute9 = "Transferable Skills (if applicable)";
	private String attribute10 = "Distribution of Student Learning Time (SLT)";
	private String attribute11 = "Identify special requirement or resources to deliver the course (e.g., software, nursery, computer lab, simulation room etc)";
	private String attribute12 = "References (include required and further readings, and should be the most current)";
	private String attribute13 = "Other additional information (if applicable)";
	
	public ArrayList<String> getPredefinedAttributes() {
		predefinedAttributes.add(attribute1_1);
		predefinedAttributes.add(attribute1_2);
		predefinedAttributes.add(attribute1_3);
		predefinedAttributes.add(attribute2);
		predefinedAttributes.add(attribute3);
		predefinedAttributes.add(attribute4);
		predefinedAttributes.add(attribute5);
		predefinedAttributes.add(attribute6);
		predefinedAttributes.add(attribute7);
		predefinedAttributes.add(attribute8);
		predefinedAttributes.add(attribute9);
		predefinedAttributes.add(attribute10);
		predefinedAttributes.add(attribute11);
		predefinedAttributes.add(attribute12);
		predefinedAttributes.add(attribute13);
		
		return predefinedAttributes;
	}

	public void setPredefinedAttributes(ArrayList<String> predefinedAttributes) {
		this.predefinedAttributes = predefinedAttributes;
	}
	
	
}
