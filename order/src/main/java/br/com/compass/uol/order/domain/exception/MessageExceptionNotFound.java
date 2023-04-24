package br.com.compass.uol.order.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageExceptionNotFound extends RuntimeException{
    public MessageExceptionNotFound(String message) {
        super(message);
    }
}
