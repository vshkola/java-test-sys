package Unit2.WebService;

import Unit2.question.Parser.LogParser;
import Unit2.question.User;
import Unit2.question.UserList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.*;
import javax.xml.ws.Endpoint;
import java.io.File;

@WebService (serviceName = "TestWebService")
public class TestServer implements TestServerInterface {
    public String userDatabase="src/Unit2/files/users.xml";
    @WebMethod
    public boolean checkLogin(String login) throws JAXBException {
        UserList users = (UserList)load();
        for (int i = 0; i <users.getUserList().size() ; i++) {
            if(users.getUserList().get(i).getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    @WebMethod
    public boolean checkUser(String login, String password) throws JAXBException {
        UserList users = (UserList)load();
        System.out.println("loaded");
        for (int i = 0; i <users.getUserList().size() ; i++) {
            System.out.println(users.getUserList().get(i).getLogin());
            if(users.getUserList().get(i).getLogin().equals(login)&&users.getUserList().get(i).checkPassword(password)){
                return true;
            }
        }
        return false;
    }
    @WebMethod
    public void addUserToDatabase(String login,String password) throws JAXBException {
        User tempUser = new User(login, password);
        UserList userList=(UserList)load();
        userList.getUserList().add(tempUser);
        save(userList);

    }

    public Object load() throws JAXBException {

            File file = new File(userDatabase);
            JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            UserList tempUsers = (UserList) jaxbUnmarshaller.unmarshal(file);
            return tempUsers;

    }
    public void save(Object userList) throws JAXBException {

            File file = new File(userDatabase);

            JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            if (userList==null){userList=new UserList();}
            jaxbMarshaller.marshal(userList, file);

    }
    public static void main(String[] args)throws Exception{
        Endpoint.publish("http://localhost:5557/", new TestServer());

        System.in.read();
    }

}
