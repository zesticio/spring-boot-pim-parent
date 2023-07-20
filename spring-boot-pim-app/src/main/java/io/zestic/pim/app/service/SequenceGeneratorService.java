package io.zestic.pim.app.service;

import io.zestic.pim.data.document.SequenceDocument;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SequenceGeneratorService {

    final private MongoOperations mongoOperations;

    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public int getSequenceNumber(String sequenceName) {
        //get sequence number
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //modify or update the sequence
        Update update = new Update().inc("sequence", 1);
        SequenceDocument counter = mongoOperations.findAndModify(query,
                update,
                FindAndModifyOptions
                        .options()
                        .returnNew(true)
                        .upsert(true),
                SequenceDocument.class);
        //the ternary operator and return the initial id or the updated one from the getSeqNo
        return !Objects.isNull(counter) ? counter.getSequence() : 100000;
    }
}
