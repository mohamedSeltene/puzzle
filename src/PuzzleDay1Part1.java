import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws IOException {
        String file = "src/resources/fileTest.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        int max = 0;
        List<String> list = reader.lines().collect(Collectors.toList());
        int counter = 0;
        for(String str : list){
            if(str.equals("")){
                if(counter > max)
                    max = counter;
                counter = 0;
            }else{
                counter += Integer.valueOf(str);
            }
        }
        System.out.println(max);
        reader.close();
    }
}
