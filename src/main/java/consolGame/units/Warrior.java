package consolGame.units;

import consolGame.players.AbstractPlayer;

import java.util.List;

public class Warrior extends AbstractUnit {
    public Warrior(int hp, int damage, String name, List<AbstractUnit> team, AbstractPlayer controller) {
        this.hp = hp;
        this.damage = damage;
        this.name = name;
        this.team = team;
        this.controller = controller;
    }

    @Override
    public int getTakenDamage(AbstractUnit enemyUnit) {
        int damage = 0;

        if (enemyUnit instanceof Wizard) {
            damage = (int) (enemyUnit.damage * 1.3);
        }
        if (enemyUnit instanceof Archer) {
            damage = (int) (enemyUnit.damage * 0.3);
        }
        if (enemyUnit instanceof Warrior) {
            damage = enemyUnit.damage;
        }

        return damage;
    }
}
