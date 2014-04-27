package Unit2.question;

import Unit2.question.QuesionTypes.*;


import java.util.Collections;
import java.util.LinkedList;

/**
 * Array of questions
 *
 * @version 1.2.1 12/11/13
 */
public class QuestionList{

    private LinkedList<Question> questionList;

    /**
     * This constructor is used for creating empty list of questions
     */
    public QuestionList() {
        questionList = new LinkedList<Question>();
    }
     public Question getQuestion(int index){
         return questionList.get(index);
     }
    public void add(Question v) {
        questionList.add(v);
    }
    public boolean validateAnswer(int index, String[] answer) {
        Question currentQuestion = questionList.get(index);
        return currentQuestion.validateAnswer(answer);
    }

    public void show(int index) {
        System.out.print(questionList.get(index).toString());
    }

    public boolean check(int index, String[] answer) {
        return questionList.get(index).check(answer);
    }

    public int getPoints(int index) {
        return questionList.get(index).getPoints();
    }

    public void shuffle() {
        Collections.shuffle(questionList);
    }


    public int length() {
        return questionList.size();
    }
}
