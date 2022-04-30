package consolGame.units;

public class Wizard extends AbstractUnit {
    public Wizard(int hp, int damage, String name) {
        this.hp = hp;
        this.damage = damage;
        this.name = name;
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
