package is.katas.tennis;

import java.util.ArrayList;
import java.util.List;

public class MyTennisGame implements TennisGame {

    List<String> names = new ArrayList<>();
    int [] scores = {0, 0};
    private String[] results = {"Love-All", "Fifteen-All", "Thirty-All", "Forty-All"};
    
    public MyTennisGame(String player1, String player2) {
        names.add(player1);
        names.add(player2);
    }
    
    @Override
    public void wonPoint(String playerName) {
        scores[names.indexOf(playerName)]++;
    }

    @Override
    public String getScore() {
        return isThereWinner() ? winner() :
                isDeuce() ? "Deuce" :
                areTied() ? results[scores[0]] + "-All" :
                isThereAdvantage() ? advantage() :
                results[scores[0]] + "-" + results[scores[1]];
    }

    private boolean isThereWinner() {
        return scores[0] == 4 || scores[1] == 4;
    }

    private String winner() {
        return (scores[0] == 4 || scores[1] == 4) && scores[0] < scores[1] ? names.get(1) : names.get(0);
    }

    private boolean isDeuce() {
        return areTied() && scores [0] >= 4;
    }

    private boolean isThereAdvantage() {
        return scores[0] >= 4 || scores[1] >= 4;
    }

    private String advantage() {
        return scores[0] < scores[1] ? names.get(1) : names.get(0);
    }

    private boolean areTied() {
        return scores[0] == scores[1];
    }
    
}
