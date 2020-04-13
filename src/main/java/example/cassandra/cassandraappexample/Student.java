package example.cassandra.cassandraappexample;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table("student_json")
public class Student implements Serializable {

    @PrimaryKey
    private Long id;
    private String name;
    @Column("email")
    private Set<String> emails;
    @Column("joining_date")
    private Date joiningDate;
    @Column("phone_number")
    private List<String> phoneNumbers;

    @Column("quiz_status")
    private String courseQuizStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getCourseQuizStatus() {
        return courseQuizStatus;
    }

    public void setCourseQuizStatus(String courseQuizStatus) {
        this.courseQuizStatus = courseQuizStatus;
    }
}
