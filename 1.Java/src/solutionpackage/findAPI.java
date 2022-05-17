package solutionpackage;

import java.io.File; 
import java.io.IOException;

public class findAPI {
    
    public void createMyFile(String directory, String filename) {
        String pathName = directory.concat(filename);

        File file = new File(pathName);
        try { 
            if(file.exists()) {
                System.out.println("The file already exists");
            } else {
                file.createNewFile();
                System.out.println("File "+file.getName()+" is created successfully.");
            }
        } catch (IOException e){
            System.out.println("An unexpected error is occurred.");  
            e.printStackTrace();

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("An unexpected error is occured.");
            e.printStackTrace();
        } catch (Exception e) { 
            System.out.println("An unexpected error is occured.");
            e.printStackTrace();
        }
    }

    public void getFileAndLength(String directory) {

        File dir = new File(directory);

        try {
            if(dir.exists()){
                File[] files = dir.listFiles();
                for (File i: files){
                    System.out.println(i.length());
                }
            } 
        } catch (Exception e){
            System.out.println("An unexpected error is occurred.");  
            e.printStackTrace();
        }
    }

 


}
