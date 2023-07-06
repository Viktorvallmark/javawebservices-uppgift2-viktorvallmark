package com.example.stensaxpase;

import org.springframework.web.bind.annotation.*;

@RestController
public class SspController {

    private modelSSP modelSSP;


    @GetMapping(value = "/")
    public String Landing() {
        return "<h1>Welcome to Rock, Paper, Scissor game by Viktor</h1><div>To create a player, please append the base url with /player and make a name request to the API" +
                " like this, /player?name=yournamehere. To play a game, first " +
                "create a player then append the base url with /game and make a choice request to the API like this, /game?choice=yourchoicehere." +
                " </div><div>To check your score and see if you have a win streak against the computer, please append the url with /results or /winstreak respectively. </div>";
    }

    @GetMapping(value = "/player", produces = "text/html")
        public String createPlayer(@RequestParam(name = "name") String playerName) {
        try {
            modelSSP = new modelSSP(playerName);
            return "<h1>Player with name " + playerName + " created!</h1>";
        }catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    @GetMapping(value = "/game", produces = "text/html")
    public String playGame(@RequestParam(name = "choice") String playerChoice) {
        try {
            return modelSSP.playGame(playerChoice);
        }catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    @GetMapping(value = "/winstreak", produces = "text/html")
    public String checkWinStreak() {
        try{
            if(modelSSP.getPlayer() == null) {
                return "No player found!";
            }else {
                return modelSSP.checkWinStreak();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/results")
    public String showResults() {
        return modelSSP.showResult();
    }


}
