package solutionpackage;

 class findAPI2 {
    class File {
        public String name; 
        public int type;
        public int size; 
        public boolean isDirectory;  
    }

    abstract class Filter {
        abstract boolean apply(File file);
    }

    class TypeFilter extends Filter {

        int filterType; 

        public TypeFilter(int type){
            this.filterType = type;
        }

        boolean apply(File file){
           return file.type == this.filterType; 
        }
    }

    class SizeFilter extends Filter{

        int filterSize; 

        public SizeFilter(int size){
            this.filterSize = size; 
        }

        boolean apply(File file){
            return file.size > this.filterSize; 
        }

    }

    class FindCommand {

        enum level {
            LV1,
            Lv2,
            LV3
        }



    }




}




