package com.skilldistillery.blackjack.testing;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class TestTheDeck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for each of the 52 cards in your deck,
		// display each card.
		TestTheDeck app = new TestTheDeck();
		app.run();

	}

	public void run() {
		Deck testdeck = new Deck();
		System.out.println(testdeck.checkDeckSize());
		final int initialDeckSize = testdeck.checkDeckSize();
		for (int cardNum = 0; cardNum < initialDeckSize; cardNum++) {
			Card card = testdeck.dealCard();
			System.out.println(card);
		}
	}

}
