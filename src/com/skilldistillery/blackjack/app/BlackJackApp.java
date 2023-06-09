package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private Dealer joe = new Dealer();
	private Player brad = new Player();
	Card one;
	Card two;
	Card three;
	Card four;
	Scanner sc = new Scanner(System.in);

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
		while (running) {
			int totalPlayerHand=brad.getHand().getHandValue();
			int totalDealerHand = joe.getHand().getHandValue();
			
//			hitOrStay(sc);
			if(totalPlayerHand == 21) {
				System.out.println("you won blackjack!");
				break;
			}else if(totalPlayerHand >21) {
				System.out.println("you lost sad panda");
				break;
			} else {
				hitOrStay(sc);
			}
			if(totalDealerHand == 21) {
				System.out.println("Dealer won blackjack!");
				break;
			}else if(totalDealerHand >21) {
				System.out.println("Dealer lost Hooray");
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

	public void hitOrStay(Scanner sc) {
		System.out.println("Would you like to Hit or Stay? ");
		String userInput = sc.next();
		if (userInput.equalsIgnoreCase("Hit")) {
			Card newcard = hit();
			brad.addCardToHand(newcard);
			System.out.println("Player was hit with: " + newcard + "\n");
			System.out.println("Player has " + brad.getHand().getHandValue() + " in hand\n");

		} else if (userInput.equalsIgnoreCase("stay")) {
			System.out.println("Dealer flipped over: " + two + "\n");
			Card newcard = hit();
			joe.addCardToHand(newcard);
			System.out.println("Dealer was hit with: " + newcard + "\n");
			System.out.println("Dealer has " + joe.getHand().getHandValue() + " card in hand\n");
		}
	}
}
