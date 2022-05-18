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
    
    
    //Find all files over 5 MB somewhere under a directory.
    public void getFileGreaterThan(String directory, int maxMB) {

        File dir = new File(directory);

        try {
            if(dir.exists()){
                File[] files = dir.listFiles();
                if (files == null) {
                    return; 
                }

                for (File i: files){
                    if(i.isDirectory()){
                        // System.out.println(i.getName());    //leetcode_solutions
                        // System.out.println(i.getParent());  ///Users/idd/Desktop
                        // System.out.println("Getting into sub folder: "+i.getPath());
                        getFileGreaterThan(i.getPath(),maxMB);

                    }
                    if(i.length() > maxMB*1024*1024){
                        float size = i.length()/1024/1024; 
                        System.out.println(i.getName()+" ("+size+"MB)");
                    };
                }
            } 
        } catch (Exception e){
            System.out.println("An unexpected error is occurred.");  
            e.printStackTrace();
        }
    }

 


}
