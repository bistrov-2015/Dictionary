/*
* класс реализует логику работы приложения имплементируя ApplicationInterface;
* public void runApplication() - вызывает методы до тех пор пока переменная runAp = true;
* public void showUserMenu() - метод реализует показ пользователю пунктов меню приложения;
* public void  handleUserSelection() - метод реализует запрос действия от пользователя;
* public void performSelectedAction() - метод обрабатывет выбор пользователя в зависимости от выбранного пункта меню;
 * */
package MyApplication.Classes;

import MyApplication.Interfaces.ApplicationInterface;

public class SimpleConsoleApplication implements ApplicationInterface {
    String selectedItem;
    SimpleConsoleApplicationIOMethods simpleConsoleApplicationIOMethods = new SimpleConsoleApplicationIOMethods();
    CommunicationWithTheUser communicationWithTheUser = new CommunicationWithTheUser();
    CheckFunctions checkFunctions = new CheckFunctions();
    RequestFunctions requestFunctions = new RequestFunctions();

    boolean runAp = true;

    public void runApplication(){
        checkFunctions.checkFileExistence();
        while (runAp) {
            showUserMenu();
            handleUserSelection();
            performSelectedAction();
        }
    }

    public void showUserMenu(){
        communicationWithTheUser.showMenu();
    };

    public void  handleUserSelection(){
        selectedItem = requestFunctions.promptUserSelection();
    };

    public void performSelectedAction(){
        if(selectedItem.equals("1")){
            simpleConsoleApplicationIOMethods.showDictionary();
        } else if(selectedItem.equals("2")){
            simpleConsoleApplicationIOMethods.findEntryInDictionary();
        } else if(selectedItem.equals("3")){
            simpleConsoleApplicationIOMethods.makeEntryInDictionary();
        } else if(selectedItem.equals("4")){
            simpleConsoleApplicationIOMethods.deleteEntryInDictionary();
        } else if (selectedItem.equals("5")){
            runAp = false;
        }
    };
}
