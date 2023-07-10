package com.study.springcore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseEntity<T> {

    private int statusCode;
    private String responseMessage;
    private T data;

    public ResponseEntity(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static<T> ResponseEntity<T> res(final StatusEnum status) {
        return ResponseEntity.<T>builder()
                .data(null)
                .statusCode(status.statusCode)
                .responseMessage(status.code)
                .build();
    }

    public static<T> ResponseEntity<T> res(final StatusEnum status, final T t) {
        return ResponseEntity.<T>builder()
                .data(t)
                .statusCode(status.statusCode)
                .responseMessage(status.code)
                .build();
    }

    public static<T> ResponseEntity<T> res(final int statusCode, final String responseMessage) {
        return ResponseEntity.<T>builder()
                .data(null)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }

    public static<T> ResponseEntity<T> res(final int statusCode, final String responseMessage, final T t) {
        return ResponseEntity.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
}
