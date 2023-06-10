package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private Dealer joe = new Dealer();
	private Player brad = new Player();
	private Card one;
	private Card two;
	private Card three;
	private Card four;
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp bj = new BlackJackApp();
		bj.run();

	}

	public void run() {
		joe = new Dealer();
		brad = new Player();
		boolean running = true;
		joe.loadDeck();
		one = hit();
		two = hit();
		three = hit();
		four = hit();

		initialDeal();
		checkForBlackJack();
		while (running) {
			if (brad.getHand().isBlackJack() || joe.getHand().isBlackJack()) {
				displayWinner();
			} else {
				playerTurn();
				dealerTurn();
				displayWinner();
				break;

			}
		}
		sc.close();
	}

	public Card hit() {
		return joe.dealCard();
	}

	public void initialDeal() {
		brad.addCardToHand(one);
		joe.addCardToHand(two);
		brad.addCardToHand(three);
		joe.addCardToHand(four);
		System.out.println("Player got delt: " + one + "\n");
		System.out.println("Dealer got delt: " + "\n");
		System.out.println("Player got delt: " + three + "\n");
		System.out.println("Dealer got delt: " + four + "\n");
	}

	public void checkForBlackJack() {
		if (brad.getHand().isBlackJack()) {
			System.out.println("you won blackjack!");
		} else if (brad.getHand().isBust()) {
			System.out.println("you lost sad panda");
		} else if (joe.getHand().isBlackJack()) {
			System.out.println("Dealer won blackjack!");
		} else if (joe.getHand().isBust()) {
			System.out.println("Dealer lost Hooray");
		}
	}

	private void playerTurn() {
		hitOrStay(sc);
	}

	private void dealerTurn() {
		int totalDealerHand = joe.getHand().getHandValue();
		boolean run = true;
		while (run) {
			if (totalDealerHand < 17 && totalDealerHand != 21) {
				System.out.println("Dealer flipped over: " + two + "\n");
				Card newcard = hit();
				System.out.println("Dealer was hit with: " + newcard + "\n");
				joe.addCardToHand(newcard);
				System.out.println("Dealer has " + joe.getHand().getHandValue() + " in hand\n");
				
				run = false;
			} else if (totalDealerHand > 17) {

				displayWinner();
				run = false;
			}
		}

	}

	private void displayWinner() {
		int totalDealerHand = joe.getHand().getHandValue();
		int totalPlayerHand = brad.getHand().getHandValue();
		if (totalDealerHand > totalPlayerHand && totalDealerHand < 21) {
			System.out.println("Dealer won");
		} else if (totalPlayerHand > totalDealerHand && totalPlayerHand < 21) {
			System.out.println("Player won");
		}

	}

	public void hitOrStay(Scanner sc) {
		System.out.println("Would you like to Hit or Stay? ");
		String userInput = sc.next();
		if (userInput.equalsIgnoreCase("Hit")) {
			Card newcard = hit();
			brad.addCardToHand(newcard);
			System.out.println("Player was hit with: " + newcard + "\n");
			System.out.println("Player has " + brad.getHand().getHandValue() + " in hand\n");

		} else if (userInput.equalsIgnoreCase("stay")) {
			System.out.println("Player has " + brad.getHand().getHandValue() + " in hand\n");
			System.out.println("Dealer flipped over: " + two + "\n");
			System.out.println("Dealer has " + joe.getHand().getHandValue() + " in hand\n");

		}
	}
}
