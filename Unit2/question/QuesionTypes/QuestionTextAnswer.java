package Unit2.question.QuesionTypes;

import java.util.ArrayList;

/**
 * User must input an answer in written form below the question
 *
 * @version 1.0.1 12/11/13
 */
public class QuestionTextAnswer extends Question{

    //private final int type = 2;
    public QuestionTextAnswer(){};
    public QuestionTextAnswer(String questionText, ArrayList<Variant> variantList, int points) {
            super(questionText, variantList, points);
        }

        public String toString() {

            return String.format("\n%s\n%s\n","Theme: "+this.getTheme()+" Level: "+this.getLevel(), questionText);
        }

        public boolean check(String[] input) {
            String correctAnswer = getCorrectAnswer();

            return correctAnswer.equalsIgnoreCase(input[0]);
        }

        private String getCorrectAnswer() {
            return variantsList.get(0).getVariantText();
        }

        public boolean validateAnswer(String[] received) {
            return (received.length != 0);
        }

}
