package com.ranjith.tmtcodingjava.viewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.ranjith.tmtcodingjava.R;
import com.ranjith.tmtcodingjava.entities.Home;
import com.ranjith.tmtcodingjava.models.Cards;
import com.ranjith.tmtcodingjava.viewholders.ImageTitleDescriptionViewHolder;
import com.ranjith.tmtcodingjava.viewholders.TextViewHolder;
import com.ranjith.tmtcodingjava.viewholders.TitleDescriptionViewHolder;
import com.ranjith.tmtcodingjava.viewmodel.ImageTitleDescriptionViewModel;
import com.ranjith.tmtcodingjava.viewmodel.TextViewModel;
import com.ranjith.tmtcodingjava.viewmodel.TitleDescriptionViewModel;

import java.util.List;

public class HomeListAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<Home> mWords; // Cached copy of words

    private final int ViewType_Text = 1;
    private final int ViewType_TitleDescription =  2;
    private final int ViewType_ImageTitleDescription = 3;

    private final String Text = "text";
    private final String TitleDescription =  "title_description";
    private final String ImageTitleDescription = "image_title_description";

    public HomeListAdapter(Context context) { mInflater = LayoutInflater.from(context); }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View moduleView;
        switch (viewType) {
            case ViewType_TitleDescription:
                moduleView  = inflater.inflate(R.layout.title_description, parent, false);
                viewHolder = new TitleDescriptionViewHolder(moduleView);
                break;
            case ViewType_ImageTitleDescription:
                moduleView = inflater.inflate(R.layout.image_title_description, parent, false);
                viewHolder = new ImageTitleDescriptionViewHolder(moduleView);
                break;
            default:
                moduleView = inflater.inflate(R.layout.text_view, parent, false);
                viewHolder = new TextViewHolder(moduleView);
                break;
        }

        return  viewHolder;
    }


    @Override
    public int getItemViewType(int position) {
        if (mWords != null) {
            Home current = mWords.get(position);
            Gson gson = new Gson();
            Cards cards = gson.fromJson(current.getHome(), Cards.class);
            if (cards.getCardType().equalsIgnoreCase(Text)) {
                return ViewType_Text;
            } else if (cards.getCardType().equalsIgnoreCase(TitleDescription)) {
                return ViewType_TitleDescription;
            } else if (cards.getCardType().equalsIgnoreCase(ImageTitleDescription)) {
                return ViewType_ImageTitleDescription;
            }
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mWords != null) {
            Home current = mWords.get(position);
            Gson gson = new Gson();
            Cards cards = gson.fromJson(current.getHome(), Cards.class);
            switch (holder.getItemViewType()) {
                case ViewType_TitleDescription:
                    TitleDescriptionViewHolder titleDescriptionViewHolder = (TitleDescriptionViewHolder) holder;
                    TitleDescriptionViewModel titleDescriptionViewModel = new TitleDescriptionViewModel(cards.getCard());
                    titleDescriptionViewHolder.bind(titleDescriptionViewModel);
                    break;
                case ViewType_ImageTitleDescription:
                    ImageTitleDescriptionViewHolder imageTitleDescriptionViewHolder = (ImageTitleDescriptionViewHolder) holder;
                    ImageTitleDescriptionViewModel titleDescriptionViewModel1 = new ImageTitleDescriptionViewModel(cards.getCard());
                    imageTitleDescriptionViewHolder.bind(titleDescriptionViewModel1);
                    break;
                default:
                    TextViewHolder textViewHolder = (TextViewHolder) holder;
                    TextViewModel textViewModel = new TextViewModel(cards.getCard());
                    textViewHolder.bind(textViewModel);
                    break;
            }

        }
    }

   public void setWords(List<Home> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

}
