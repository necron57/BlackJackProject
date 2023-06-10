package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> handOcards = new ArrayList<>();

	public abstract int getHandValue();

	public void addCard(Card acard) {
		handOcards.add(acard);
	}

	public void clear() {
		handOcards.clear();
	}

	@Override
	public String toString() {
		return handOcards.toString();
	}
	
}
