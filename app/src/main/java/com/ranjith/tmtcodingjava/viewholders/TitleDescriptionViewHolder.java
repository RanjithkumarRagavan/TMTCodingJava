package com.ranjith.tmtcodingjava.viewholders;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.ranjith.tmtcodingjava.viewmodel.TitleDescriptionViewModel;


public class TitleDescriptionViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding mDataBinding;

    public TitleDescriptionViewHolder(View v) {
        super(v);
        this.mDataBinding = DataBindingUtil.bind(v);
    }

    public void bind(TitleDescriptionViewModel textViewModel) {
        mDataBinding.setVariable(com.ranjith.tmtcodingjava.BR.viewModel, textViewModel);
        mDataBinding.executePendingBindings();
    }
    public ViewDataBinding getDataBinding() {
        return mDataBinding;
    }
}