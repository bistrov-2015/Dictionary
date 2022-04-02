package MyApplication;

public class SimpleConsoleApplication implements ApplicationInterface{
    String selectedItem;
    SimpleConsoleApplicationIOMethods simpleConsoleApplicationIOMethods = new SimpleConsoleApplicationIOMethods();
    CheckAndRequestFunctions checkAndRequestFunctions = new CheckAndRequestFunctions();
    CommunicationWithTheUser communicationWithTheUser = new CommunicationWithTheUser();
    boolean runAp = true;

    public void runApplication(){
        checkAndRequestFunctions.checkFileExistence();
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
        selectedItem = checkAndRequestFunctions.promptUserSelection();
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
