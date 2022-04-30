package consolGame.units;

public class Archer extends AbstractUnit {
    public Archer(int hp, int damage, String name) {
        this.hp = hp;
        this.damage = damage;
        this.name = name;
    }

    @Override
    public int getTakenDamage(AbstractUnit enemyUnit) {
        int damage = 0;

        if (enemyUnit instanceof Wizard) {
            damage = (int) (enemyUnit.damage * 0.3);
        }
        if (enemyUnit instanceof Archer) {
            damage = enemyUnit.damage;
        }
        if (enemyUnit instanceof Warrior) {
            damage = (int) (enemyUnit.damage * 1.3);
        }

        return damage;
    }
}
