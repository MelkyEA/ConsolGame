package consolGame.players;

import lombok.Data;
import consolGame.units.AbstractUnit;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractPlayer {

    protected List<AbstractUnit> units = new ArrayList<>();
    protected String name;
}
