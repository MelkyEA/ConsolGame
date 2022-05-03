package consolGame.units;

import consolGame.players.AbstractPlayer;
import lombok.Data;

import java.util.List;

@Data
public abstract class AbstractUnit {
    protected int hp;
    protected int damage;
    protected String name;
    protected List<AbstractUnit> team;
    protected AbstractPlayer controller;

    public abstract int getTakenDamage(AbstractUnit enemyUnit);

    public void attack(AbstractUnit enemyUnit) {
        System.out.println(this + " наносит удар по " + enemyUnit);

        int totalDamage = enemyUnit.getTakenDamage(this);

        int resultHp = enemyUnit.getHp() - totalDamage;
        if (resultHp < 0) resultHp = 0;

        enemyUnit.setHp(resultHp);
    }

    @Override
    public String toString() {
        return name + "[HP:" + hp + " DMG:" + damage + "]";
    }
}
