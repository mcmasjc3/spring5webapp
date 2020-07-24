package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String addressLine1;
  private String city;
  private String state;
  private String zip;

  @OneToMany
  @JoinColumn(name = "publisher_id")
  private Set<Book> books = new HashSet<>();

  public Publisher() {}

  public Long getId() {
    return id;
  }

  public Publisher setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Publisher setName(String name) {
    this.name = name;
    return this;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public Publisher setAddressLine1(String address) {
    this.addressLine1 = address;
    return this;
  }

  public String getCity() {
    return city;
  }

  public Publisher setCity(String city) {
    this.city = city;
    return this;
  }

  public String getState() {
    return state;
  }

  public Publisher setState(String state) {
    this.state = state;
    return this;
  }

  public String getZip() {
    return zip;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  public Publisher setZip(String zip) {
    this.zip = zip;
    return this;
  }

  @Override
  public String toString() {
    return "Publisher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", address='" + addressLine1 + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Publisher publisher = (Publisher) o;

    return Objects.equals(id, publisher.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
