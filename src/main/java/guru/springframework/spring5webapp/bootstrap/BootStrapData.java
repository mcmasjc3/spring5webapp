package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Started in Bootstrap");
    Author eric = new Author("Eric", "Evans");
    authorRepository.save(eric);

    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    bookRepository.save(ddd);
    authorRepository.save(eric);

    Author rod = new Author("Rod", "Johnson");
    authorRepository.save(rod);

    Book noEjb = new Book("J2EE Development Without EJB", "3939459459");
    rod.getBooks().add(noEjb);
    noEjb.getAuthors().add(rod);

    bookRepository.save(noEjb);
    authorRepository.save(rod);
    System.out.println("Number of Books: " + bookRepository.count());

    Publisher publisher =
        new Publisher()
            .setName("SFG Publishing")
            .setAddressLine1("addressLine1")
            .setCity("city")
            .setState("state")
            .setZip("zip");
    publisherRepository.save(publisher);

    ddd.setPublisher(publisher);
    bookRepository.save(ddd);
    noEjb.setPublisher(publisher);
    bookRepository.save(noEjb);

    publisher.getBooks().add(ddd);
    publisher.getBooks().add(noEjb);
    publisherRepository.save(publisher);

    System.out.println("Number of Publishers: " + publisherRepository.count());
    System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
  }
}
