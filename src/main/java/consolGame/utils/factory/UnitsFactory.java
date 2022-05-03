package consolGame.utils.factory;

import consolGame.players.AbstractPlayer;
import consolGame.units.AbstractUnit;
import consolGame.units.Archer;
import consolGame.units.Warrior;
import consolGame.units.Wizard;

import java.util.List;

public class UnitsFactory {

    public AbstractUnit createUnit(UnitsType type, List<AbstractUnit> team, AbstractPlayer controller) {
        AbstractUnit result;
        switch (type) {
            case ARCHER:
                result = new Archer(130, 75, "Лучник", team, controller);
                break;
            case WIZARD:
                result = new Wizard(210, 50, "Маг", team, controller);
                break;
            case WARRIOR:
                result = new Warrior(250, 90, "Воин", team, controller);
                break;
            default:
                throw new RuntimeException("Неподдерживаемый тип юнита: " + type.name());
        }

        return result;
    }
}
