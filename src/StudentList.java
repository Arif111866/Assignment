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
//      Check arguments
        System.out.println(Constant.loadingInfo);
        if(args[0].equals(Constant.showAll) )
        {
                //String studentName = getLineFromFile() ;
                System.out.println(getLineFromFile());
                String[] names = getLineFromFile().split(Constant.coma);
                for(String name : names) { System.out.println(name);}
        }

        else if(args[0].equals(Constant.showRandom))
        {
                //String line = getLineFromFile() ;
                String[] studentName = getLineFromFile().split(Constant.coma);
                Random random = new Random();
                //int randomIndex = random.nextInt(studentName.length);
                System.out.println(studentName[random.nextInt(studentName.length)]);
        }
        else if(args[0].contains(Constant.addWord))
        {
                String newStudentName = args[0].substring(1);
                Date date = new Date();
                //String dateformat = Constant.dd ;
                DateFormat dateFormat = new SimpleDateFormat(Constant.dd);
                //String formatted = dateFormat.format(date);
                fileWrite(newStudentName , dateFormat.format(date));


            System.out.println();
        }
        else if(args[0].contains(Constant.findWord))
        {
                //String studentName = getLineFromFile() ;
                String[] name = getLineFromFile().split(Constant.coma);
                //boolean done = false;
                //String checkName = args[0].substring(1);
                int idx = 0 ;
                for( ; idx < name.length ; idx = idx + 1 )
                {
                    if(name[idx].equals(args[0].substring(1))) {
                        System.out.println(Constant.foundMessage);
                        //done=true;
                        break ;
                    }
                }
                if(idx == name.length ){
                    System.out.println(Constant.notFoundMessage);
                }
        }
        else if(args[0].contains(Constant.countStudent))
        {
                //String studentname = getLineFromFile() ;
                String names[] = getLineFromFile().split(Constant.coma);
                
                System.out.println(names.length +Constant.foundMessage);
        }
        System.out.println(Constant.loaded);
    }

}
