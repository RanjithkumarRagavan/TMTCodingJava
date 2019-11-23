package com.ranjith.tmtcodingjava.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ranjith.tmtcodingjava.dataaccess.HomeDao;
import com.ranjith.tmtcodingjava.database.HomeDatabase;
import com.ranjith.tmtcodingjava.entities.Home;

import java.util.List;

public class HomeRepository {

    private HomeDao mWordDao;
    private LiveData<List<Home>> mAllWords;

    public HomeRepository(Application application) {
        HomeDatabase db = HomeDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Home>> getAllWords() {
        return mAllWords;
    }

    public void insert (Home word) {
        new insertAsyncTask(mWordDao).execute(word);
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
