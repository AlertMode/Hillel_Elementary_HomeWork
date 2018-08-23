package edu.palmirov.hillel.special_task_1_with_jcf;

import edu.palmirov.hillel.special_task_1.Actors.Banker;
import edu.palmirov.hillel.special_task_1.Actors.Player;

/*
 * Special Task - “BlackJack” (*)
 *
 * Проработать систему классов и их отношения между собою для карточный игры BlackJack.
 * Продумать архитектуру приложения и основной игровой процесс.
 * Сделать наброски основных возможных методов.
 *
 * Основные правила и ограничения:
 * Делаем игру из расчета на двух игроков.
 *
 * Кол-во карт - 32 (от 7 до Туза и 4 масти для каждой из мастей).
 * 7 - семь;
 * ….
 * 10 - десять;
 * Валет - 2;
 *
 * Дама - 3;
 * Король - 4;
 * Туз - 11;
 *
 * Каждый из игроков разыгрывает свою партию по очереди:
 * Первый игрок последовательно берет из колоды карты никому не показывая их,
 * кроме себя, пока не скажет “стоп”.
 * Затем право разыграть свою партию переходит 2-му игроку,
 * который также последовательно берет карты из колоды никому другим не показывая их, пока также не скажет “стоп”.
 * Затем игроки вскрываются (показывают свои карты).
 * Цель игры: Набрать карты таким образом, чтобы суммарное кол-во очков было как можно ближе к чилу 21.
 * Выигрывает тот кто ближе всего к цели или набрал ровно 21.
 *
 * Возможные варианты развития:
 * Player1 - 17 очков;
 * Player2 - 19 очков;
 * Победил Player2, т.к его результат ближе к 21.
 * 2) Player1 - 21 очков
 * Player2 - 21 очков
 * Ничья.  (В случае ничейного результата раунд игры переигрывается).
 * 3) Player1 - 21 очков;
 * Player2 - 20 очков;
 * Победил Player1, т.к он набрал 21.
 * 4) Player1 - 27 очков;
 * Player2 - 23 очков;
 * Победил Player2, т.к он оказался ближе к 21.
 *
 * Игра длится 10 раундов. Побеждает тот игрок, кто выиграл большее кол-во раундов.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Task 25
 *
 * Note: Для тех кто реализовал задачу *BlackJack.
 * Заменить реализацию массивов на классы коллекции Java Collection Framework (там где уместно).
*/

public class Start {

    private int player1WonRounds = 0;
    private int player2WonRounds = 0;

    public static void main(String[] args){
        Start start = new Start();
        Banker banker = new Banker("Tommy Vercetti");
        Player player1 = new Player("Carl Johnson");
        Player player2 = new Player("Niko Bellic");

        int totalRounds = 1;
        int i = 0;
        while (i < 10) {
            banker.shuffleDeck();

            System.out.println("Round #" + totalRounds++ + "\n" + "==========");

           do{
                player1.takeCard(banker.giveCard());
            } while(player1.getRoundScores() < 17);

            do{
                player2.takeCard(banker.giveCard());
            }while(player2.getRoundScores() < 17);

            System.out.println(player1.getName() + " cards:\n" + player1.showCards() + "\n"
                    + player2.getName() + " cards:\n" + player2.showCards());
            if(start.roundEnds(player1, player2)){ ++i; };
            player1.resetCards();
            player2.resetCards();
            banker.resetDeck();
        }
        start.winnerSelector(player1, player2);
    }

    public void winnerSelector(Player player1, Player player2){
        if(player1WonRounds > player2WonRounds){
            System.out.println("The final winner is: " + player1.getName()
                    + "\n" + player1WonRounds + " rounds have been won.");
        } else {
            System.out.println("The final winner is: " + player2.getName()
                    + "\n" + player2WonRounds + " rounds have been won.\n");
        }
    }

    public boolean roundEnds(Player player1, Player player2){
        boolean result;
        if(Math.abs(player1.getRoundScores() - 21) < Math.abs(player2.getRoundScores() - 21)){
            System.out.println(player1.getName() + " has won!");
            ++player1WonRounds;
            result = true;
        } else if (Math.abs(player1.getRoundScores() - 21) > Math.abs(player2.getRoundScores() - 21)) {
            System.out.println(player2.getName() + " has won!");
            ++player2WonRounds;
            result = true;
        } else {
            System.out.println("Draft!");
            result = false;
        }
        System.out.println("-------------------------------------------------\n");
        return result;
    }
}