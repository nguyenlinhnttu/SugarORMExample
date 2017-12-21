package com.example.sugarorm.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

/**
 * Created by nguyenvanlinh on 12/21/17.
 */
@Table
public class Book  extends SugarRecord {

    private String nameBook;
    private String decriptionBook;

    public Book() {
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getDecriptionBook() {
        return decriptionBook;
    }

    public void setDecriptionBook(String decriptionBook) {
        this.decriptionBook = decriptionBook;
    }

}
