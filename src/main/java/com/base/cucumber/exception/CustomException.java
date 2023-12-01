package com.base.cucumber.exception;

public class CustomException extends RuntimeException {

    public enum ExceptionMessageEnum {
        NO_SUCH_ELEMENT("No such element while processing!"),
        CONFIG_READER_ERROR("Config reader error while load input stream!"),
        FILE_NOT_FOUND_EXCEPTION("File not found !"),
        RANDOM_ITEM_NOT_FOUND("Random item not found ! ");

        private final String message;

        ExceptionMessageEnum(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private final ExceptionMessageEnum exceptionMessage;

    public CustomException(ExceptionMessageEnum exceptionMessage, String message) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessageEnum getExceptionMessage() {
        return exceptionMessage;
    }
}
