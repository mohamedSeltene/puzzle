import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PuzzleDay1Part2 {

    public static void main(String[] args) throws IOException {
        String file = "src/resources/fileTest.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        int[] maxArray = new int[3];
        List<String> list = reader.lines().collect(Collectors.toList());
        int counter = 0;
        int j = 0;
        for(String str : list){
            if(str.equals("")){
                if(j==0){
                    maxArray[0] = counter;
                    j++;
                } else if (j==1){
                    maxArray[1] = counter;
                    j++;
                }else if(j==2){
                    maxArray[2] = counter;
                    j++;
                }
                if(counter > maxArray[0] || counter > maxArray[1] || counter > maxArray[2] ){
                    int index = PuzzleDay1Part2.getLowestNumberIndex(maxArray);
                    maxArray[index] = counter;
                }
                counter = 0;
            }else{
                counter += Integer.valueOf(str);
            }
        }
        System.out.println(maxArray[0]+maxArray[1]+maxArray[2]);
        reader.close();
    }

    public static int getLowestNumberIndex(int... intArray){
        int lowestValueIndex = 0;
        int lower = 999999999;
        for(int i=0; i < intArray.length; i++){
            if(lower >= intArray[i]){
                lower = intArray[i];
                lowestValueIndex = i;
            }
        }
        return  lowestValueIndex;
    }
}
