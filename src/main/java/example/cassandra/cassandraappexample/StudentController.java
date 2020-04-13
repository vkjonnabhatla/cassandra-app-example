package example.cassandra.cassandraappexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> fetchAllStudents() throws JsonProcessingException {
        return ResponseEntity.ok(studentService.fetchAllStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.saveStudent(student));
    }
}
