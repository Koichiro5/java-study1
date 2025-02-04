package raisetech.StudentManagement;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@SpringBootApplication
public class Application {

	@Autowired
	private StudentRepository repository;

	private Map<String,String>student;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@GetMapping("/studentList")
	public List<Student> getStudentList(){
		return repository.search();
	}

	@GetMapping("/studentsCourses")
	public List<StudentCourses> getStudentsCoursesList(){
		return repository.searchCourses();
	}
}

