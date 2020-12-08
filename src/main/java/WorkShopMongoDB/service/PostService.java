package WorkShopMongoDB.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkShopMongoDB.domain.Post;
import WorkShopMongoDB.repositories.PostRepository;
import WorkShopMongoDB.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;


	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text,Date minDate,Date maxDate){
		maxDate = new Date(maxDate.getTime()+24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}

}