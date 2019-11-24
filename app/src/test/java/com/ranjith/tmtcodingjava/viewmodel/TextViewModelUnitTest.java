package com.ranjith.tmtcodingjava.viewmodel;

import com.ranjith.tmtcodingjava.models.Card;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TextViewModelUnitTest {
    private TextViewModel textViewModel;
    private TextViewModel textViewModelNull;
    private Card card;
    @Before
    public void setup(){
        card = new Card();
        textViewModel = new TextViewModel(card);
        textViewModelNull = new TextViewModel(null);
    }

    @Test
    public void textViewModel_validCard() {
        assertEquals(card,textViewModel.setCard());
    }

    @Test
    public void textViewModel_invalidCard() {
        assertNotEquals(card,textViewModelNull.setCard());
    }
}