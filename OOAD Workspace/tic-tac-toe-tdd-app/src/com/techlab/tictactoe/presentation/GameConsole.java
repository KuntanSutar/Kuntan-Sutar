package com.techlab.tictactoe.presentation;

import java.util.Scanner;

import com.techlab.tictactoe.Game;
import com.techlab.tictactoe.GameState;
import com.techlab.tictactoe.Player;
import com.techlab.tictactoe.ResultAnalyser;

public class GameConsole {

	public static void main(String[] args) {

		int cellNumber;
		String playerName1, playerName2;
		Display display = new Display();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st Player Name : ");
		playerName1 = sc.nextLine();
		Player player1 = new Player();
		player1.setPlayerName(playerName1);

		System.out.println("Enter 2nd Player Name : ");
		playerName2 = sc.nextLine();
		Player player2 = new Player();
		player2.setPlayerName(playerName2);

		ResultAnalyser resultanalyser = new ResultAnalyser();
		Game game = new Game(player1, player2, resultanalyser);

		while (!game.board.isBoardFull()) {
			
			if (resultanalyser.hasWon(game) == GameState.WON) {
				System.out.println(
						"Game finished!!!" + " Congrats " + game.switchPlayer().getPlayerName() + " You Won!!!");
				System.exit(0);
			}
			
			System.out.print(game.getCurrentPlayer().getPlayerName()+ " enter your cell number : ");
			cellNumber = sc.nextInt();
				
			if (cellNumber >= 0 & cellNumber <= 8) {
				System.out.println(game.getCurrentPlayer().getPlayerName() + "'s turn, " + "He choosed cell number "
						+ (cellNumber + 1) + ". Current Game Status : " + game.play(cellNumber));
				System.out.println(display.printGrid(game.board));
			}
			
			else {
				System.out.println("Invalid cell number!");
			}
		}
	}

}
