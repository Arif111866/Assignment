import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    public static String getLineFromFile(){
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constant.fileName)));
            return bufferedReader.readLine();
        } catch (Exception e) {
        }
        return null;
    }
    public static void fileWrite(String newStudentName , String  formatted){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(Constant.fileName, true));
            bufferedWriter.write(", "+newStudentName+Constant.updateInfo+formatted);
            bufferedWriter.close();

        }catch (Exception e){

        }
    }
    public static void main(String[] args) {

        if(args.length != 1) {
                System.out.println(Constant.error);
                System.exit(1);
        }
         if(!Objects.equals(args[0], Constant.showAll) && !Objects.equals(args[0], Constant.countStudent) && !args[0].contains("?") && !args[0].contains("+") && !Objects.equals(args[0], Constant.showRandom))
        {
            System.out.println(Constant.error);
            System.exit(1);
         }
//		Check arguments
        System.out.println(Constant.loadingInfo);
        if(args[0].equals(Constant.showAll) )
        {
                String studentName = getLineFromFile() ;
                System.out.println(studentName);
                String[] names = studentName.split(Constant.coma);
                for(String name : names) { System.out.println(name);}
        }

        else if(args[0].equals(Constant.showRandom))
        {
                String line = getLineFromFile() ;
                String[] studentName = line.split(Constant.coma);
                Random random = new Random();
                int randomIndex = random.nextInt(studentName.length);
                System.out.println(studentName[randomIndex]);
        }
        else if(args[0].contains(Constant.addWord))
        {
                String newStudentName = args[0].substring(1);
                Date date = new Date();
                String dateformat = Constant.dd ;
                DateFormat dateFormat = new SimpleDateFormat(dateformat);
                String formatted = dateFormat.format(date);
                fileWrite(newStudentName , formatted);


            System.out.println();
        }
        else if(args[0].contains(Constant.findWord))
        {
                String studentName = getLineFromFile() ;
                String[] name = studentName.split(Constant.coma);
                boolean done = false;
                String checkName = args[0].substring(1);
                for(int idx = 0 ; idx < name.length && !done ; idx = idx + 1 )
                {
                    if(name[idx].equals(checkName)) {
                        System.out.println(Constant.foundMessage);
                        done=true;
                    }
                }
                if(!done){
                    System.out.println(Constant.notFoundMessage);
                }
        }
        else if(args[0].contains(Constant.countStudent))
        {
                String studentname = getLineFromFile() ;
                char names[] = studentname.toCharArray();
                boolean in_word = false;
                int count=1;
                for(char name :names) {
                   if(name == ',') count++ ;
                }
                System.out.println(count +Constant.foundMessage);
        }
        System.out.println(Constant.loaded);
    }

}