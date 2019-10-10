package day19.t2;

import java.io.Serializable;

public class Player implements Serializable{
    private static final long serialVersionUID = 5957192677726211700L;
    private int playsRank;
    private int playsAttack;
    private int playsDefense;
    private int playsExperience;

    @Override
    public String toString() {
        return "Player{" +
                "playsRank=" + playsRank +
                ", playsAttack=" + playsAttack +
                ", playsDefense=" + playsDefense +
                ", playsExperience=" + playsExperience +
                '}';
    }

    public Player() {

    }

    public Player(int playsRank, int playsAttack, int playsDefense, int playsExperience) {
        this.playsRank = playsRank;
        this.playsAttack = playsAttack;
        this.playsDefense = playsDefense;
        this.playsExperience = playsExperience;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPlaysRank() {
        return playsRank;
    }

    public void setPlaysRank(int playsRank) {
        this.playsRank = playsRank;
    }

    public int getPlaysAttack() {
        return playsAttack;
    }

    public void setPlaysAttack(int playsAttack) {
        this.playsAttack = playsAttack;
    }

    public int getPlaysDefense() {
        return playsDefense;
    }

    public void setPlaysDefense(int playsDefense) {
        this.playsDefense = playsDefense;
    }

    public int getPlaysExperience() {
        return playsExperience;
    }

    public void setPlaysExperience(int playsExperience) {
        this.playsExperience = playsExperience;
    }
}
