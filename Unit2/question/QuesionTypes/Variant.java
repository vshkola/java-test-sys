package Unit2.question.QuesionTypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Class contains text of variant and it`s correctness
 *
 * @version 1.0.3 21/10/13
 */
@XmlType
public  class Variant implements Serializable {
    @XmlElement
    private String answerText;
    @XmlElement
    private  boolean correct;
    public Variant (){}
    public Variant(String text, boolean correct){
        this.answerText = text;
        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getVariantText() {
        return answerText;
    }
}
