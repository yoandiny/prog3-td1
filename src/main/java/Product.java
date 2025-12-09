import java.time.Instant;

public class Product {
    private int id;
    private String name;
    private Instant creationDatetime;
    private Category Category;

    public Product(int id, String name, Instant creationDatetime, Category category) {
        this.id = id;
        this.name = name;
        this.creationDatetime = creationDatetime;
        Category = category;
    }

    public String getCategoryName() {
        return Category.getName();
    }
}
