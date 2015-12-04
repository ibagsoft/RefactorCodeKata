package agiledon.codekata.refactoring.elearning.entity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrainerTest {
    @Test
    public void should_report_enterprise_amount_below_or_equals_15_trainee() {
        //given
        Trainer trainer = prepare_enterprise_training(15);

        //when
        String report = trainer.statement();

        //then
        assertThat(report, is("Subscription Record for Jobs Jiang\n\tdesign Patterns\t30000.0\nAmount owed is 30000.0\nYou earned 2 points"));
    }

    @Test
    public void should_report_enterprise_amount_above_15_trainee() {
        //given
        Trainer trainer = prepare_enterprise_training(16);

        //when
        String report = trainer.statement();

        //then
        assertThat(report, is("Subscription Record for Jobs Jiang\n\tdesign Patterns\t28800.0\nAmount owed is 28800.0\nYou earned 2 points"));
    }

    private Trainer prepare_enterprise_training(int traineeCount) {
        Trainer trainer = new Trainer("Jobs Jiang");
        Course course = new Course("design Patterns", 0);
        Training training = new Training(course, traineeCount);
        trainer.addTraining(training);
        return trainer;
    }

}