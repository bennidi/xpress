package net.engio.common.xpress.types;

import net.engio.common.xpress.operators.Equals;
import net.engio.common.xpress.operators.IsNull;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public interface ObjectType<IN, OUT> extends Equals<IN, OUT>, IsNull<OUT> {
}
