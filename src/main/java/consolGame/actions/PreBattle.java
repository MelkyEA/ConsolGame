package consolGame.actions;

import consolGame.players.AI;
import consolGame.players.AbstractPlayer;
import consolGame.players.Human;
import consolGame.units.AbstractUnit;
import consolGame.utils.Interface;
import consolGame.utils.factory.UnitsFactory;
import consolGame.utils.factory.UnitsType;

import java.util.ArrayList;
import java.util.List;

public class PreBattle {

    private Interface anInterface = new Interface();


    public PreBattle() {
        initialisation();
    }

    private void initialisation() {
        System.out.println("Список доступных юнитов");

        for (int i = 0; i < UnitsType.values().length; i++) {
            UnitsType type = UnitsType.values()[i];

            System.out.print((i + 1) + "." + type.getType() + " ");
            if (i == UnitsType.values().length - 1)
                System.out.println();
        }


        List<AbstractUnit> unitsHuman = new ArrayList<>();
        Human human = new Human(unitsHuman, "Ты");
        addUnits(unitsHuman, 3, human);


        List<AbstractUnit> unitsAI = new ArrayList<>();
        AI ai = new AI(unitsAI, "Противник");
        addUnits(unitsAI, 3, ai);

        Battle battle = new Battle(human, ai, anInterface);
        battle.fight();
    }

    private void addUnits(List<AbstractUnit> unitList, int size, AbstractPlayer controller) {
        UnitsFactory factory = new UnitsFactory();

        for (int i = 0; i < size; i++) {
            int number;
            if (controller instanceof Human) {
                System.out.println("Введи номер " + (i + 1) + " юнита:");
                number = anInterface.getIntFromScanner(UnitsType.values().length) - 1;
            } else {
                number = i;
            }
            AbstractUnit unit = factory.createUnit(UnitsType.values()[number], unitList, controller);
            unit.setTeam(unitList);
            unitList.add(unit);
        }
    }
}
