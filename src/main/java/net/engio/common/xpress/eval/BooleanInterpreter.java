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
public class BooleanInterpreter extends Interpreter.Impl<BooleanInterpreter>{


    public static class AndEvalFunction implements EvalFunction<And.AndNode, Boolean> {


        @Override
        public Boolean evaluate(And.AndNode node, EvaluationContext context) {
            boolean result = context.<Boolean>evaluate(node.getFirst());
            for(Node expr : node.getRest()){
                result = result && context.<Boolean>evaluate(expr);
            }
            return result;
        }
    }

    public static class OrEvalFunction implements EvalFunction<Or.OrNode, Boolean> {


        @Override
        public Boolean evaluate(Or.OrNode node, EvaluationContext context) {
            boolean result = context.<Boolean>evaluate(node.getFirst());
            for(Node expr : node.getRest()){
                result = result || context.<Boolean>evaluate(expr);
            }
            return result;
        }
    }

    public static class EqualsEvalFunction implements EvalFunction<Equals.EqualsNode, Boolean>{


        @Override
        public Boolean evaluate(Equals.EqualsNode node, EvaluationContext context) {
            return context.evaluate(node.getLeft()).equals(context.evaluate(node.getRight()));
        }
    }

    public static class ValueEvalFunction implements EvalFunction<ValueNode, Object>{

        @Override
        public Object evaluate(ValueNode node, EvaluationContext context) {
            return node.getValue();
        }
    }

    public BooleanInterpreter() {
        bindEvalFunction(new EqualsEvalFunction(), Equals.EqualsNode.class);
        bindEvalFunction(new AndEvalFunction(), And.AndNode.class);
        bindEvalFunction(new OrEvalFunction(), Or.OrNode.class);
        bindEvalFunction(new ValueEvalFunction(), ValueNode.class);
    }


}
