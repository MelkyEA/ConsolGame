package consolGame.actions;

import consolGame.players.AI;
import consolGame.players.AbstractPlayer;
import consolGame.players.Human;
import consolGame.units.AbstractUnit;
import consolGame.utils.Interface;
import lombok.Data;

import java.util.List;

@Data
public class Battle {

    private final Human human;
    private final AI ai;
    private final Interface anInterface;
    private int indexAiUnit = 0;

    public Battle(Human human, AI ai, Interface anInterface) {
        this.human = human;
        this.ai = ai;
        this.anInterface = anInterface;
    }

    public void fight() {
        getBattle(human.getUnits(), ai.getUnits());
    }

    public void getBattle(List<AbstractUnit> humanUnits, List<AbstractUnit> aiUnits) {
        AbstractPlayer attacker = human;

        while (!humanUnits.isEmpty() && !aiUnits.isEmpty()) {

            anInterface.printTeams(humanUnits, aiUnits);

            if (attacker instanceof Human) {

                System.out.println("Ты атакуешь противника!");

                System.out.println("Введи номер юнита, который будет атаковать:");
                int indexUnitsHuman = anInterface.getIntFromScanner(humanUnits.size());

                System.out.println("Введи номер юнита противника, который будет атакован:");
                int indexEnemy = anInterface.getIntFromScanner(aiUnits.size());

                setupDuel(humanUnits.get(indexUnitsHuman - 1), aiUnits.get(indexEnemy - 1));

                attacker = ai;
            } else {
                System.out.println("Противник атакует тебя!");

                if (indexAiUnit >= aiUnits.size()) {
                    indexAiUnit = 0;
                }

                AbstractUnit unit = aiUnits.get(indexAiUnit++);
                setupDuel(unit, AI.chooseTarget(humanUnits, unit));

                attacker = human;
            }
        }

        anInterface.checkWinner(human, ai);
    }

    private void setupDuel(AbstractUnit attacker, AbstractUnit defender) {
        getDuel(attacker, defender);

        if (isAlive(defender)) {
            getDuel(defender, attacker);
        }

        isAlive(attacker);
    }

    private void getDuel(AbstractUnit attacker, AbstractUnit defender) {
        String defenderBeforeFight = defender.toString();

        int resultDamage = defender.getTakenDamage(attacker);
        attacker.attack(defender);
        System.out.println("Нанесено урона: " + resultDamage);

        String defenderAfterFight = defender.toString();
        if (defender.getHp() != 0) {
            System.out.println(defenderBeforeFight + " -> " + defenderAfterFight);

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isAlive(AbstractUnit abstractUnit) {
        if (abstractUnit.getHp() == 0) {

            System.out.println(abstractUnit + " погибает");

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            abstractUnit.getTeam().remove(abstractUnit);
            if (abstractUnit.getController() instanceof AI)
                decrementAiIndex();
            return false;
        } else {
            return true;
        }
    }


    private void decrementAiIndex() {
        if (indexAiUnit != 0) {
            indexAiUnit--;
        }
    }
}
