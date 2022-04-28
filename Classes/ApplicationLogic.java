/*
* класс запукает приложение при помощи метода public void runApplication(), в котором у объекта simpleConsoleApplication вызывается метод runApplication() переопределённый в классе simpleConsoleApplication*/
package MyApplication.Classes;

import MyApplication.Interfaces.ApplicationInterface;

public class ApplicationLogic {
    ApplicationInterface simpleConsoleApplication = new SimpleConsoleApplication();
    /*public ApplicationLogic(SimpleConsoleApplication simpleConsoleApplication){
        this.simpleConsoleApplication = simpleConsoleApplication;
    }*/
        public void runApplication() {

        try {
            simpleConsoleApplication.runApplication();
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
