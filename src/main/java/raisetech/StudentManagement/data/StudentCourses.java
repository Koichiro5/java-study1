package raisetech.StudentManagement.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourses {

  private String id;
  private String studentId;
  private String courseName;
  private LocalDateTime courseStartDate;
  private LocalDateTime courseEndDate;
}
