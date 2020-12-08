package WorkShopMongoDB.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import WorkShopMongoDB.domain.Post;
import WorkShopMongoDB.resource.util.URL;
import WorkShopMongoDB.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post user = service.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {
		
		text = URL.decodeParam(text);
		
		List<Post>list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	
}

