package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	private final String suit;

	Suit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return this.suit;
	}

}
