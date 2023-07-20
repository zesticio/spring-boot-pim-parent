package io.zestic.pim.app.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.zestic.core.controller.AbstractController;
import io.zestic.core.entity.Result;
import io.zestic.core.util.HTTPErrorCodes;
import io.zestic.pim.api.catalog.CollectionModel;
import io.zestic.pim.app.validation.CollectionValidation;
import io.zestic.pim.app.service.ServiceInterface;
import io.zestic.pim.app.service.CollectionServiceImpl;
import io.zestic.pim.app.validation.ProductValidation;

@RestController
@RequestMapping(value = "/collections", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CollectionController extends AbstractController {

  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CollectionController.class);

  final private ServiceInterface service;

  public CollectionController(CollectionServiceImpl service) {
    this.service = service;
  }

  @ApiOperation(value = "Get list of collections", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @GetMapping(path = "")
  public ResponseEntity<Result> findAll(@RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    response = service.findAll(page, size);
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Add a new collection", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PostMapping(path = "")
  public ResponseEntity<Result> create(@ProductValidation @RequestBody CollectionModel model) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    response = service.create(model);
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Get a collection", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @GetMapping(path = "/{code}")
  public ResponseEntity<Result> findById(@PathVariable(value = "code") String code) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    response = service.findById(code);
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Update a collection", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PutMapping(path = "/{code}")
  public ResponseEntity<Result> update(@PathVariable(value = "code") String code, @CollectionValidation @RequestBody CollectionModel model) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    response = service.update(code, model);
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Delete a collection", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @DeleteMapping(path = "/{code}")
  public ResponseEntity<Result> delete(@PathVariable(value = "code") String code) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    response = service.delete(code);
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }
}
