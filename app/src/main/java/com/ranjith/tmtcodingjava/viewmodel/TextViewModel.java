package com.ranjith.tmtcodingjava.viewmodel;


import com.ranjith.tmtcodingjava.models.Card;

public class TextViewModel {

    private Card card;
    public TextViewModel(Card card){
        this.card = card;
    }

    public Card setCard() {
        return this.card;
    }
}
