package consolGame.utils.factory;

import consolGame.units.AbstractUnit;
import consolGame.units.Archer;
import consolGame.units.Warrior;
import consolGame.units.Wizard;

public class UnitsFactory {

    public AbstractUnit createUnit(UnitsType type) {
        AbstractUnit result;
        switch (type) {
            case ARCHER:
                result = new Archer(130, 75, "Лучник");
                break;
            case WIZARD:
                result = new Wizard(210, 50, "Маг");
                break;
            case WARRIOR:
                result = new Warrior(250, 90, "Воин");
                break;
            default:
                throw new RuntimeException("Неподдерживаемый тип юнита: " + type.name());
        }

        return result;
    }
}
