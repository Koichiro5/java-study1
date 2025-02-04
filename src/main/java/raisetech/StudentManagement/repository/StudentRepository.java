package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;

import raisetech.StudentManagement.data.StudentsCourses;


import raisetech.StudentManagement.data.StudentsCourses;


import raisetech.StudentManagement.data.StudentsCourses;

import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;




@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students WHERE is_Deleted = false")
  List<Student> search();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchCoursesList();

  @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
  List<StudentsCourses> searchStudentsCourses(String studentId);

  @Insert("INSERT INTO students(name, furigana, nickname, email, region, age, gender, remark, is_Deleted) "
      + "VALUES (#{name}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true,keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(student_id, course_name, course_start_date, course_end_date) "
    + "VALUES(#{studentId}, #{courseName}, #{courseStartDate}, #{courseEndDate})")
  @Options(useGeneratedKeys = true,keyProperty = "id")
  void registerStudentCourses(StudentsCourses studentCourses);

  @Update("UPDATE students SET name = #{name}, furigana = #{furigana}, nickname = #{nickname}, "
      + "email = #{email}, region = #{region}, age = #{age}, gender = #{gender}, "
      + "remark = #{remark}, is_Deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET course_name = #{courseName} WHERE id = #{id}")

  void updateStudentsCourses(StudentsCourses studentCourses);

  void updateStudentCourses(StudentsCourses studentCourses);


  @Insert("INSERT INTO students(name, furigana, nickname, email, region, age, gender, remark, is_Deleted) "
      + "VALUES (#{name}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true,keyProperty = "id")
  void registerStudent(Student student);




}
