package io.zestic.pim.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import io.zestic.pim.data.document.Image;
import io.zestic.pim.data.document.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
