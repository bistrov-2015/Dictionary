/*
* класс запукает приложение при помощи метода public void runApplication(), в котором у объекта simpleConsoleApplication вызывается метод runApplication() переопределённый в классе simpleConsoleApplication*/
package MyApplication.Classes;

public class ApplicationLogic {
    SimpleConsoleApplication simpleConsoleApplication = new SimpleConsoleApplication();
        public void runApplication() {

        try {
            simpleConsoleApplication.runApplication();
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
