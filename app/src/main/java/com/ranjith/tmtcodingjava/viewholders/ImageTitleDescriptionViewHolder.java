package com.ranjith.tmtcodingjava.viewholders;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.ranjith.tmtcodingjava.viewmodel.ImageTitleDescriptionViewModel;
import com.ranjith.tmtcodingjava.viewmodel.TitleDescriptionViewModel;

public class ImageTitleDescriptionViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding mDataBinding;

    public ImageTitleDescriptionViewHolder(View v) {
        super(v);
        this.mDataBinding = DataBindingUtil.bind(v);
    }

    public void bind(ImageTitleDescriptionViewModel textViewModel) {
        mDataBinding.setVariable(com.ranjith.tmtcodingjava.BR.viewModel, textViewModel);
        mDataBinding.executePendingBindings();
    }
    public ViewDataBinding getDataBinding() {
        return mDataBinding;
    }
}