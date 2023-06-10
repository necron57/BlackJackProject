package com.skilldistillery.blackjack.entities;

public class Player {
	protected BlackjackHand hand = new BlackjackHand();

	public void addCardToHand(Card acard) {

		hand.addCard(acard);
	}

	public BlackjackHand getHand() {
		return hand;
	}

}
