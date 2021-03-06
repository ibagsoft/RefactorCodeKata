package agiledon.codekata.refactoring.elearning.entity;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private List<Training> trainings = new ArrayList<Training>();

    public Trainer(String name) {
        this.name = name;
    }

    public void addTraining(Training training) {
        trainings.add(training);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int points = 0;
        String result = "Subscription Record for " + getName() + "\n";

        for (Training each : trainings) {
            //determine amounts for each line
            double thisAmount = 0;
            switch (each.getCourse().getPriceCode()) {
                case Course.ENTERPRISE:
                    if (each.getTraineeCount() > 15)
                        thisAmount += 2000 * each.getTraineeCount() * 0.9;
                    else thisAmount += 2000 * each.getTraineeCount();
                    break;
                case Course.COMMUNITY:
                    if (each.getTraineeCount() > 15)
                        thisAmount += 1000 * each.getTraineeCount() * 0.8;
                    else thisAmount += 1000 * each.getTraineeCount();
                    break;
                case Course.COMMONWEAL:
                    thisAmount += 100 * each.getTraineeCount();
                    break;
            }
            // add points for enterprise course
            if (each.getCourse().getPriceCode() == Course.ENTERPRISE) {
                points = points + 2;
            } else {
                points++;
            }
            //show figures
            result += "\t" + each.getCourse().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(points) +
                " points";
        return result;
    }
}
