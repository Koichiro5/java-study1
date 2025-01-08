package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourse;

/**
 * 受講生テーブルと受講生コース情報テーブルと紐づくRepositoryです。
 */
@Mapper
public interface StudentRepository {
  /**
   * 受講生の全件検索を行います。
   * @return　受講生一覧（全件）
   */
  @Select("SELECT * FROM students")
  List<Student> search();
  /**
   * 受講生の検索を行います。
   * @param id　受講生ID
   * @return　受講生
   */
  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);
  /**
   * 受講生のコース情報の全件検索を行います。
   * @return　受講生のコース情報（全件）
   */
  @Select("SELECT * FROM students_courses")
  List<StudentsCourse> searchStudentsCoursesList();
  /**
   * 受講生IDに紐づく受講生コース情報を検索します。
   * @param studentId　受講生ID
   * @return　受講生IDに紐づく受講生コース情報
   */
  @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
  List<StudentsCourse> searchStudentsCourses(String studentId);
  /**
   * 受講生を新規登録します。IDに関しては自動採番を行う。
   * @param student　受講生
   */
  @Insert("INSERT INTO students(name, furigana, nickname, email, region, age, gender, remark, is_Deleted) "
      + "VALUES (#{name}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true,keyProperty = "id")
  void registerStudent(Student student);
  /**
   * 受講生コース情報を新規登録します。IDに関しては自動採番を行う。
   * @param studentCourses　受講生コース情報
   */
  @Insert("INSERT INTO students_courses(student_id, course_name, course_start_date, course_end_date) "
    + "VALUES(#{studentId}, #{courseName}, #{courseStartDate}, #{courseEndDate})")
  @Options(useGeneratedKeys = true,keyProperty = "id")
  void registerStudentCourses(StudentsCourse studentCourses);

  @Update("UPDATE students SET name = #{name}, furigana = #{furigana}, nickname = #{nickname}, "
      + "email = #{email}, region = #{region}, age = #{age}, gender = #{gender}, "
      + "remark = #{remark}, is_Deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET course_name = #{courseName} WHERE id = #{id}")
  void updateStudentsCourses(StudentsCourse studentCourses);
}
