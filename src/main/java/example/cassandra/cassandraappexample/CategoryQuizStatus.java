package example.cassandra.cassandraappexample;

public class CategoryQuizStatus {

    private String categoryName;
    private QuizStatus quizStatus;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public QuizStatus getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(QuizStatus quizStatus) {
        this.quizStatus = quizStatus;
    }
}
