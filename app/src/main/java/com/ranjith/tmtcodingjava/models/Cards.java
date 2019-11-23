
package com.ranjith.tmtcodingjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cards {

    @SerializedName("card_type")
    @Expose
    private String cardType;
    @SerializedName("card")
    @Expose
    private Card card;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
