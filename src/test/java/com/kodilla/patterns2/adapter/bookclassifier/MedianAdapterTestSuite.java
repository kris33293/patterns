package com.kodilla.patterns2.adapter.bookclassifier;



import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {

        //Given
        Book book = new Book("autor1","tytul1",1958,"001");
        Book book1 = new Book("autor2","tytul2",1988, "002");
        Book book2 = new Book("autor3","tytul3",1978,"003");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book);
        bookSet.add(book1);
        bookSet.add(book2);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(median);
        assertEquals(1978, median);

    }
}
