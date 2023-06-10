package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	@Override
	public int getHandValue() {
		int totalHandValue = 0;
		for (Card card : handOcards) {
			totalHandValue += card.getValue();
		}

		return totalHandValue;
	}
	
	public boolean isBlackJack() {
		boolean blackJack = getHandValue() == 21;
		return blackJack;
	}

	public boolean isBust() {
		boolean bust = getHandValue() > 21;
		return bust;
	}

}
