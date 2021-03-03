package in.co.rays.project_3.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * subject JavaDto encapsulates subject attributes
 * @author Mayank mishra
 *
 */

public class SubjectDTO extends BaseDTO {
  private long subjectId;
  private long courseId;
  private String subjectName;
  private String courseName;
  private String description;

  
	public long getSubjectId() {
	return subjectId;
}

public void setSubjectId(long subjectId) {
	this.subjectId = subjectId;
}

public long getCourseId() {
	return courseId;
}

public void setCourseId(long courseId) {
	this.courseId = courseId;
}

public String getSubjectName() {
	return subjectName;
}

public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return subjectName;
	}
 
}
