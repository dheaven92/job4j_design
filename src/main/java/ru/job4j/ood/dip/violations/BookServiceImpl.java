package ru.job4j.ood.dip.violations;

public class BookServiceImpl implements BookService {

    private final SmartPublisher smartPublisher;

    public BookServiceImpl(SmartPublisher smartPublisher) {
        this.smartPublisher = smartPublisher;
    }

    @Override
    public Book publishBook(IsbnGenerator isbnGenerator) {
        Book book = null;
        try {
            System.out.println("generating ISBN code and publishing book");
        } catch (Exception e) {
            System.out.println("Error generating ISBN with IsbnGenerator");
        }
        return book;
    }
}
