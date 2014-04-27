package Unit2.WebService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

@WebService
public interface TestServerInterface {
    @WebMethod
    public boolean checkLogin(String login) throws JAXBException;
    @WebMethod
    public boolean checkUser(String login,String password) throws JAXBException;
    @WebMethod
    public void addUserToDatabase(String login,String password) throws JAXBException;
}
