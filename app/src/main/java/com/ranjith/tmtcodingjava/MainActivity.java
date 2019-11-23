package com.ranjith.tmtcodingjava;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.ranjith.tmtcodingjava.entities.Home;
import com.ranjith.tmtcodingjava.models.Attributes;
import com.ranjith.tmtcodingjava.models.Cards;
import com.ranjith.tmtcodingjava.models.Card;
import com.ranjith.tmtcodingjava.models.Description;
import com.ranjith.tmtcodingjava.models.Font;
import com.ranjith.tmtcodingjava.models.Image;
import com.ranjith.tmtcodingjava.models.Size;
import com.ranjith.tmtcodingjava.models.Title;
import com.ranjith.tmtcodingjava.network.APIClient;
import com.ranjith.tmtcodingjava.network.APIInterface;
import com.ranjith.tmtcodingjava.viewadapter.HomeListAdapter;
import com.ranjith.tmtcodingjava.viewmodel.HomeViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private HomeViewModel mWordViewModel;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshHomeContent();
            }
        });

        mWordViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final HomeListAdapter adapter = new HomeListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWordViewModel.getAllWords().observe(this, new Observer<List<Home>>() {
            @Override
            public void onChanged(@Nullable final List<Home> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });
    }

    private void refreshHomeContent(){
        refreshAnimation(fab);
        /**
         GET List Resources
         **/
        Call<com.ranjith.tmtcodingjava.models.Home> call = APIClient.getClient().create(APIInterface.class).doGetListResources();
        call.enqueue(new Callback<com.ranjith.tmtcodingjava.models.Home>() {
            @Override
            public void onResponse(Call<com.ranjith.tmtcodingjava.models.Home> call, Response<com.ranjith.tmtcodingjava.models.Home> response) {

                com.ranjith.tmtcodingjava.models.Home resource = response.body();

                for(Cards card :resource.getPage().getCards()){
                    Gson gson = new Gson();
                    String json = gson.toJson(card);
                    Home word = new Home(json);
                    mWordViewModel.insert(word);
                }
                clearAnimation(fab);

            }

            @Override
            public void onFailure(Call<com.ranjith.tmtcodingjava.models.Home> call, Throwable t) {
                call.cancel();
                clearAnimation(fab);
            }
        });
    }


    private void refreshAnimation(FloatingActionButton fab){
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotate.setDuration(900);
        rotate.setRepeatCount(Animation.INFINITE);
        fab.startAnimation(rotate);
    }

    private void clearAnimation(FloatingActionButton fab){
        fab.clearAnimation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
