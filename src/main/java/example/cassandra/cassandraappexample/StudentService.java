package example.cassandra.cassandraappexample;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.CodecRegistry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.ClusterBuilderConfigurer;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private Cluster cluster;

    private String string = "[{\"Men\" : {\"quiz_completed\": true, \"quiz_tutorial\": true, \"quiz_skipped\": false }},{\"Women\" : {\"quiz_completed\": true,\"quiz_tutorial\": true,\"quiz_skipped\": false }}]";

    public List<Student> fetchAllStudents() throws JsonProcessingException {
        //CodecRegistry codecRegistry = cluster.getConfiguration().getCodecRegistry();
        //codecRegistry.register();
        List<Student> students = studentRespository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, QuizStatus> quizStatusMap = mapper.readValue(students.get(0).getCourseQuizStatus(), new TypeReference<Map<String, QuizStatus>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        System.out.println(quizStatusMap);
        QuizStatus quizStatus = quizStatusMap.get("Men");
        if(quizStatus.getQuizCompleted()){
            System.out.println("Quiz status "+ quizStatus.getQuizCompleted());
        }
        quizStatus.setQuizCompleted(true);
        quizStatus.setQuizSkipped(false);
        quizStatus.setQuizTutorial(false);


        LinkedHashMap<String, QuizStatus> quiz = new LinkedHashMap<>();
        quiz.put("Women", quizStatus);
        quizStatusMap.remove("Women");
        quiz.putAll(quizStatusMap);

        //quizStatusMap.put("Furniture", quizStatus);
        students.get(0).setCourseQuizStatus(mapper.writeValueAsString(quiz));
        studentRespository.save(students.get(0));
        return students;
    }

    public Student saveStudent(Student student){
        return studentRespository.save(student);
    }
}
