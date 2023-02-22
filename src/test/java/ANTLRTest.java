import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ANTLRTest {
    @Test
    void printTree() {
        String expression = "1 + 2";
        CharStream charStream = CharStreams.fromString(expression);
        ExpressionLexer lexer = new ExpressionLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        ParseTree tree = parser.expr();
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    void mathTest() {
        String expression = "9 - 2 * (1 + 2) / 1";
        CharStream charStream = CharStreams.fromString(expression);
        ExpressionLexer lexer = new ExpressionLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        EvalVisitor visitor = new EvalVisitor();
        Integer value = visitor.visit(parser.expr());
        assertEquals(3, value);
    }
}