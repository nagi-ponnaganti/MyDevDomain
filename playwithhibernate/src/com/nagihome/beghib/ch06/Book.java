package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
@AttributeOverrides({@AttributeOverride(name = "ebookPublisher.name", column = @Column(name = "ebookPublisherName")),
        @AttributeOverride(name = "ebookPublisher.location.country", column = @Column(name = "ebookPublisherLocationCountry")),
        @AttributeOverride(name = "ebookPublisher.location.city", column = @Column(name = "ebookPublisherLocationCity")),
        @AttributeOverride(name = "paperBackPublisher.name", column = @Column(name = "paperBackPublisherName")),
        @AttributeOverride(name = "paperBackPublisher.location.country", column = @Column(name = "paperBackPublisherLocationCountry")),
        @AttributeOverride(name = "paperBackPublisher.location.city", column = @Column(name = "paperBackPublisherLocationCity"))})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private Publisher ebookPublisher;
    private Publisher paperBackPublisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getEbookPublisher() {
        return ebookPublisher;
    }

    public void setEbookPublisher(Publisher ebookPublisher) {
        this.ebookPublisher = ebookPublisher;
    }

    public Publisher getPaperBackPublisher() {
        return paperBackPublisher;
    }

    public void setPaperBackPublisher(Publisher paperBackPublisher) {
        this.paperBackPublisher = paperBackPublisher;
    }
}
