package com.ranjith.tmtcodingjava.viewmodel;


import androidx.databinding.BaseObservable;

import com.ranjith.tmtcodingjava.models.BaseAttribute;
import com.ranjith.tmtcodingjava.models.Card;

public class TitleDescriptionViewModel extends BaseObservable {
    private Card card;
    public TitleDescriptionViewModel(Card card){
        this.card = card;
    }

    public BaseAttribute setTitle() {
        return this.card.getTitle();
    }

    public BaseAttribute setDescription() {
        return this.card.getDescription();
    }
}
