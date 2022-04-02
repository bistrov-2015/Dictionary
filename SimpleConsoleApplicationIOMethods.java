package MyApplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class SimpleConsoleApplicationIOMethods implements  DictionaryInterface{
    CheckAndRequestFunctions checkAndRequestFunctions = new CheckAndRequestFunctions();
    CommunicationWithTheUser communicationWithTheUser = new CommunicationWithTheUser();

    public void showDictionary(){
        BufferedReader br = null;
        String dictionariType = checkAndRequestFunctions.promptDictionaryType();
        try {
            br = new BufferedReader(new FileReader(defineDictionaryType(dictionariType)));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            communicationWithTheUser.fileReadError();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File defineDictionaryType(String dictionaryType){// переменнjq fileType присваивается значение взависимости от того каой словарь выбран
        File fileType = checkAndRequestFunctions.file1;
        if("1".equals(dictionaryType)){
            return fileType = checkAndRequestFunctions.file1;
        } else if("2".equals(dictionaryType)){
            return fileType = checkAndRequestFunctions.file2;
        }
        return fileType;// возможно создать дефолтный вайл
    }

    public Path definePathtoFile(String numDict){// переменной path присваивается значение взависимости от того каой словарь выбран
        Path path = checkAndRequestFunctions.path1;
        if("1".equals(numDict)){
            return path = checkAndRequestFunctions.path1;
        } else if("2".equals(numDict)){
            return path = checkAndRequestFunctions.path2;
        }
        return path;// возможно создать путь к дефолтному вайлу
    }

    public void  findEntryInDictionary(){
        String dictionariType = checkAndRequestFunctions.promptDictionaryType();
        File fileType = defineDictionaryType(dictionariType);
        BufferedReader br = null;
        String searchString = communicationWithTheUser.promptLine();
        String searchStringResult = null;

        try {
            br = new BufferedReader(new FileReader(fileType));
            String line;
            while ((line = br.readLine()) != null ) {
                if( line.contains(searchString)){
                    searchStringResult = line; break;
                }
            } br.close();
            if(searchStringResult != null){
                System.out.println(searchStringResult);
            } else communicationWithTheUser.stringNotFound();
        } catch (IOException e) {
            communicationWithTheUser.fileReadError();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void  makeEntryInDictionary(){
        CheckAndRequestFunctions checkAndRequestFunctions = new CheckAndRequestFunctions();
        String numDict = checkAndRequestFunctions.promptDictionaryType();
        Path pathToFile = definePathtoFile(numDict);
        String expression = checkAndRequestFunctions.requestExpressiont(numDict);
        communicationWithTheUser.promptValue();
        String expressionValue = checkAndRequestFunctions.requestExpressionValue(numDict);
        String checkedString = expression + "\t" + expressionValue;
        try {
            Files.writeString(pathToFile, "\n" + checkedString, StandardOpenOption.APPEND);
        } catch (IOException e) {
            communicationWithTheUser.fileWritingError();
        }
    }

    public boolean chekRowExistensBeforeDeleting(String searchString, File fileType) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileType));
            String line;
            while ((line = br.readLine()) != null ) {
                if (line.startsWith(searchString) == true) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            communicationWithTheUser.fileReadError();
        }
        return false;
    }

    public void  deleteEntryInDictionary(){
        String dictionaryType = checkAndRequestFunctions.promptDictionaryType();
        File fileType = defineDictionaryType(dictionaryType);
        Path path = definePathtoFile(dictionaryType);
        File temporaryFile = new File("C:" + checkAndRequestFunctions.separator + "temp.txt");
        BufferedReader br = null;
        //communicationWithTheUser.promptLine();
        String searchString = checkAndRequestFunctions.requestExpressiont(dictionaryType);

        if(chekRowExistensBeforeDeleting(searchString,fileType) == true) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(temporaryFile));
                br = new BufferedReader(new FileReader(fileType));
                String line;

                while ((line = br.readLine()) != null) {
                    if (!line.contains(searchString)) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
                br.close();
                bw.close();
                if (Files.deleteIfExists(path)) {
                    System.out.println("delete");
                } else System.out.println("not delete");
                if (temporaryFile.renameTo(fileType)) {
                    System.out.println("successfully");
                } else System.out.println("not rename");


            } catch (IOException e) {
                communicationWithTheUser.fileReadError();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else System.out.println("нет такой строки");
    }
}
