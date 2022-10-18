package ch.puzzle.demo.exception;

public class BusinessClientMessage {
    public int code;
    public String message;

    public BusinessClientMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
