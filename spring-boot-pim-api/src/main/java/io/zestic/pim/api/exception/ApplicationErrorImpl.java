package io.zestic.pim.api.exception;

import io.zestic.core.exception.ApplicationError;
import lombok.Getter;

@Getter
public enum ApplicationErrorImpl implements ApplicationError {

    SUCCESS(200, "Ok"),
    CREATED(201, "Successfully created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(202, "No Content"),
    CONFLICT_EXCEPTION(299, "Conflict Exception"),
    FOUND(302, "Found"),
    BAD_REQUEST(400, "Request was invalid"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not found, requested data not found"),
    METHOD_NOT_ALLOWED(405, "Method not allowed."),
    DUPLICATE(409, "Record exist."),
    PRECONDITION_FAILED(412, "Precondition failed"),
    UNSUPPORTED_MEDIA_TYPE(412, "Unsupported Media Type"),
    MESSAGE_RATE_LIMITED(420, "Message is rate limited"),
    TOO_MANY_REQUESTS(429, "Too many requests"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    TIMEOUT(504, "Timeout");

    private Integer code;
    private String message;

    ApplicationErrorImpl(Integer code, String mesg) {
        this.code = code;
        this.message = mesg;
    }
}
