package io.zestic.pim.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import io.zestic.pim.data.document.VariantDocument;

@Repository
public interface VariantRepository extends MongoRepository<VariantDocument, Integer> {

}
