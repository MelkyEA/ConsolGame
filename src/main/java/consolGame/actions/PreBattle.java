package consolGame.actions;

import consolGame.players.AI;
import consolGame.players.Human;
import consolGame.units.AbstractUnit;
import consolGame.units.Archer;
import consolGame.units.Warrior;
import consolGame.units.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreBattle {

    private final List<AbstractUnit> units = new ArrayList<>();

    public PreBattle() {
        units.add(new Warrior(250, 90, "Воин"));
        units.add(new Archer(130, 75, "Лучник"));
        units.add(new Wizard(210, 50, "Маг"));
        initialisation();
    }

    private void initialisation() {
        System.out.println("Введите номер  бойца, которого хотите добавить:");

        Scanner sc = new Scanner(System.in);

        List<AbstractUnit> unitsHuman = new ArrayList<>();
        AbstractUnit unitHuman = units.get(sc.nextInt() - 1);
        unitHuman.setTeam(unitsHuman);
        unitsHuman.add(unitHuman);
        unitHuman = units.get(sc.nextInt() - 1);
        unitHuman.setTeam(unitsHuman);
        unitsHuman.add(unitHuman);
        unitHuman = units.get(sc.nextInt() - 1);
        unitHuman.setTeam(unitsHuman);
        unitsHuman.add(unitHuman);
        Human human = new Human(unitsHuman, "Ты");

        List<AbstractUnit> unitsAI = new ArrayList<>();
        AbstractUnit unitAi = units.get(0);
        unitAi.setTeam(unitsAI);
        unitsAI.add(unitAi);
        unitAi = units.get(1);
        unitAi.setTeam(unitsAI);
        unitsAI.add(unitAi);
        unitAi = units.get(2);
        unitAi.setTeam(unitsAI);
        unitsAI.add(unitAi);
        AI ai = new AI(unitsAI, "Противник");

        Battle battle = new Battle(human, ai);
        battle.fight();
    }
}
