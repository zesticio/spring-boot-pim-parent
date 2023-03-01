package io.zestic.pim.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import io.zestic.pim.data.document.Collect;
import io.zestic.pim.data.document.Collection;

@Repository
public interface CollectRepository extends MongoRepository<Collect, Integer> {

}
