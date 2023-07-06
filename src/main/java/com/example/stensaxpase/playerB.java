package com.example.stensaxpase;

public class playerB {


    private int win,loss,draw,games = 0;
    private long token;
    private final String name;

    public playerB(String name) {
        this.name = name;
        this.token = generateToken();
    }

    public int addWin() {
        return ++win;
    }

    public int addLoss() {
        return ++loss;
    }

    public int addDraw() {
        return ++draw;
    }
    public int addGames() {
        return ++games;
    }

    public String getName () {
        return this.name;
    }

    public int getWin () {
        return this.win;
    }
    public void setWin (int win) {
        this.win = win;
    }

    public int getLoss () {
        return this.loss;
    }

    public int getDraw () {
        return this.draw;
    }
    public long generateToken() {
        return ++token;
    }

    public boolean countGames () {
        return games >= 2;
    }





}
