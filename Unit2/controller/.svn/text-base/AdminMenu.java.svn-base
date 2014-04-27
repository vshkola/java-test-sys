package Unit2.controller;



import Unit2.question.History;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    final String RESULTS_FOLDER = "files/history/";
    final String RESULT_EXTENSION = ".xml";

    public void startAdminMenu(String user1) {
        Boolean complete=false;
        if(user1.equals("admin")){
            while (!complete)  {

                System.out.println();
                System.out.println("Administration");
                System.out.println("_______________________");
                System.out.println("1.Пройти тест");
                System.out.println("2.Последние рейтинги всех пользователей");
                System.out.println("3.Очистить рейтинг пользователя");
                System.out.println("4.Удалить пользователя");
                System.out.println("_______________________");

                int choice = Authentification.getMenuChoice(4);
                switch (choice){
                    case 1:
                        complete=true;
                        break;
                    case 2:
                        showRatings();
                        break;
                }
            }
        }
    }
    public void showRatings()  {
        String listl[] = new File(
                RESULTS_FOLDER)
                .list(new FilenameFilter() {
                    public boolean accept(File dir, String namelink) {
                        return namelink.endsWith(RESULT_EXTENSION);
                    }
                });
        System.out.println(listl);

        for (int i = 0; i < listl.length; i++) {
            History tempHistory = new History(RESULTS_FOLDER + listl[i]);
            System.out.println("Пользователь: " + listl[i].replaceAll(RESULT_EXTENSION,""));
            tempHistory = (History)tempHistory.load();

                System.out.println(tempHistory.getRatingList().get(tempHistory.getRatingList().size()-1).toString());
        }


    }

}