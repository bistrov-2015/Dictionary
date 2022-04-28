/**/
package MyApplication.Classes;

public class Main {
   SimpleConsoleApplication simpleConsoleApplication;
    SimpleConsoleApplicationIOMethods simpleConsoleApplicationIOMethods;
    CommunicationWithTheUser communicationWithTheUser;
    CheckFunctions checkFunctions;
    RequestFunctions requestFunctions;

    public Main(SimpleConsoleApplication simpleConsoleApplication,
                SimpleConsoleApplicationIOMethods simpleConsoleApplicationIOMethods,
                CommunicationWithTheUser communicationWithTheUser,
                CheckFunctions checkFunctions,
                RequestFunctions requestFunctions) {
        this.communicationWithTheUser = new CommunicationWithTheUser();
        this.checkFunctions = new CheckFunctions(communicationWithTheUser);
        this.requestFunctions = new RequestFunctions(communicationWithTheUser,checkFunctions);
        this.simpleConsoleApplicationIOMethods = new SimpleConsoleApplicationIOMethods(checkFunctions, requestFunctions, communicationWithTheUser);
        this.simpleConsoleApplication = new SimpleConsoleApplication(simpleConsoleApplicationIOMethods, communicationWithTheUser, checkFunctions, requestFunctions);




    }

    public static void main(String[] args) {
        ApplicationLogic applicationLogic = new ApplicationLogic();
        applicationLogic.runApplication();
    }

}
