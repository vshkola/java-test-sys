package Unit2.question;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class UserList {

    private List<User> userList;

    public UserList() {
        this.userList=new ArrayList<User>();
    }

    @XmlElement(name = "user")

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
