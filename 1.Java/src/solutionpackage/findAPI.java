package solutionpackage;

import java.io.File; 
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
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
    
    //Find all files over X MB somewhere under a directory/subdirectory.
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
        }  
        catch (Exception err){
            System.out.println("An unexpected error is occurred.");  
            err.printStackTrace();
        }
    }
    
    //Find all X type files 
    public void findFileType(String directory, String type ){

        File dir = new File(directory);

        try {
            if (dir.exists()){
                
                File[] files = dir.listFiles();

                if(files == null) {
                    return; 
                }

                for (File i: files){
                    if(i.isDirectory()){
                        findFileType(i.getPath(), type);
                    }

                    String[] fileSplits = i.getName().split("\\.");

                    // System.out.println(fileSplits[fileSplits.length-1]);
                    // System.out.println(type);
                    if(fileSplits[fileSplits.length-1].equals(type)) {
                        System.out.println(i.getName());
                    }

                }
            }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("An unexpected error is occurred.");  
            e.printStackTrace();
        }
    }

    //Find all files modified within the last X days 
    public void findModifiedXdays(String directory, int day ){

        File dir = new File(directory);
        long currentTimestamp = System.currentTimeMillis();

        

        if (dir.exists()){
            try {

                File[] files = dir.listFiles();
                if (files == null) {
                    return; 
                }

                for(File i: files){

                    if (i.isDirectory()){
                        findModifiedXdays(i.getPath(), day);
                    }

                    long timeDiff = currentTimestamp-i.lastModified();

                    if(timeDiff < day*24*60*60*1000){

                        Date date = new Date(i.lastModified());
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
                        String formatted = format.format(date);

                        System.out.println(i.getName() + " - Modified At: " + formatted);
                    }
                }
                

            } catch(Exception e){
                System.out.println("An unexpected error happened.");
                e.printStackTrace();
            }
        }

    }

}
