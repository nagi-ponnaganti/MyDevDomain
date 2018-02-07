package com.nagihome.samplewebapp.temp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(name="isbn")
    private String isbn;
    @Column(name="name")
    private String name;
    @Column(name="publishDate")
    private Date publishdate;
    @Column(name="price")
    private BigDecimal price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher")
    private Publisher publisher;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (publishdate != null ? !publishdate.equals(book.publishdate) : book.publishdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publishdate != null ? publishdate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}