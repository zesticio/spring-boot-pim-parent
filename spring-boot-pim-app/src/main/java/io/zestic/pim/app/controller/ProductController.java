package io.zestic.pim.app.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.zestic.core.controller.AbstractController;
import io.zestic.core.entity.Result;
import io.zestic.core.util.HTTPErrorCodes;
import io.zestic.pim.api.product.ProductModel;
import io.zestic.pim.app.service.ProductServiceImpl;
import io.zestic.pim.app.service.ServiceInterface;
import io.zestic.pim.app.validation.ProductValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController extends AbstractController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProductController.class);

    private ServiceInterface service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
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
    public ResponseEntity<Result> findAll(@RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        response = service.findAll(page, size);
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
    public ResponseEntity<Result> create(@ProductValidation @RequestBody ProductModel model) {
        Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        response = service.create(model);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ApiOperation(value = "Update / create several products", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Authentication required"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 406, message = "Not Acceptable")
    })
    @PutMapping(path = "/{code}")
    public ResponseEntity<Result> update(@PathVariable(value = "code") String code,
                                         @ProductValidation @RequestBody List<ProductModel> model) {
        Result response = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        response = service.update(code, model);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ApiOperation(value = "Get a product", response = ResponseEntity.class)
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
        response = service.delete(code);
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
    public ResponseEntity<Result> proposal(@PathVariable(value = "code") String code, @ProductValidation @RequestBody ProductModel product) {
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
