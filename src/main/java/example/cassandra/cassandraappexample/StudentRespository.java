package example.cassandra.cassandraappexample;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends CassandraRepository<Student, Long> {

}
