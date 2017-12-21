package com.example.sugarorm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sugarorm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nguyenvanlinh on 12/21/17.
 */

public class BookHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_book_name)
    TextView tvBookName;
    @BindView(R.id.tv_book_description)
    TextView tvBookDescription;
    public BookHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
