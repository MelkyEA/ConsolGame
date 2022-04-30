package consolGame.actions;

import consolGame.players.AI;
import consolGame.players.Human;
import consolGame.units.AbstractUnit;
import consolGame.utils.factory.UnitsFactory;
import consolGame.utils.factory.UnitsType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreBattle {


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
        addUnits(unitsHuman, 3, true);
        Human human = new Human(unitsHuman, "Ты");

        List<AbstractUnit> unitsAI = new ArrayList<>();
        addUnits(unitsAI, 3, false);
        AI ai = new AI(unitsAI, "Противник");

        Battle battle = new Battle(human, ai);
        battle.fight();
    }

    private void addUnits(List<AbstractUnit> unitList, int size, boolean isHuman) {
        Scanner sc = new Scanner(System.in);
        UnitsFactory factory = new UnitsFactory();

        for (int i = 0; i < size; i++) {
            int number;
            if (isHuman) {
                System.out.println("Введи номер " + (i + 1) + " юнита:");
                number = sc.nextInt() - 1;
            } else {
                number = i;
            }
            AbstractUnit unit = factory.createUnit(UnitsType.values()[number]);
            unit.setTeam(unitList);
            unitList.add(unit);
        }
    }
}
