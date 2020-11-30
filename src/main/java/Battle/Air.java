package Battle;



public class Air extends Skill {

    private int life;
    private int stamina;

    public Air(int damageS, int damageF) {
        super(damageS, damageF);
        this.life = 800;
        this.stamina = 500;
    }

    public int getLife() {
        return life;
    }

    public int getStamina() {
        return stamina;
    }

    public String atack(int stamin2, int life2, int staminv, int stamin1, int defense) {
        int aux1 = staminaOfTurn(stamin2);
        int aux = simpleAttack(this.stamina);
        staminv = staminv + aux1;
        stamin1 = stamin1 - aux;
        if (stamin1 < 0) {
            stamin1 = 0;
        }
        if (staminv > stamin2) {
            staminv = stamin2;
        }
        double auxd = super.getDamageS() * 0.75;
        if (defense != 0) {
            life2 = life2 - (int) auxd;
            defense--;
        } else {
            life2 = life2 - super.getDamageS();
        }
        return staminv + "," + life2 + "," + stamin1 + "," + defense;
    }

    public String atackF(int stamina2, int life2, int staminv, int stamin1, int defense) {
        int aux1 = staminaOfTurn(stamina2);
        int aux = finalAttack(this.stamina);
        staminv = staminv + aux1;
        stamin1 = stamin1 - aux;
        if (stamin1 < 0) {
            stamin1 = 0;
        }
        if (staminv > stamina2) {
            staminv = stamina2;
        }
        double auxd = super.getDamageF() * 0.75;
        if (defense != 0) {
            life2 = life2 - (int) auxd;
            defense--;
        } else {
            life2 = life2 - super.getDamageF();
        }
        return staminv + "," + life2 + "," + stamin1 + "," + defense;
    }

    public String cures(int stamina2, int stamina, int staminv, int lifev, int def) {
        int aux1 = staminaOfTurn(stamina2);
        int aux = cure(this.stamina);
        staminv = staminv + aux1;
        stamina = stamina - aux;
        if (stamina < 0) {
            stamina = 0;
        }
        def--;
        if (staminv > stamina2) {
            staminv = stamina2;
        }
        double aux2 = this.life * 0.20;
        lifev = lifev + (int) aux2;
        if (lifev > this.life) {
            lifev = this.life;
        }
        return staminv + "," + stamina + "," + lifev + "," + def;
    }

    public String Defense(int stamina2, int stamina, int staminv) {
        int aux1 = staminaOfTurn(stamina2);
        int aux = defense(this.stamina);
        staminv = staminv + aux1;
        stamina = stamina - aux;
        if (stamina < 0) {
            stamina = 0;
        }
        if (staminv > stamina2) {
            staminv = stamina2;
        }
        return staminv + "," + stamina;
    }
}
