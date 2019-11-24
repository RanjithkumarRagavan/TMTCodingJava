package com.ranjith.tmtcodingjava.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ranjith.tmtcodingjava.dataaccess.HomeDao;
import com.ranjith.tmtcodingjava.database.HomeDatabase;
import com.ranjith.tmtcodingjava.entities.Home;

import java.util.List;

public class HomeRepository {

    private HomeDao homeDao;
    private LiveData<List<Home>> allCards;

    public HomeRepository(Application application) {
        HomeDatabase db = HomeDatabase.getDatabase(application);
        homeDao = db.wordDao();
        allCards = homeDao.getAllCards();
    }

    public LiveData<List<Home>> getAllCards() {
        return allCards;
    }

    public void insert (Home home) {
        new insertAsyncTask(homeDao).execute(home);
    }

    private static class insertAsyncTask extends AsyncTask<Home, Void, Void> {

        private HomeDao mAsyncTaskDao;

        insertAsyncTask(HomeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Home... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
