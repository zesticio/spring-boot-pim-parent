package io.zestic.pim.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import io.zestic.pim.data.document.Collect;
import io.zestic.pim.data.document.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, Integer> {

}
