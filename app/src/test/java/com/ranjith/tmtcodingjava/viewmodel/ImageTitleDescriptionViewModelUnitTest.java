package com.ranjith.tmtcodingjava.viewmodel;

import com.ranjith.tmtcodingjava.models.BaseAttribute;
import com.ranjith.tmtcodingjava.models.Card;
import com.ranjith.tmtcodingjava.models.Image;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageTitleDescriptionViewModelUnitTest {
    private ImageTitleDescriptionViewModel imageTitleDescriptionViewModel;
    private Card card;
    private BaseAttribute baseAttribute;
    private Image image;
    @Before
    public void setup(){
        card = new Card();
        baseAttribute = new BaseAttribute();
        image = new Image();
        imageTitleDescriptionViewModel = new ImageTitleDescriptionViewModel(card);
    }

    @Test
    public void imageTitleDescriptionViewModel_TitleNull() {
        assertEquals(null,imageTitleDescriptionViewModel.setTitle());
    }

    @Test
    public void imageTitleDescriptionViewModel_validTitle() {
        card.setTitle(baseAttribute);
        assertEquals(baseAttribute,imageTitleDescriptionViewModel.setTitle());
    }

    @Test
    public void imageTitleDescriptionViewModel_DescriptionNull() {
        assertEquals(null,imageTitleDescriptionViewModel.setDescription());
    }

    @Test
    public void imageTitleDescriptionViewModel_validDescription() {
        card.setDescription(baseAttribute);
        assertEquals(baseAttribute,imageTitleDescriptionViewModel.setDescription());
    }

    @Test
    public void imageTitleDescriptionViewModel_ImageUrlEmpty() {
        card.setImage(image);
        assertEquals(null,imageTitleDescriptionViewModel.getImageUrl());
    }

    @Test
    public void imageTitleDescriptionViewModel_validImageUrl() {
        String imageUrl = "valid_image_url";
        image.setUrl(imageUrl);
        card.setImage(image);
        assertEquals(imageUrl,imageTitleDescriptionViewModel.getImageUrl());
    }
}
