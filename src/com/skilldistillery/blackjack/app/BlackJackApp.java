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
		String userChoice;
		joe.loadDeck();
		System.out.println("Welcome to the local BlackJack table!\n");
		System.out.println("Would you like to sit and play a few hands? yes or no?");
		userChoice = sc.nextLine();
		if (userChoice.equalsIgnoreCase("yes")) {

			one = hit();
			two = hit();
			three = hit();
			four = hit();
			initialDeal();
			playerTurn();
			dealerTurn();
			displayWinner();
			System.out.println("\nWould you like to play again? yes or no?");
			userChoice = sc.nextLine();
			if (userChoice.equalsIgnoreCase("yes")) {
				brad.getHand().clear();
				joe.getHand().clear();
				run();
			} else if (userChoice.equalsIgnoreCase("no")) {
				System.out.println("GoodBye thanks for stoping by!");
			}
		} else if (userChoice.equalsIgnoreCase("no")) {
			System.out.println("GoodBye thanks for stoping by!");
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

	private void playerTurn() {
		System.out.println("Player has " + brad.getHand().getHandValue() + " in hand\n");
		do {
			if (brad.getHand().isBlackJack()) {
				System.out.println("Player has BlackJack! Cheating Dealer loses");
				break;
			}
			System.out.println("Would you like to Hit or Stay? ");
			String userInput = sc.nextLine();
			if (userInput.equalsIgnoreCase("Hit")) {
				Card newcard = hit();
				brad.addCardToHand(newcard);
				System.out.println("Player was hit with: " + newcard + "\n");
				System.out.println("Player has " + brad.getHand().getHandValue() + " in hand\n");
			} else if (userInput.equalsIgnoreCase("stay")) {
				System.out.println("Player has " + brad.getHand().getHandValue() + " in hand\n");
				break;
			}
		} while (brad.getHandValue() <= 21);
	}

	private void dealerTurn() {
		System.out.println("Cheating Dealers turn: ");
		System.out.println("Dealer flipped over: " + two + "\n");
		System.out.println("Dealer has " + joe.getHand().getHandValue() + " in hand\n");
		while (joe.getHandValue() < 17) {
			if (joe.getHandValue() == 21) {
				System.out.println("Dealer has BlackJack, Cheating Dealer wins all!");
				break;
			} else {
				Card newcard = hit();
				System.out.println("Dealer was hit with: " + newcard + "\n");
				joe.addCardToHand(newcard);
				System.out.println("Dealer has " + joe.getHand().getHandValue() + " in hand\n");
			}

		}

	}

	private void displayWinner() {
		do {

			if (joe.getHand().isBlackJack()) {
				System.out.println("Dealer has BlackJack, Cheating Dealer wins all!");
				break;
			}
			if (brad.getHand().isBlackJack()) {
				System.out.println("Player has BlackJack! Cheating Dealer loses");
				break;

			}
			if (brad.getHandValue() > joe.getHandValue() && !brad.getHand().isBust()) {
				System.out.println("Player wins, by getting " + brad.getHandValue()
						+ ", Cheating Dealer loses, by getting: " + joe.getHandValue());
				break;
			}
			if (joe.getHandValue() > brad.getHandValue() && !joe.getHand().isBust()) {
				System.out.println("Cheating Dealer wins, by getting " + joe.getHandValue()
						+ ", Player loses, by getting: " + brad.getHandValue());
				break;
			}
			if (joe.getHandValue() == brad.getHandValue() && !joe.getHand().isBust() && !brad.getHand().isBust()) {
				System.out.println(" Player pushed the Cheating Dealer ");
				break;
			}
			if (brad.getHandValue() > 21 && !joe.getHand().isBust()) {
				System.out.println("Cheating Dealer wins!" + " Player busts, by getting: " + brad.getHandValue());
				break;
			}
			if (joe.getHandValue() > 21 && !brad.getHand().isBust()) {
				System.out.println("Player wins!" + " Cheating Dealer busts, by getting: " + joe.getHandValue());
				break;
			}
			if (brad.getHand().isBust() && joe.getHand().isBust()) {
				System.out.println("Player and Dealer Busted");
				break;
			}

		} while (true);

	}

}
