package com.ranjith.tmtcodingjava.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ranjith.tmtcodingjava.entities.Home;
import com.ranjith.tmtcodingjava.repository.HomeRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private HomeRepository mRepository;

    private LiveData<List<Home>> allCards;

    public HomeViewModel (Application application) {
        super(application);
        mRepository = new HomeRepository(application);
        allCards = mRepository.getAllCards();
    }

    public LiveData<List<Home>> getAllCards() { return allCards; }

    public void insert(Home word) { mRepository.insert(word); }
}
