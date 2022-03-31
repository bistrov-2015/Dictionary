package MyApplication;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAndRequestFunctions {
    String separator = File.separator;
    Path path1 = Paths.get("C:" + separator + "Dictionary1.txt");
    Path path2 = Paths.get("C:" + separator + "Dictionary2.txt");
    /*File file1 = new File(String.valueOf(path1));
    File file2 = new File(String.valueOf(path2));*/
    File file1 = new File("C:" + separator + "Dictionary1.txt");
    File file2 = new File("C:" + separator + "Dictionary2.txt");
    String numDict;
    String selectItem;





    String promptUserSelection(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите действие << ");
        selectItem = scanner.nextLine();
        if (chekUserSelection(selectItem) != true) {
            promptUserSelection();
        }
        return selectItem;
    }

    public boolean chekUserSelection(String userSelection){
        String regex = "[12345]";
        if (Pattern.matches(regex, userSelection) == true){
            return true;
        }else return false;
    }

    public String promptDictionaryType(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Нажмите 1, чтобы выбрать Language Dictionary или 2, чтобы выбрать Numeric Dictionary " + "\n" + "<<");
        numDict = scanner.nextLine();
        if (checkDictionaryTypeSelection(numDict) != true) {
            promptDictionaryType();
        }
        return numDict;
    }

    public boolean checkDictionaryTypeSelection(String Dict){
        String regex = "[12]";
        if (Pattern.matches(regex, Dict) == true){
            return true;
        } else return false;
    }

    public void  checkFileExistence(){
        try {
            Scanner scanner1 = new Scanner(file1);
        } catch (FileNotFoundException e) {
            System.out.println("Файл Dictionary1 не найден");

        }
        try {
            Scanner scanner2 = new Scanner(file2);
        } catch (FileNotFoundException e) {
            System.out.println("Файл Dictionary2 не найден");
        }
    }

    public String requestExpressiont(String numDict){
        String stringToFile = promptString();
        if("1".equals(numDict)){
            while (checkSymbolString(stringToFile) != true){
                showStringFormatForExpression();
                stringToFile = promptString();
            }
        }else if ("2".equals(numDict)){
            while (checkNumericString(stringToFile) != true){
                showNumberFormatForExpression();
                stringToFile = promptString();
            }
        }
        return stringToFile;
    }

    public String requestExpressionValue(String numDict){
        String stringToFile = promptString();
        if("1".equals(numDict)){
            while (checkSymbolExpressionValue(stringToFile) != true){
                showStringFormatForExpressionValue();
                stringToFile = promptString();
            }
        }else if ("2".equals(numDict)){
            while (checkNumericExpressionValue(stringToFile) != true){
                showNumberFormatForExpressionValue();
                stringToFile = promptString();
            }
        }
        return stringToFile;
    }



    public void showStringFormatForExpression(){
        System.out.println("Введидите слово из 4 букв на латинской раскладке");
    }

    public void showNumberFormatForExpression(){
        System.out.println("Введидите число из 5 цифр");
    }

    public void showStringFormatForExpressionValue(){
        System.out.println("Введидите слово на русском языке");
    }
    public void showNumberFormatForExpressionValue(){
        System.out.println("Введидите число из 5 цифр");
    }

    public String promptString(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введидите слово<< ");
        String stringFromUser = scanner.nextLine();
        return stringFromUser;
    }

    public boolean checkNumericString(String chekedStr) {
        if (chekedStr.matches("^[0-9]+$") == true & chekedStr.length() == 5 ) {
            return true;
        }
        return false;
    }

    public boolean checkSymbolString(String chekedStr) {
        if (chekedStr.matches("^[a-zA-Z]+$") == true & chekedStr.length() == 4 ) {
            return true;
        }
        return false;
    }

    public boolean checkSymbolExpressionValue(String chekedStr) {
        if (chekedStr.matches("^[а-яА-Я]+$") == true ) {
            return true;
        }
        return false;
    }

    public boolean checkNumericExpressionValue(String chekedStr) {
        if (chekedStr.matches("^[0-9]+$") == true ) {
            return true;
        }
        return false;
    }
}
