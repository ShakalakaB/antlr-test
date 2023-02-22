import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorListener extends BaseErrorListener {
    public static final ErrorListener INSTANCE = new ErrorListener();

    public ErrorListener() {
        super();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String errorMsg = String.format("line %s:%s at %s: %s", line, charPositionInLine, offendingSymbol, msg);
        throw new RuntimeException(errorMsg, e);
    }
}
