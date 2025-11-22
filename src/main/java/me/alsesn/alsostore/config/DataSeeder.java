package me.alsesn.alsostore.config;

import lombok.RequiredArgsConstructor;
import me.alsesn.alsostore.entity.Category;
import me.alsesn.alsostore.entity.Product;
import me.alsesn.alsostore.repository.CategoryRepository;
import me.alsesn.alsostore.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() > 0) {
            System.out.println("Data already seeded. Skipping seeding");
            return;
        }

        // create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        // create Products
        Product phone = Product.builder()
                .name("SmartPhone")
                .description("Latest model smartphone with amazing features.")
                .imageUrl("https://placehold.co/600x400")
                .price(699.99)
                .category(electronics)
                .build();
        Product laptop = Product.builder()
                .name("Laptop")
                .description("High-performance laptop for work and play.")
                .imageUrl("https://placehold.co/600x400")
                .price(999.99)
                .category(electronics)
                .build();

        Product jacket = Product.builder()
                .name("Winter Jacket")
                .description("Warm and cozy jacket for winter.")
                .imageUrl("https://placehold.co/600x400")
                .price(129.99)
                .category(clothing)
                .build();

        Product blender = Product.builder()
                .name("Blender")
                .description("High-speed blender for smoothies and more.")
                .imageUrl("https://placehold.co/600x400")
                .price(21.99)
                .category(home)
                .build();

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));
    }
}