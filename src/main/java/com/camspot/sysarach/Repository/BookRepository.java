package com.camspot.sysarach.Repository;

import com.camspot.sysarach.api.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}
