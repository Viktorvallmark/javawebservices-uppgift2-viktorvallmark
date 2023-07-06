package com.example.stensaxpase;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class modelSSP {


    private final playerB player;
    private ArrayList<String> result = new ArrayList<>();

    public modelSSP(String name) {
        this.player = new playerB(name);
    }

    public String playGame(@NotNull String choice){
        //computerChoice = [0 , 0.33) means comp chose sten.
        //computerChoice = (0.33 , 0.66] means comp chose påse.
        //computerChoice = (0.66 , 1.00] means comp chose sax.



        double computerChoice = Math.random();

        switch (choice) {
            case "rock" -> {
                if (computerChoice <= 0.33) {
                    result.add("draw");
                    player.addGames();
                    player.addDraw();
                    return "<div>You chose: " + choice + " and computer chose: rock! It is a draw!</div>";
                } else if (computerChoice <= 0.66) {
                    player.addGames();
                    result.add("loss");
                    player.addLoss();
                    return "<div>You chose: " + choice + " and computer chose: paper! You lose this one!</div>";
                } else {
                    player.addGames();
                    result.add("win");
                    player.addWin();
                    return "<div>You chose: " + choice + " and the computer chose: scissor! You win this one!</div>";
                }
            }
            case "scissor" -> {
                if (computerChoice <= 0.33) {
                    player.addGames();
                    result.add("loss");
                    player.addLoss();
                    return "<div>You chose: " + choice + "and computer chose: rock! You lose this one!</div>";
                } else if (computerChoice <= 0.66) {
                    player.addGames();
                    result.add("win");
                    player.addWin();
                    return "<div>You chose: " + choice + "and computer chose: paper! You win this one!</div>";
                } else {
                    player.addGames();
                    result.add("draw");
                    player.addDraw();
                    return "<div>You chose: " + choice + "and the computer chose: scissor! It is a draw!</div>";
                }
            }
            case "paper" -> {
                if (computerChoice <= 0.33) {
                    player.addGames();
                    result.add("win");
                    player.addWin();
                    return "<div>You chose: " + choice + "and computer chose: rock! You win this one!</div>";
                } else if (computerChoice <= 0.66) {
                    player.addGames();
                    result.add("draw");
                    player.addDraw();
                    return "<div>You chose: " + choice + "and computer chose: paper! It is a draw!</div>";
                } else {
                    player.addGames();
                    result.add("loss");
                    player.addLoss();
                    return "<div>You chose: " + choice + "and the computer chose: scissor! You lose this one!</div>";
                }
            }
        }
        return "<div>Please play again!</div>";
    }

    public playerB getPlayer () {
        return this.player;
    }
    public String checkWinStreak() {
        int streakStore = 0;
        if(player.countGames()){
            for(int n = 0; n < result.size(); n++) {
                for(int i = n+1; i < result.size(); i++) {
                    if(result.get(n).equals(result.get(i))) {
                        ++streakStore;
                }else {
                        streakStore = 0;
                }
                }
            }
            return "<div>Player "+ player.getName() + " has a win streak of " + (streakStore)+"</div>";
        }else
            return "<div>Player "+ player.getName() + " needs to play more games to earn a winning streak!</div>";
    }

    public String showResult(){
            String pattern = "{ [ wins: %s, losses: %s, draws: %s ] }";
            return String.format(pattern, player.getWin(), player.getLoss(), player.getDraw());
        }

}
