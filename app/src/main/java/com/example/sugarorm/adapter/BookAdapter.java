package com.example.sugarorm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sugarorm.R;
import com.example.sugarorm.model.Book;

import java.util.List;

/**
 * Created by nguyenvanlinh on 12/21/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookHolder> {
    private List<Book> listBook;
    private ClickItemBookListener  itemBookListener;

    public BookAdapter(List<Book> listBook, ClickItemBookListener itemBookListener) {
        this.listBook = listBook;
        this.itemBookListener = itemBookListener;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_book,parent,false));
    }

    @Override
    public void onBindViewHolder(final BookHolder holder, int position) {
        final Book book = listBook.get(position);
        holder.tvBookName.setText(book.getNameBook());
        holder.tvBookDescription.setText(book.getDecriptionBook());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemBookListener.handlerClick(book.getId());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                itemBookListener.handlerLongClick(holder.getAdapterPosition(),book.getId());
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public interface ClickItemBookListener{
        void handlerClick(long idBook);
        void handlerLongClick(int position,long idBook);
    }
}
