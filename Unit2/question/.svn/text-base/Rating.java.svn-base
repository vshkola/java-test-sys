package Unit2.question;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
 @XmlType
public class Rating implements Serializable {
    @XmlElement
    private Date date;
     @XmlElement
    private int points;
     @XmlElement
    private int performAnswers;

    public Rating(){};

    public Rating( Date date, int points, int performAnswers) {
        this.date=date;
        this.points = points;
        this.performAnswers = performAnswers;
    }
    public String toString(){
        return "Тестирование от "+date+ "\n"+points+" баллов "+"\n"+"Отвечено на "+performAnswers+" вопросов.";
    }
}
