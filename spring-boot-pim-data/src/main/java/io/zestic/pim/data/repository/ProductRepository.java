package io.zestic.pim.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import io.zestic.pim.data.document.ProductDocument;

@Repository
public interface ProductRepository extends MongoRepository<ProductDocument, Integer> {

}
