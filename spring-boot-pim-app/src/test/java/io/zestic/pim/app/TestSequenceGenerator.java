package io.zestic.pim.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.zestic.pim.api.catalog.CollectionModel;
import io.zestic.pim.app.service.SequenceGeneratorService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
public class TestSequenceGenerator {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private ObjectWriter objectWriter;
    private CollectionModel model;

    @Mock
    private MongoOperations mongoOperations;

    @InjectMocks
    private SequenceGeneratorService service;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        objectWriter = objectMapper.writer();
        model = CollectionModel.builder().build();
    }

    @Test
    public void generateSequence() {
        Integer sequence = service.getSequenceNumber("global");
        System.out.println("Sequence " + sequence);
    }
}
