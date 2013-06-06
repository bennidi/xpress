package net.engio.common.xpress.eval;

import java.util.HashMap;
import java.util.Map;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public interface Bindings {

    public <T> T get(String key);

    public boolean contains(String key);

    public BindRequest bind(Object value);

    public interface BindRequest{

        public Bindings to(String key);
    }

    public static class Impl implements Bindings {

        private Map<String, Object> bindings = new HashMap<String, Object>();

        private Bindings parent = new Empty();


        public BindRequest bind(Object value) {
            return new BindRequestImpl(value);
        }

        public <T> T get(String key) {
            T result = (T) bindings.get(key);
            return result != null ? result : (T)parent.get(key);
        }

        public boolean contains(String key) {
            return bindings.containsKey(key);
        }

        public class BindRequestImpl implements BindRequest{

            private Object value;

            public BindRequestImpl(Object value) {
                this.value = value;
            }

            public Bindings to(String key) {
                bindings.put(key, value);
                return Impl.this;
            }
        }

    }

    public static class Empty implements Bindings{

        private final BindRequest EmptyBindRequestImpl = new BindRequest() {
            @Override
            public Bindings to(String key) {
                return Empty.this;
            }
        };

        @Override
        public <T> T get(String key) {
            return null;
        }

        @Override
        public boolean contains(String key) {
            return false;
        }

        @Override
        public BindRequest bind(Object value) {
            return EmptyBindRequestImpl;
        }

    }

}
