package com.ranjith.tmtcodingjava.viewholders;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.ranjith.tmtcodingjava.viewmodel.TextViewModel;

public class TextViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding mDataBinding;

    public TextViewHolder(View v) {
        super(v);
        this.mDataBinding = DataBindingUtil.bind(v);
    }

    public void bind(TextViewModel textViewModel) {
        mDataBinding.setVariable(com.ranjith.tmtcodingjava.BR.viewModel, textViewModel);
        mDataBinding.executePendingBindings();
    }
    public ViewDataBinding getDataBinding() {
        return mDataBinding;
    }
}
