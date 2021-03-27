package com.kodilla.patterns2.adapter.bookclassifier;


import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {


    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclassifier.librarya.Book> bookSet) {
        Map<BookSignature, Book> books = new HashMap<>();
        String signature = "0000";
        int val = 1;
        for (com.kodilla.patterns2.adapter.bookclassifier.librarya.Book book : bookSet) {
            BookSignature bs = new BookSignature(signature.concat(String.valueOf(val)));
            books.put(bs, new Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
            val++;
            System.out.println(book);
        }
        return medianPublicationYear(books);
    }
}
