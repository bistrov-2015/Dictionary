package MyApplication;

public class SimpleConsoleApplication implements ApplicationInterface{
    String selectedItem;
    SimpleConsoleApplicationIOMethods simpleConsoleApplicationIOMethods = new SimpleConsoleApplicationIOMethods();
    CheckAndRequestFunctions checkAndRequestFunctions = new CheckAndRequestFunctions();
    boolean runAp = true;

    public void runApplication(){
        while (runAp) {
            //checkAndRequestFunctions.checkFileExistence();
            showUserMenu();
            handleUserSelection();
            performSelectedAction();
        }
    }

    public void showUserMenu(){
        simpleConsoleApplicationIOMethods.showMenu();
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
