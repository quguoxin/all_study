package day19.t2;

import java.io.Serializable;

public class Monster implements Serializable{
    private static final long serialVersionUID = -8817917694586703525L;
    private int monsterBlood;
    private int monsterDefense;

    @Override
    public String toString() {
        return "Monster{" +
                "monsterBlood=" + monsterBlood +
                ", monsterDefense=" + monsterDefense +
                '}';
    }

    public Monster() {
    }

    public Monster(int monsterBlood, int monsterDefense) {
        this.monsterBlood = monsterBlood;
        this.monsterDefense = monsterDefense;
    }

    public int getMonsterBlood() {
        return monsterBlood;
    }

    public void setMonsterBlood(int monsterBlood) {
        this.monsterBlood = monsterBlood;
    }

    public int getMonsterDefense() {
        return monsterDefense;
    }

    public void setMonsterDefense(int monsterDefense) {
        this.monsterDefense = monsterDefense;
    }
}
