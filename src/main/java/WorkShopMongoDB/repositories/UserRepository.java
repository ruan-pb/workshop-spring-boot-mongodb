package WorkShopMongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import WorkShopMongoDB.domain.User;



@Repository
public interface UserRepository extends MongoRepository<User, String> {

}