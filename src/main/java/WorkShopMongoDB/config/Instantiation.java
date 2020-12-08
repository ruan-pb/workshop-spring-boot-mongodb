package WorkShopMongoDB.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import WorkShopMongoDB.domain.Post;
import WorkShopMongoDB.domain.User;
import WorkShopMongoDB.repositories.PostRepository;
import WorkShopMongoDB.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userBD;
	
	@Autowired
	private PostRepository postBD;
	
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userBD.deleteAll();
		postBD.deleteAll();
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para são paulo. Abraço",maria);
		
		Post post2 = new Post(null,sdf.parse("23/03/2018"), "Bom Dia", "Acordei feliz hoje",maria);
		
		userBD.saveAll(Arrays.asList(maria,alex,bob));
		postBD.saveAll(Arrays.asList(post1,post2));
		
	}

}
