package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deckOCards = new ArrayList<>();

	public Deck() {
		deckOCards = createDaDeck();
	}

	public List<Card> createDaDeck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for (Rank rank : ranks) {
			for (Suit suit : suits) {
				deckOCards.add(new Card(rank, suit));
			}
		}
		return deckOCards;
	}

	public int checkDeckSize() {
		return deckOCards.size();

	}

	public Card dealCard() {
		Card isThisYourCard = null;
		isThisYourCard = deckOCards.remove(0);
		return isThisYourCard;

	}

	public void shuffle() {
		Collections.shuffle(deckOCards);
	}

	

}
