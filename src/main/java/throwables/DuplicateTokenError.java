package throwables;

public class DuplicateTokenError extends Throwable {

    public DuplicateTokenError(String err) {
        super(err);
    }
}
