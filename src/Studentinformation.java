import java.util.*;
import java.io.*;
public class Studentinformation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("D:\\myfile1.txt"));
            String string = input.next();
            while(!string.equals("bye")) {
                writer1.write(string +  "\r\n");
                string = input.next();
            }
            writer1.close();
            BufferedReader reader = new BufferedReader(new FileReader("D:\\myfile1.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("D:\\myfile2.txt"));
            String line;
            while((line = reader.readLine()) != null) {
                writer2.write(line + "\n");
            }
            reader.close();
            writer2.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}