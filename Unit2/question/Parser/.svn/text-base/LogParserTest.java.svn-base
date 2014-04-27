package Unit2.question.Parser;

import org.junit.Test;

import java.io.File;


public class LogParserTest {
    @Test
    public void testSaveError()  {
        try {
            File wrt = new File("fileNotExist.Boom");
            String s = wrt.getName();
        }   catch (Exception e) {
            LogParser logParser = new LogParser();
            logParser.saveError(e);
        }
    }
}
