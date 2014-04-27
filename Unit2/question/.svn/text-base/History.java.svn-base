package Unit2.question;

import Unit2.question.Parser.LogParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@XmlRootElement
public class History implements Serializable {
    @XmlElement
    private String historyFileName;
    @XmlElement
    private List<State> history;
    private Map<String, Integer> skills;
    private List <Rating>ratingList;

    public List<Rating> getRatingList() {
        return ratingList;
    }
    @XmlElement
    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    @XmlElement
    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    public History(){}
    public History(String historyFileName) {
        this.historyFileName = historyFileName;
        this.history = new ArrayList<State>();
        this.skills = new HashMap<String, Integer>();
        this.ratingList=new ArrayList<Rating>();
    }

    public State getHistoryRecord(int index) {
        return this.history.get(index);
    }

    public void addHistoryRecord(State element) {
        history.add(element);

    }

    public void removeHistoryRecord(int index) {
        history.remove(index);

    }


    public int size() {
        return history.size();
    }


    public Object load() {
        try {
            File file = new File(historyFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(History.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            History temphistory = (History) jaxbUnmarshaller.unmarshal(file);
            if (temphistory.history == null){temphistory.history = new ArrayList<State>();}
            return temphistory;
        } catch (Exception e) {
            LogParser logParser = new LogParser();
            logParser.saveError(e);

            return  new History(historyFileName);
        }
    }

    public void save(Object history) {
        try {
            File file = new File(historyFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(History.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            if (history==null){history=new ArrayList<State>();}
            jaxbMarshaller.marshal(history, file);
        } catch (Exception e) {
            LogParser logParser = new LogParser();
            logParser.saveError(e);
        }
    }

    public void clear() {

        history.removeAll(history);

    }

}


