package dev.nicocent202.todos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<Todo, ObjectId> {
    void deleteByTid(String tid);
    Optional<Todo> findByTid(String tid);
}
