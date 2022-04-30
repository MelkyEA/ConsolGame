package consolGame.actions;

import consolGame.players.AI;
import consolGame.players.AbstractPlayer;
import consolGame.players.Human;
import consolGame.units.AbstractUnit;

import java.util.List;
import java.util.Scanner;

public class Battle {

    private final Human human;
    private final AI ai;

    public Battle(Human human, AI ai) {
        this.human = human;
        this.ai = ai;
    }

    public void fight() {
        getBattle(human.getUnits(), ai.getUnits());
    }

    public void getBattle(List<AbstractUnit> humanUnits, List<AbstractUnit> aiUnits) {
        int indexAiUnit = 0;
        AbstractPlayer attacker = human;

        while (!humanUnits.isEmpty() && !aiUnits.isEmpty()) {

            printTeams(humanUnits, aiUnits);

            if (attacker instanceof Human) {

                System.out.println("Ты атакуешь противника!");

                Scanner sc = new Scanner(System.in);
                System.out.println("Введи номер юнита, который будет атаковать:");
                int indexUnitsHuman = sc.nextInt();
                System.out.println("Введи номер юнита противника, который будет атакован:");
                int indexEnemy = sc.nextInt();

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

        checkWinner(human, ai);
    }

    private void printTeams(List<AbstractUnit> humanUnits, List<AbstractUnit> aiUnits) {
        int sizeOfString = 30;
        int sizeHumanUnits = humanUnits.size();
        int sizeAiUnits = aiUnits.size();
        int maxSize = Math.max(sizeHumanUnits, sizeAiUnits);

        System.out.println("\nты:                             противник:");
        System.out.println("__________________________________________");

        for (int i = 0; i < maxSize; i++) {
            StringBuilder humanUnitString;

            if (i <= sizeHumanUnits - 1) {

                humanUnitString = new StringBuilder(humanUnits.get(i).toString());
                while (humanUnitString.length() < sizeOfString) {
                    humanUnitString.append(" ");
                }

                System.out.print((i + 1) + "." + humanUnitString);
            } else {
                StringBuilder spaces = new StringBuilder(" ");
                while (spaces.length() < sizeOfString + 2) {
                    spaces.append(" ");
                }
                System.out.print(spaces);
            }
            if (i <= sizeAiUnits - 1) {
                System.out.println((i + 1) + "." + aiUnits.get(i));
            } else {
                System.out.println(

                );
            }

        }

        System.out.println("__________________________________________\n");

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
            return false;
        } else {
            return true;
        }
    }

    private void checkWinner(AbstractPlayer player1, AbstractPlayer player2) {
        String winner;
        if (player1.getUnits().isEmpty()) {
            winner = player2.getName();
        } else {
            winner = player1.getName();
        }

        System.out.println(winner + " победил!");
    }
}
