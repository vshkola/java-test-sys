package Unit2.question;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Plain class for  store user information
 */
@XmlType
public class User {
    @XmlElement
    private String login;
  @XmlElement
    private String password;

    public String getLogin() {
        return login;
    }


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }
    public boolean checkPassword(String pass){
        return password.equals(pass);
    }
}
