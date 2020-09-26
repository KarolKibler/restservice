
package pl.coderslab.rest.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

public class Book {
  private  long id;
  private String isbn;
  private String title;
  private String author;
  private String publisher;
  private String type;

  public Book() {
  }

  public Book(long id, String isbn, String title, String author, String publisher, String type) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.type = type;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
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

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString(){
    return "ID: " + id 
        + " First: " + isbn
        + " Last: " + title + "\n"
        + "author: " + author + "\n"
        + "publisher: " + publisher
        + " type: " + type;
  }  
  
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Book that = (Book) o;
      return id == that.id;
    }

    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
  }

