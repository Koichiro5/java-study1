package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourses {

  private String id;
  private String studentId;
  private String courseName;
  private String courseStartDate;
  private String courseEndDate;
}

