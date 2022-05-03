package consolGame.utils;

import consolGame.players.AbstractPlayer;
import consolGame.units.AbstractUnit;

import java.util.List;
import java.util.Scanner;

public class Interface {

    private final Scanner scanner = new Scanner(System.in);

    public void printTeams(List<AbstractUnit> humanUnits, List<AbstractUnit> aiUnits) {
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

    public int getIntFromScanner(int size) {
        int number = 0;
        while (number <= 0 || number > size) {
            while (!scanner.hasNextInt()) {
                System.out.println("Введенно неправильное число, введите число больше нуля");
                scanner.next();
            }
            number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Данное число неверное, введите число больше нуля");
            } else if (number > size) {
                System.out.println("Слишком больше число, введите еще раз");
            }
        }


        return number;
    }

    public void checkWinner(AbstractPlayer player1, AbstractPlayer player2) {
        String winner;
        if (player1.getUnits().isEmpty()) {
            winner = player2.getName();
        } else {
            winner = player1.getName();
        }

        System.out.println(winner + " победил!");
    }
}
