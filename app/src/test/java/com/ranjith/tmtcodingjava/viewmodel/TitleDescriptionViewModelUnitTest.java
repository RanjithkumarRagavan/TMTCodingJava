package com.ranjith.tmtcodingjava.viewmodel;

import com.ranjith.tmtcodingjava.models.BaseAttribute;
import com.ranjith.tmtcodingjava.models.Card;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TitleDescriptionViewModelUnitTest {
    private TitleDescriptionViewModel titleDescriptionViewModel;
    private Card card;
    private BaseAttribute baseAttribute;
    @Before
    public void setup(){
        card = new Card();
        baseAttribute = new BaseAttribute();
        titleDescriptionViewModel = new TitleDescriptionViewModel(card);
    }

    @Test
    public void titleDescriptionViewModel_TitleNull() {
        assertEquals(null,titleDescriptionViewModel.setTitle());
    }

    @Test
    public void titleDescriptionViewModel_validTitle() {
        card.setTitle(baseAttribute);
        assertEquals(baseAttribute,titleDescriptionViewModel.setTitle());
    }

    @Test
    public void titleDescriptionViewModel_DescriptionNull() {
        assertEquals(null,titleDescriptionViewModel.setDescription());
    }

    @Test
    public void titleDescriptionViewModel_validDescription() {
        card.setDescription(baseAttribute);
        assertEquals(baseAttribute,titleDescriptionViewModel.setDescription());
    }
}
