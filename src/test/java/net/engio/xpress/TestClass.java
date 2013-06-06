package net.engio.xpress;

import net.engio.common.xpress.BooleanExpression;
import net.engio.common.xpress.ast.nodes.Node;
import net.engio.common.xpress.eval.BooleanInterpreter;
import net.engio.common.xpress.eval.StringInterpreter;
import net.engio.xpress.dsl.MyNumber;
import org.junit.Test;


/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public class TestClass {

    @Test
    public void testEval(){


        MyNumber four = new MyNumber(4L),
                 five = new MyNumber(5L),
                 alsoFour =new MyNumber(4L);

        BooleanExpression first = four.Equals(five).And(four.Equals(alsoFour), four.Equals(five)).Or(four.Equals(alsoFour)),
                            second = four.Equals(alsoFour);

        BooleanInterpreter booleanInterpreter = new BooleanInterpreter();
        StringInterpreter stringInterpreter = new StringInterpreter();

        Node ast = booleanInterpreter.buildAst(first);

        System.out.print(stringInterpreter.evaluate(first));
        System.out.print(":");
        System.out.println(booleanInterpreter.evaluate(first));

        System.out.print(stringInterpreter.evaluate(second));
        System.out.print(":");
        System.out.println(booleanInterpreter.evaluate(second));

    }


}
