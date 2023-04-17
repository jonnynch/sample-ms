/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.demo.api;

import com.example.demo.model.Book;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-21T12:32:53.476228300+11:00[Australia/Sydney]")
@Validated
@Tag(name = "Demo", description = "Demo")
public interface DemoApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /book/{id} : Delete Books
     *
     * @param id  (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "deleteBooks",
        summary = "Delete Books",
        tags = { "demo" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/book/{id}"
    )
    default ResponseEntity<Void> _deleteBooks(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        return deleteBooks(id);
    }

    // Override this method
    default  ResponseEntity<Void> deleteBooks(String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /book/{id} : Get Book
     *
     * @param id  (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getBook",
        summary = "Get Book",
        tags = { "demo" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/book/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Book> _getBook(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        return getBook(id);
    }

    // Override this method
    default  ResponseEntity<Book> getBook(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"author\" : \"Brandon Sanderson\", \"id\" : \"id\", \"title\" : \"Oathbringer\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /book : Get Books
     *
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getBooks",
        summary = "Get Books",
        tags = { "demo" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Book.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/book",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Book>> _getBooks(
        
    ) {
        return getBooks();
    }

    // Override this method
    default  ResponseEntity<List<Book>> getBooks() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"author\" : \"Brandon Sanderson\", \"id\" : \"id\", \"title\" : \"Oathbringer\" }, { \"author\" : \"Brandon Sanderson\", \"id\" : \"id\", \"title\" : \"Oathbringer\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /book : Update a Book
     *
     * @param book Book to be upserted in shop (required)
     * @return Book Upserted (status code 200)
     */
    @Operation(
        operationId = "upsertBook",
        summary = "Update a Book",
        tags = { "demo" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Book Upserted", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/book",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<String> _upsertBook(
        @Parameter(name = "book", description = "Book to be upserted in shop", required = true) @Valid @RequestBody Book book
    ) {
        return upsertBook(book);
    }

    // Override this method
    default  ResponseEntity<String> upsertBook(Book book) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}