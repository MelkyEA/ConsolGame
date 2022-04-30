package consolGame.players;

import consolGame.units.AbstractUnit;

import java.util.List;

public class AI extends AbstractPlayer {

    public AI(List<AbstractUnit> units, String name) {
        this.units = units;
        this.name = name;
    }

    public static AbstractUnit chooseTarget(List<AbstractUnit> enemyUnits, AbstractUnit aiUnit) {
        AbstractUnit result = null;
        int maxDamage = 0;
        for (AbstractUnit abstractUnit : enemyUnits) {
            int takenDamage = abstractUnit.getTakenDamage(aiUnit);
            if (abstractUnit.getHp() <= takenDamage) {
                result = abstractUnit;
                break;
            } else if (maxDamage < takenDamage) {
                result = abstractUnit;
                maxDamage = takenDamage;
            }
        }

        if (result == null) {
            int indexEnemyUnit = (int) (Math.random() * enemyUnits.size());
            result = enemyUnits.get(indexEnemyUnit);
        }

        return result;
    }
}
