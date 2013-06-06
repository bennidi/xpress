package net.engio.xpress.dsl;

import net.engio.common.xpress.BooleanExpression;
import net.engio.common.xpress.types.ObjectType;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public class MyNumber implements ObjectType<MyNumber, BooleanExpression> {


    private Long number;

    public MyNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyNumber myNumber = (MyNumber) o;

        if (number != null ? !number.equals(myNumber.number) : myNumber.number != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public BooleanExpression Equals(MyNumber other) {
        return new BooleanExpression.BoolExprNode(new EqualsNode(this, other));
    }

    @Override
    public BooleanExpression IsNull() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
