package WorkShopMongoDB.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import WorkShopMongoDB.domain.User;
import WorkShopMongoDB.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userBD;

	@Override
	public void run(String... args) throws Exception {
		userBD.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userBD.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
