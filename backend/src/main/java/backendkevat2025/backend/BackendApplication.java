package backendkevat2025.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@SpringBootApplication
@ComponentScan({"com.example.Bookstore.web", "com.example.Bookstore.controller", "backendkevat2025.backend"})
@EntityScan("com.example.Bookstore.model")
@EnableJpaRepositories("com.example.Bookstore.model")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			// Create categories
			Category fiction = new Category("Fiction");
			Category nonFiction = new Category("Non-Fiction");
			Category history = new Category("History");
			
			categoryRepository.save(fiction);
			categoryRepository.save(nonFiction);
			categoryRepository.save(history);
			
			// Create books with categories
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "1232323-21", 1929, fiction));
			repository.save(new Book("Animal Farm", "George Orwell", "2212343-5", 1945, fiction));
		};
	}
}
