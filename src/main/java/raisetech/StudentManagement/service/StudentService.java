package raisetech.StudentManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList(){
    //検索処理
    return repository.search()
        .stream()
        .filter(student -> student.getAge() >= 30)
        .collect(Collectors.toList());
    //絞り込みをする。年齢が30代の人のみを抽出する。
    //抽出したリストをコントローラーに返す。

  }


  public List<StudentCourses> searchStudentsCoursesList(){
    //絞り込み検索で「Javaコース」のコース情報のみを抽出する。
    //抽出したリストをコントローラーに返す。
    return repository.searchCourses()
        .stream()
        .filter(studentCourses -> "Java".equals(studentCourses.getCourseName()))
        .collect(Collectors.toList());
  }
}
