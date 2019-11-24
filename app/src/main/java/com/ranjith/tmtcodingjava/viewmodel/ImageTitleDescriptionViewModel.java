package com.ranjith.tmtcodingjava.viewmodel;

import androidx.databinding.BaseObservable;

import com.ranjith.tmtcodingjava.models.BaseAttribute;
import com.ranjith.tmtcodingjava.models.Card;

public class ImageTitleDescriptionViewModel extends BaseObservable {
    private Card card;
    public ImageTitleDescriptionViewModel(Card card){
        this.card = card;
    }

    public BaseAttribute setTitle() {
        return this.card.getTitle();
    }

    public String getImageUrl(){
        return this.card.getImage().getUrl();
    }

    public BaseAttribute setDescription() {
        return this.card.getDescription();
    }
}
