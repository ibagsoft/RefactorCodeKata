package agiledon.codekata.refactoring.elearning.entity;

public class Training {
    private Course course;
    private int traineeCount;

    public Training(Course course, int traineeCount) {
        this.course = course;
        this.traineeCount = traineeCount;
    }

    public Course getCourse() {
        return course;
    }

    public int getTraineeCount() {
        return traineeCount;
    }
}
