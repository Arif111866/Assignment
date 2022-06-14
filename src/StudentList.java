import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    public static void main(String[] args) {

        if(args.length > 1)
        {
            System.out.println("invalid number of argument Input");
            System.exit(1);
        }

//		Check arguments
        if(args[0].equals("a"))
        {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String studentName = bufferedReader.readLine();
                String[] names = studentName.split(",");
                for(String name : names) { System.out.println(name); }

            } catch (Exception e)
            {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        }

        else if(args[0].equals("r"))
        {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine() ;
                String[] studentName = line.split(",");
                Random random = new Random();
                int randomIndex = random.nextInt(4);
                System.out.println(studentName[randomIndex]);
            } catch (Exception e)
            {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("+"))
        {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String newStudentName = args[0].substring(1);
                Date date = new Date();
                String dateformat = "dd-mm-yyyy-hh :mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateformat);
                String formatted = dateFormat.format(date);
                bufferedWriter.write(", "+newStudentName+"\nList last updated on "+formatted);
                bufferedWriter.close();
            } catch (Exception e)
            {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("?"))
        {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String studentName = bufferedReader.readLine();
                String[] name = studentName.split(",");
                boolean done = false;
                String checkName = args[0].substring(1);
                for(int idx = 0 ; idx < name.length && !done ; idx = idx + 1 )
                {
                    if(name[idx].equals(checkName)) {
                        System.out.println("we found it !");
                        done=true;
                    }
                }
            } catch (Exception e)
            {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("c"))
        {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String studentname = bufferedReader.readLine();
                char names[] = studentname.toCharArray();
                boolean in_word = false;
                int count=1;
                for(char name :names) {
                   if(name == ',') count++ ;
                }
                System.out.println(count +" word(s) found ");
            } catch (Exception e)
            {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        }

        else
        {
            System.out.println("Invalid argument !");
        }
    }
}