package consolGame.players;

import consolGame.units.AbstractUnit;

import java.util.List;

public class Human extends AbstractPlayer {

    public Human(List<AbstractUnit> units, String name) {
        this.units = units;
        this.name = name;
    }
}
