package io.zestic.pim.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.zestic.pim.api.catalog.CollectionModel;
import io.zestic.pim.api.product.ImageModel;
import io.zestic.pim.app.controller.CollectionController;
import io.zestic.pim.data.repository.CollectionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class TestCollection {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private ObjectWriter objectWriter;
    private CollectionModel model;

    @Mock
    private CollectionRepository repository;

    @InjectMocks
    private CollectionController controller;

    @BeforeAll
    public void setUp() {
        objectMapper = new ObjectMapper();
        objectWriter = objectMapper.writer();
        model = CollectionModel.builder().build();

        Integer productId = 100000;
        Integer imageId = 100000;

        model.setId(productId);
        model.setHandle("test_handle");
        model.setTitle("Test Handle");
        model.setBodyHtml("Test Body");
        model.setCode("TEST100000");

        ImageModel imageModel = ImageModel.builder().build();
        imageModel.setId(100000);
        imageModel.setHeight(0.00);
        imageModel.setWidth(0.00);
        imageModel.setPosition(1);
        imageModel.setProductId(productId);
        imageModel.setSrc("");

        imageModel.setCreatedAt(new Date());
        imageModel.setModifiedAt(new Date());
        model.setImage(imageModel);

        model.setPublishedAt(new Date());
        model.setCreatedAt(new Date());
        model.setModifiedAt(new Date());
    }
}
