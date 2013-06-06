package net.engio.common.xpress.eval;

import net.engio.common.xpress.ast.nodes.Node;
import net.engio.common.xpress.ast.nodes.ValueNode;
import net.engio.common.xpress.operators.Equals;
import net.engio.common.xpress.operators.logical.And;
import net.engio.common.xpress.operators.logical.Or;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public class StringInterpreter extends Interpreter.Impl<StringInterpreter> {


    public static class AndEvalutionFn implements EvalFunction<And.AndNode, String> {


        @Override
        public String evaluate(And.AndNode node, EvaluationContext context) {
            String result = context.<String>evaluate(node.getFirst());
            for(Node expr : node.getRest()){
                result = "(" + result + " and " + context.<String>evaluate(expr) + ")";
            }
            return result;
        }
    }

    public static class OrEvalutionFn implements EvalFunction<Or.OrNode, String> {


        @Override
        public String evaluate(Or.OrNode node, EvaluationContext context) {
            String result = context.<String>evaluate(node.getFirst());
            for(Node expr : node.getRest()){
                result = "(" + result + " or "  + context.<String>evaluate(expr) + ")";
            }
            return result;
        }
    }

    public static class EqualsFunction implements EvalFunction<Equals.EqualsNode, String>{

        @Override
        public String evaluate(Equals.EqualsNode node, EvaluationContext context) {
            return context.<String>evaluate(node.getLeft()) + " == " + context.<String>evaluate(node.getRight());
        }
    }

    public static class ValueEvalFunction implements EvalFunction<ValueNode, String>{

        @Override
        public String evaluate(ValueNode node, EvaluationContext context) {
            return node.getValue().toString();
        }
    }

    public StringInterpreter() {
        bindEvalFunction(new EqualsFunction(), Equals.EqualsNode.class);
        bindEvalFunction(new AndEvalutionFn(), And.AndNode.class);
        bindEvalFunction(new OrEvalutionFn(), Or.OrNode.class);
        bindEvalFunction(new ValueEvalFunction(), ValueNode.class);
    }
}
