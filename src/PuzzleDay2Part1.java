import day2.RPZ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class PuzzleDay2Part1 {

    public static void main(String[] args) throws FileNotFoundException {

        String file = "src/resources/fileDay2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> input = reader.lines().collect(Collectors.toList());
        int finalScore = 0;
        for(String singleInput : input){
            String[] splittedInput = singleInput.split(" ");
            finalScore += myGameScore(splittedInput[0], splittedInput[1]) + RPZ.getByMValue(splittedInput[1]).getScore();
        }
        System.out.println(finalScore);
    }

    public static int myGameScore(String opponent, String me){
        if(RPZ.getByValueOpponent(opponent) == RPZ.Scissors && RPZ.getByMValue(me) == RPZ.Rock)
            return 6;
        else if(RPZ.getByValueOpponent(opponent) == RPZ.Rock && RPZ.getByMValue(me) == RPZ.Paper)
            return 6;
        else if(RPZ.getByValueOpponent(opponent) == RPZ.Paper && RPZ.getByMValue(me) == RPZ.Scissors)
            return 6;
        else if(RPZ.getByValueOpponent(opponent) == RPZ.getByMValue(me))
            return 3;
        else
            return 0;
    }
}
