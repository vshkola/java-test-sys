package Unit2.question.Parser;

import Unit2.question.QuestionList;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladislav
 *
 */
public class QuestionParserFromXmlTest {
    @Test
    public void testGetQuestionList() throws Exception {
        QuestionList questionList;
        QuestionParserFromXml questionParserFromXml = new QuestionParserFromXml("D:\\java\\zhuchenko\\Unit2\\files\\Question2.xml");
        questionList = questionParserFromXml.getQuestionList();
        int i=5;
        assert(true);
    }
}
