package com.ranjith.tmtcodingjava.viewmodel;

import androidx.databinding.BaseObservable;

import com.ranjith.tmtcodingjava.models.Card;
import com.ranjith.tmtcodingjava.models.Description;
import com.ranjith.tmtcodingjava.models.Title;

public class ImageTitleDescriptionViewModel extends BaseObservable {
    private Card card;
    public ImageTitleDescriptionViewModel(Card card){
        this.card = card;
    }

    public Title setTitle() {
        return this.card.getTitle();
    }

    public String getImageUrl(){
        return this.card.getImage().getUrl();
    }

    public Description setDescription() {
        return this.card.getDescription();
    }
}
