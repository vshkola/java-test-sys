package Unit2.controller;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Unit2.WebService.TestServerInterface;
import Unit2.question.Parser.LogParser;
import Unit2.question.User;
import Unit2.question.UserList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Scanner;

/**
 *
 */
public class Authentification {
    private User user;
    private String RESULTS_FOLDER;
    private String USER_DATABASE_FILENAME;
    private String RESULT_EXTENSION;
   // public static TestServerInterface testService = new ClassPathXmlApplicationContext("Unit2/WebService/WebConf.xml").getBean("TestWebService", TestServerInterface.class);

    public Authentification(String RESULTS_FOLDER,String USER_DATABASE_FILENAME, String RESULT_EXTENSION) {
        this.RESULTS_FOLDER = RESULTS_FOLDER;
        this.USER_DATABASE_FILENAME=USER_DATABASE_FILENAME;
        this.RESULT_EXTENSION = RESULT_EXTENSION;
    }

    public Authentification() {
        this.RESULTS_FOLDER = "C:\\Test_files";
        this.USER_DATABASE_FILENAME="C:\\Test_files/users.xml";
        this.RESULT_EXTENSION = "xml";
    }

    /**
     * Console menu for user operations
     */

    public User userMenu() throws JAXBException {
        int menuLenght = 3;
        System.out.println("1. Autorization");
        System.out.println("2. Registration");
        System.out.println("3. Exit");
        int choice = getMenuChoice(menuLenght);
        switch (choice) {
            case 1:
                Authorization();
                return user;

            case 2:
                Registration();

                return user;

            case 3:
                System.exit(0);
        }

        return user;
    }

    public String readKeyb() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    /**
     * Autorized existent user
     *
     * @throws java.io.IOException
     */
    public void Authorization() throws JAXBException {

        int tryCounter = 0;   //Потенциально можно ограничить количество попыток авторизации
        String tempLogin = "";
        String tempPassword = "";
        while (!checkUser(tempLogin, tempPassword)) {
            if (tryCounter != 0) {
                System.out.println("Authorization failed. Try again.");
            }
            System.out.println("Login: ");
            tempLogin = readKeyb();
            System.out.println("Password: ");
            tempPassword = readKeyb();
            tryCounter++;
        }


        user = new User(tempLogin, tempPassword);

        System.out.println("Authorization successful!");


    }

    /**
     * Registered new user
     */
    public String Registration() throws JAXBException {

        String tempLogin = "";
        String tempPassword = "";
        System.out.println("New login: ");
        tempLogin = readKeyb();
        while (checkLogin(tempLogin)) {
            System.out.println("Login already exist. Try again.");
            System.out.println("New login: ");
            tempLogin = readKeyb();
        }
        System.out.println("Please, enter new password: ");
        tempPassword = readKeyb();
        User tempUser = new User(tempLogin,tempPassword);
        UserList userList=(UserList)load();
        userList.getUserList().add(tempUser);
        save(userList);

        this.user = new User(tempLogin,tempPassword);
        createResultFile(RESULTS_FOLDER + tempLogin + RESULT_EXTENSION);


        System.out.println("Registration successful!");

        return user.getLogin();
    }

    /**
     * Return TRUE if login exist in user database
     */
    public boolean checkLogin(String login) {

        UserList users = (UserList)load();
        for (int i = 0; i <users.getUserList().size() ; i++) {
            if(users.getUserList().get(i).getLogin().equals(login)){
                return true;
            }
        }

        return false;
    }

    /**
     * Return TRUE if pair (login+password) exist in user database
     */

    public boolean checkUser(String login, String password) {
       UserList users = (UserList)load();
        for (int i = 0; i <users.getUserList().size() ; i++) {
            if(users.getUserList().get(i).getLogin().equals(login)&&users.getUserList().get(i).checkPassword(password)){
                return true;
            }
        }

        return false;
    }

    /**
     * Return entered from keyboard integer value ( range between 0 and maximum )
     */
    public static int getMenuChoice(int maximum) {
        int choice = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Choice: ");
        while (choice > maximum || choice <= 0) {
            while (!in.hasNextInt()) {
                System.out.println("Your choice " + in.next() + " invalid, try again");
            }

            choice = in.nextInt();

            if (choice > maximum || choice <= 0) {
                System.out.println("invalid choice, try again");
            }


        }
        return choice;

    }

    public void createResultFile(String historyFileName) {
        File file = new File(historyFileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            LogParser logParser = new LogParser();
            logParser.saveError(e);
        }
    }
    public Object load() {
        try {
            File file = new File(USER_DATABASE_FILENAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            UserList tempUsers = (UserList) jaxbUnmarshaller.unmarshal(file);
            return tempUsers;
        } catch (Exception e) {
            LogParser logParser = new LogParser();
            logParser.saveError(e);

            return new UserList();
        }
    }

    public void save(Object userList) {
        try{
            File file = new File(USER_DATABASE_FILENAME);

            JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            if (userList==null){userList=new UserList();}
            jaxbMarshaller.marshal(userList, file);
        } catch (Exception e) {
            LogParser logParser = new LogParser();
            logParser.saveError(e);
        }
    }

}
