package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		deck = new Deck();

	}

	public void loadDeck() {
		deck.createDaDeck();
		deck.shuffle();

	}

	public Card dealCard() {
		return deck.dealCard();
	}

}
