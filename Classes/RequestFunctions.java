/*
* класс реализует методы запроса данных у пользователя:
* public String promptUserSelection() - запрос пункта меню;
* public String promptDictionaryType() - запрос типа словаря с которым хочет работать пользователь;
* public String requestExpressiont(String numDict) - метод запроса слова(ключа) для словаря и проверка его на удовлетвореня условиям ТЗ для конкретного словаря, в зависимости от того какой словарь выбран;
* public String requestExpressionValue(String numDict) - метод запроса слова(значения) для словаря и проверка его на удовлетвореня условиям ТЗ для конкретного словаря, в зависимости от того какой словарь выбран;
*  */
package MyApplication.Classes;

import java.util.Scanner;

public class RequestFunctions {
    CommunicationWithTheUser communicationWithTheUser = new CommunicationWithTheUser();
    CheckFunctions checkFunctions = new CheckFunctions();
    String numDict;
    String selectItem;
    public String promptUserSelection(){
        Scanner scanner = new Scanner(System.in);
        communicationWithTheUser.promptAction();
        selectItem = scanner.nextLine();
        if (checkFunctions.chekUserSelection(selectItem) != true) {
            promptUserSelection();
        }
        return selectItem;
    }

    public String promptDictionaryType(){
        Scanner scanner = new Scanner(System.in);
        communicationWithTheUser.promptDictionary();
        numDict = scanner.nextLine();
        if (checkFunctions.checkDictionaryTypeSelection(numDict) != true) {
            promptDictionaryType();
        }
        return numDict;
    }

    public String requestExpressiont(String numDict){
        String stringToFile = communicationWithTheUser.promptLine();
        if("1".equals(numDict)){
            while (checkFunctions.checkSymbolString(stringToFile) != true){
                communicationWithTheUser.showStringFormatForExpression();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }else if ("2".equals(numDict)){
            while (checkFunctions.checkNumericString(stringToFile) != true){
                communicationWithTheUser.showNumberFormatForExpression();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }
        return stringToFile;
    }

    public String requestExpressionValue(String numDict){
        String stringToFile = communicationWithTheUser.promptLine();
        if("1".equals(numDict)){
            while (checkFunctions.checkSymbolExpressionValue(stringToFile) != true){
                communicationWithTheUser.showStringFormatForExpressionValue();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }else if ("2".equals(numDict)){
            while (checkFunctions.checkNumericExpressionValue(stringToFile) != true){
                communicationWithTheUser.showNumberFormatForExpressionValue();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }
        return stringToFile;
    }

}
