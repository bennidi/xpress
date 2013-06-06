package net.engio.common.xpress.eval;

import net.engio.common.xpress.ast.nodes.*;
import net.engio.common.xpress.ast.transformation.AstTransformation;
import net.engio.common.xpress.ast.transformation.NodeDecoratorTransformation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public interface Interpreter<I extends Interpreter<I>> {


    public <T> T evaluate(Node node, EvaluationContext context);

    public <T> T evaluate(Node node);

    public I bindEvalFunction(EvalFunction fn, Class<? extends Node> node);

    public Node buildAst(Node node);


    public static class Impl<I extends Interpreter<I>> implements Interpreter<I> {

        private EvalFunctions evalFunctions = new EvalFunctions();

        private List<AstTransformation> transformations = new LinkedList<AstTransformation>();

        public Impl() {
            transformations.add(new NodeDecoratorTransformation());
        }


        private Node preprocessNode(Node node) {

            if (UnaryNode.class.isAssignableFrom(node.getClass())) {
                UnaryNode nod = (UnaryNode) node;
                nod.setDescendent(preprocessNode(nod.getDescendent()));
                return transform(nod);
            }

            if (BinaryNode.class.isAssignableFrom(node.getClass())) {
                BinaryNode nod = (BinaryNode) node;
                nod.setLeft(preprocessNode(nod.getLeft()));
                nod.setRight(preprocessNode(nod.getRight()));
                return transform(nod);
            }

            if (NnaryNode.class.isAssignableFrom(node.getClass())) {
                NnaryNode nod = (NnaryNode) node;
                nod.setFirst(preprocessNode(nod.getFirst()));
                nod.setRest(preprocessNodes(nod.getRest()));
                return transform(nod);
            }
            Node transformed = transform(node);
            return transformed == node ? transformed : preprocessNode(transformed); // transitive transformation support
        }

        private Node[] preprocessNodes(Node[] nodes) {
            Node[] processed = new Node[nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                processed[i] = preprocessNode(nodes[i]);
            }
            return processed;
        }

        public Node transform(Node node) {
            for (AstTransformation transformation : transformations) {
                if (transformation.accepts(node)) return transformation.transform(node);
            }
            return node;
        }

        @Override
        public <T> T evaluate(Node node, EvaluationContext context) {
            node = transform(node);

            //context.push(node.getBindings());
            T result = (T) evalFunctions.forNode(node).evaluate(node, context);
            //context.pop(node.getBindings());
            return result;
        }

        @Override
        public <T> T evaluate(Node node) {
            return evaluate(node, new EvaluationContext(this));
        }

        @Override
        public I bindEvalFunction(EvalFunction fn, Class node) {
            evalFunctions.bindFuntion(fn, node);
            return (I) this;
        }

        @Override
        public AstRoot buildAst(Node node) {
            AstRoot root = new AstRoot(preprocessNode(node));
            return root;
        }
    }

    public static class EvalFunctions {

        private Map<Class, EvalFunction> evalFn = new HashMap<Class, EvalFunction>();

        public EvalFunctions bindFuntion(EvalFunction fn, Class node) {
            evalFn.put(node, fn);
            return this;
        }

        public EvalFunction forNode(Node node) {
            return evalFn.get(node.getClass());
        }
    }
}
