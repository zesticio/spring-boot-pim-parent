package in.zestic.pim.app.controller;

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
import in.zestic.core.controller.AbstractController;
import in.zestic.core.entity.Result;
import in.zestic.core.util.HTTPErrorCodes;
import in.zestic.pim.api.product.Image;
import in.zestic.pim.app.validation.ProductValidation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/images", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ImageController extends AbstractController {

  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ImageController.class);

  public ImageController() {
  }

  @ApiOperation(value = "Get list of images", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
  })
  @GetMapping(path = "")
  public ResponseEntity<Result> findAll() {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Add a new image", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
  })
  @PostMapping(path = "")
  public ResponseEntity<Result> create(@ProductValidation @RequestBody Image image) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Get a image", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
  })
  @PatchMapping(path = "/{code}")
  public ResponseEntity<Result> findById(@PathVariable(value = "code") String code) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Update a image", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
  })
  @PutMapping(path = "/{code}")
  public ResponseEntity<Result> update(@PathVariable(value = "code") String code, @ProductValidation @RequestBody Image image) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }

  @ApiOperation(value = "Delete a image", response = ResponseEntity.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
  })
  @DeleteMapping(path = "/{code}")
  public ResponseEntity<Result> delete(@PathVariable(value = "code") String code) {
    Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
    return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
  }
}
