package day2;

public enum RPZ {
    Rock("A", "X", 1),
    Paper("B", "Y", 2),
    Scissors("C", "Z", 3);


    private String valueOpponent;
    private String myValue;
    int score;

    private RPZ(String valueOpponent, String myValue,int score){
        this.valueOpponent = valueOpponent;
        this.myValue = myValue;
        this.score = score;
    }

    public static RPZ getByValueOpponent(String valueOpponent){
        if(valueOpponent.equals("A"))
            return Rock;
        else if(valueOpponent.equals("B"))
            return Paper;
        else
            return Scissors;
    }

    public static RPZ getByMValue(String valueOpponent){
        if(valueOpponent.equals("X"))
            return Rock;
        else if(valueOpponent.equals("Y"))
            return Paper;
        else
            return Scissors;
    }

    public String getValueOpponent() {
        return valueOpponent;
    }

    public void setValueOpponent(String valueOpponent) {
        this.valueOpponent = valueOpponent;
    }

    public String getMyValue() {
        return myValue;
    }

    public void setMyValue(String myValue) {
        this.myValue = myValue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
