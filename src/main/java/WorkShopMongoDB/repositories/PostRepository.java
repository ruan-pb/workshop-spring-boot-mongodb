package WorkShopMongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import WorkShopMongoDB.domain.Post;



@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}