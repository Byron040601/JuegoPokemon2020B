package Battle;

//Byron Huaraca
//Jorge Alaba
//Bernabé Dávila 


//Clase Habilidades (contiene el proceso de stamina, ataques,defensas y curacion)
public class Skill {

    private int damageS;
    private int damageF;

    public Skill(int damageS, int damageF) {
        this.damageS = damageS;
        this.damageF = damageF;
    }

    public int staminaOfTurn(int stam) {
        double aux = stam * 0.10;
        return (int) aux;
    }

    public int simpleAttack(int stam) {
        double aux = stam * 0.05;
        return (int) aux;
    }

    public int finalAttack(int stam) {
        double aux = stam * 0.5;
        return (int) aux;
    }

    public int defense(int stam) {
        double aux = stam * 0.25;
        return (int) aux;
    }

    public int cure(int stam) {
        double aux2 = stam * 0.20;
        return (int) aux2;
    }

    public int getDamageS() {
        return damageS;
    }

    public int getDamageF() {
        return damageF;
    }

}
