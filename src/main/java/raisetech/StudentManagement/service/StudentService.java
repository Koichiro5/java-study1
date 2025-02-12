package raisetech.StudentManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;

import raisetech.StudentManagement.data.StudentsCourses;


import raisetech.StudentManagement.data.StudentsCourses;


import raisetech.StudentManagement.data.StudentsCourses;

import raisetech.StudentManagement.data.StudentCourses;



import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired

  public StudentService(StudentRepository repository){
    this.repository = repository;
  }

  public List<Student> searchStudentList(){

  public StudentService(StudentRepository repository)
  {this.repository = repository;
  }

  public List<Student> searchStusdentList(){

    return repository.search();
  }

  public StudentDetail searchStudent(String id){
    Student student = repository.searchStudent(id);
    List<StudentsCourses> studentsCourses = repository.searchStudentsCourses(student.getId());
    StudentDetail studentDetail = new StudentDetail();
    studentDetail.setStudent(student);
    studentDetail.setStudentCourses(studentsCourses);
    return studentDetail;
  }


  public List<StudentsCourses> searchStudentsCoursesList(){
    return repository.searchCoursesList();


  public List<StudentsCourses> searchStudentsCoursesList(){
    return repository.searchCoursesList();
  }


  public StudentDetail searchStudent(String id){
    Student student = repository.searchStudent(id);
    List<StudentsCourses> studentsCourses = repository.searchStudentsCourses(student.getId());
    StudentDetail studentDetail = new StudentDetail();
    studentDetail.setStudent(student);
    studentDetail.setStudentCourses(studentsCourses);
    return studentDetail;
  }

  public List<StudentsCourses> searchStudentsCoursesList(){
    return repository.searchCoursesList();
  }


  @Transactional
  public void registerStudent(StudentDetail studentDetail){
    repository.registerStudent(studentDetail.getStudent());
    for(StudentsCourses studentsCourses : studentDetail.getStudentCourses()) {
      studentsCourses.setStudentId(studentDetail.getStudent().getId());
      studentsCourses.setCourseStartDate(LocalDateTime.now());
      studentsCourses.setCourseEndDate(LocalDateTime.now().plusYears(1));
      repository.registerStudentCourses(studentsCourses);
    }
  }


  @Transactional
  public void updateStudent(StudentDetail studentDetail){
    repository.updateStudent(studentDetail.getStudent());
    for(StudentsCourses studentsCourses : studentDetail.getStudentCourses()) {
      repository.updateStudentCourses(studentsCourses);
    }


  @Transactional
  public void updateStudent(StudentDetail studentDetail){
    repository.updateStudent(studentDetail.getStudent());
    for(StudentsCourses studentsCourses : studentDetail.getStudentCourses()) {
      repository.updateStudentCourses(studentsCourses);
    }

  }

  @Transactional
  public void registerStudent(StudentDetail studentDetail){
    repository.registerStudent(studentDetail.getStudent());

    for(StudentsCourses studentsCourses : studentDetail.getStudentCourses()) {
      studentsCourses.setStudentId(studentDetail.getStudent().getId());
      studentsCourses.setCourseStartDate(LocalDateTime.now());
      studentsCourses.setCourseEndDate(LocalDateTime.now().plusYears(1));
      repository.registerStudentCourses(studentsCourses);
    }
  }

  @Transactional
  public void updateStudent(StudentDetail studentDetail){
    repository.updateStudent(studentDetail.getStudent());
    for(StudentsCourses studentsCourses : studentDetail.getStudentCourses()) {
      repository.updateStudentsCourses(studentsCourses);
    }



  }
}