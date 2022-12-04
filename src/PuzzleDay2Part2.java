import day2.RPZ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class PuzzleDay2Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/resources/fileDay2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> input = reader.lines().collect(Collectors.toList());
        int finalScore = 0;
        for(String singleInput : input){
            String[] splittedInput = singleInput.split(" ");
            RPZ myChoice = whatShouldIChoose(splittedInput[0], splittedInput[1]);
            finalScore += myGameScore(splittedInput[0], myChoice.getMyValue()) + RPZ.getByMValue(myChoice.getMyValue()).getScore();
        }
        System.out.println(finalScore);

    }

    public static RPZ whatShouldIChoose(String opponent, String result){
        if(result.equals( "Y")){
            return RPZ.getByValueOpponent(opponent);
        }
        else if(result.equals("Z")){
            if(RPZ.getByValueOpponent(opponent) == RPZ.Scissors)
                return RPZ.Rock;
            else if(RPZ.getByValueOpponent(opponent) == RPZ.Rock)
                return RPZ.Paper;
            else if(RPZ.getByValueOpponent(opponent) == RPZ.Paper)
                return RPZ.Scissors;
        }else{
            if(RPZ.getByValueOpponent(opponent) == RPZ.Scissors)
                return RPZ.Paper;
            else if(RPZ.getByValueOpponent(opponent) == RPZ.Rock)
                return RPZ.Scissors;
            else if(RPZ.getByValueOpponent(opponent) == RPZ.Paper)
                return RPZ.Rock;
        }
        return null;
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
