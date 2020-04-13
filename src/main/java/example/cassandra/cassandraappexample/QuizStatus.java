package example.cassandra.cassandraappexample;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class QuizStatus implements Serializable {

    @JsonProperty("quiz_completed")
    private Boolean quizCompleted;
    @JsonProperty("quiz_tutorial")
    private Boolean quizTutorial;
    @JsonProperty("quiz_skipped")
    private Boolean quizSkipped;

    public Boolean getQuizCompleted() {
        return quizCompleted;
    }

    public void setQuizCompleted(Boolean quizCompleted) {
        this.quizCompleted = quizCompleted;
    }

    public Boolean getQuizTutorial() {
        return quizTutorial;
    }

    public void setQuizTutorial(Boolean quizTutorial) {
        this.quizTutorial = quizTutorial;
    }

    public Boolean getQuizSkipped() {
        return quizSkipped;
    }

    public void setQuizSkipped(Boolean quizSkipped) {
        this.quizSkipped = quizSkipped;
    }
}
