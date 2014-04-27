package Unit2.question.Parser;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * Created with IntelliJ IDEA.
 *
 */
public class LogParser {
    public static final String PATH = "src/Unit2/files/log.xml";
    public LogParser() {
        createLogFile();
    }
    private void createLogFile() {
        File file = new File(PATH);
        if (!file.exists()) {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("Errors");
                doc.appendChild(rootElement);
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(PATH));
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                transformer.transform(source, result);
            }  catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            }
            catch (javax.xml.transform.TransformerException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveError(Exception exception) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(PATH);
            Element rootElement = doc.getDocumentElement();
            Element error = doc.createElement("error");
            rootElement.appendChild(error);

            Element date = doc.createElement("date");
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            date.appendChild(doc.createTextNode(dateFormat.format(currentDate)));
            error.appendChild(date);

            Element classElement = doc.createElement("class");
            classElement.appendChild(doc.createTextNode(exception.getStackTrace()[4].getClassName()));
            error.appendChild(classElement);

            Element methodElement = doc.createElement("method");
            methodElement.appendChild(doc.createTextNode(exception.getStackTrace()[4].getMethodName()));
            error.appendChild(methodElement);

            Element lineElement = doc.createElement("line");
            lineElement.appendChild(doc.createTextNode(Integer.toString(exception.getStackTrace()[4].getLineNumber())));
            error.appendChild(lineElement);

            Element textElement = doc.createElement("text");
            textElement.appendChild(doc.createTextNode(exception.toString()));
            error.appendChild(textElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(PATH));
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
             transformer.transform(source, result);
        }catch (javax.xml.transform.TransformerException e) {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
