package net.engio.common.xpress.eval;

import net.engio.common.xpress.ast.nodes.Node;

import java.util.LinkedList;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public class EvaluationContext {

    private LinkedList<Bindings> bindingStack = new LinkedList<Bindings>();

    private Interpreter interpreter;

    public EvaluationContext(Interpreter interpreter) {
        this.interpreter = interpreter;
        bindingStack.addFirst(new Bindings.Impl());
    }

    public BindRequest bind(Object value){
        return new BindRequest(value);
    }

    public <T> T evaluate(Node node){
        return (T)interpreter.evaluate(node, this);
    }

    public EvaluationContext push(Bindings bindings) {
        bindingStack.addFirst(bindings);
        return this;
    }

    public void pop(Bindings bindings) {
        if(bindingStack.getFirst() == bindings){
            bindingStack.removeFirst();
        }
        else throw new IllegalArgumentException("The provided bindings does not exist");
    }

    public <T> T get(String key){
        for(Bindings binding: bindingStack){
            if(binding.contains(key))return binding.get(key);
        }
        throw new IllegalArgumentException("[" + key + "] is unbound");
    }


    public class BindRequest{

        private Object value;

        public BindRequest(Object value) {
            this.value = value;
        }

        public EvaluationContext to(String key) {
            bindingStack.getFirst().bind(value).to(key);
            return EvaluationContext.this;
        }

    }
}
