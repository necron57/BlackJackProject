package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand hand = new BlackjackHand();

	public void addCardToHand(Card acard) {

		hand.addCard(acard);
	}

	public Hand getHand() {
		return hand;
	}

}
