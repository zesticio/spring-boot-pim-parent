package io.zestic.pim.data.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.zestic.core.controller.AbstractController;
import io.zestic.core.entity.Result;
import io.zestic.core.util.HTTPErrorCodes;
import io.zestic.pim.api.product.Product;
import io.zestic.pim.api.product.Products;
import io.zestic.pim.data.validation.ProductValidation;

@RestController
@RequestMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController extends AbstractController {

  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProductController.class);

  public ProductController() {
  }

  @ApiOperation(value = "Get list of products", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Can be caused by a missing or expired token"),
      @ApiResponse(code = 403, message = "The user does not have the permission to execute this request"),
      @ApiResponse(code = 406, message = "The `Accept` header is not `application/json` but it should"),
      @ApiResponse(code = 422, message = "The validation of the entity given in the body of the request failed")
  })
  @GetMapping(path = "")
  public ResponseEntity<Result> findAll() {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Create a new product", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PostMapping(path = "")
  public ResponseEntity<Result> create(@ProductValidation @RequestBody Product product) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Update / create several products", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PutMapping(path = "")
  public ResponseEntity<Result> update(@ProductValidation @RequestBody Products products) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Get a product", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PatchMapping(path = "/{code}")
  public ResponseEntity<Result> findById(@PathVariable(value = "code") String code) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Get a product", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PutMapping(path = "/{code}")
  public ResponseEntity<Result> updateById(@PathVariable(value = "code") String code, @ProductValidation @RequestBody Product product) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Delete a product", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @DeleteMapping(path = "/{code}")
  public ResponseEntity<Result> delete(@PathVariable(value = "code") String code) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Submit a draft for approval", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PostMapping(path = "/{code}/proposal")
  public ResponseEntity<Result> proposal(@PathVariable(value = "code") String code, @ProductValidation @RequestBody Product product) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Get a draft", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Authentication required"),
      @ApiResponse(code = 403, message = "Access forbidden"),
      @ApiResponse(code = 406, message = "Not Acceptable")
  })
  @PostMapping(path = "/{code}/draft")
  public ResponseEntity<Result> draft(@PathVariable(value = "code") String code) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }
}
