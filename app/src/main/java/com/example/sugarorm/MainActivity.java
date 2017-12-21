package com.example.sugarorm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.sugarorm.adapter.BookAdapter;
import com.example.sugarorm.model.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


// DOCUMENT: https://github.com/chennaione/sugar
public class MainActivity extends AppCompatActivity implements BookAdapter.ClickItemBookListener{
    @BindView(R.id.rcv_list_book)
    RecyclerView rcvListBook;
    @BindView(R.id.edt_book_name)
    EditText edtBookName;
    @BindView(R.id.edt_book_desciption)
    EditText edtBookDesciption;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private BookAdapter bookAdapter;
    private List<Book> listBook = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rcvListBook.setLayoutManager(linearLayoutManager);
        rcvListBook.setHasFixedSize(true);
        getDataSource();
        bookAdapter = new BookAdapter(listBook, this);
        rcvListBook.setAdapter(bookAdapter);

    }

    private void getDataSource() {
        listBook = Book.listAll(Book.class);
    }

    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        Book book = new Book();
        book.setNameBook(edtBookName.getText().toString());
        book.setDecriptionBook(edtBookDesciption.getText().toString());
        book.save();
        listBook.add(Book.findById(Book.class,Book.count(Book.class)));
        bookAdapter.notifyDataSetChanged();

    }

    @Override
    public void handlerClick(long idBook) {
        Book book = Book.findById(Book.class,idBook);
        edtBookName.setText(book.getNameBook());
        edtBookDesciption.setText(book.getDecriptionBook());
    }

    @Override
    public void handlerLongClick(final int position, final long idBook) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remove")
                .setMessage("Remove Book: " + idBook)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Book book = Book.findById(Book.class, idBook);
                        if (book != null) {
                            book.delete();
                            listBook.remove(position);
                            bookAdapter.notifyDataSetChanged();
                        }
                    }
                })
                .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                    }
                });
        builder.create().show();

    }
}
