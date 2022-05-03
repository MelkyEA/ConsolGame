package consolGame.units;

import consolGame.players.AbstractPlayer;

import java.util.List;

public class Wizard extends AbstractUnit {
    public Wizard(int hp, int damage, String name, List<AbstractUnit> team, AbstractPlayer controller) {
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
            damage = enemyUnit.damage;
        }
        if (enemyUnit instanceof Archer) {
            damage = (int) (enemyUnit.damage * 1.3);
        }
        if (enemyUnit instanceof Warrior) {
            damage = (int) (enemyUnit.damage * 0.3);
        }

        return damage;
    }

}
