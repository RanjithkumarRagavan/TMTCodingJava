package com.ranjith.tmtcodingjava.viewmodel;


import androidx.databinding.BaseObservable;

import com.ranjith.tmtcodingjava.models.Card;
import com.ranjith.tmtcodingjava.models.Description;
import com.ranjith.tmtcodingjava.models.Title;

public class TitleDescriptionViewModel extends BaseObservable {
    private Card card;
    public TitleDescriptionViewModel(Card card){
        this.card = card;
    }

    public Title setTitle() {
        return this.card.getTitle();
    }

    public Description setDescription() {
        return this.card.getDescription();
    }
}
