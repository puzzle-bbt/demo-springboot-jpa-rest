package ch.puzzle.demo.exception;

public class BusinessException extends Exception{
    public int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessClientMessage getClientMessage() {
        return new BusinessClientMessage(this.code, this.getMessage());
    }
}
