import java.util.List;

public class Value implements Comparable<Value> {

    public static final Value NULL = new Value();
    public static final Value VOID = new Value();

    private Object value;
    private Boolean isConstant = false;

    private Value() {
        value = new Object();
    }

    Value(Object v) {
        if(v == null) {
            throw new RuntimeException("v == null");
        }
        value = v;

        // Only accept supported value types
        if(!(isBoolean() || isList() || isNumber() || isString())) {
            throw new RuntimeException("Invalid data type: " + v + " (" + v.getClass() + ")");
        }
    }

    public void setConstant(){
        this.isConstant = true;
    }

    public Boolean getIsConstant() {
        return this.isConstant;
    }

    public Boolean asBoolean() {
        return (Boolean)value;
    }

    public Double asDouble() {
        return ((Number)value).doubleValue();
    }

    public Long asLong() {
        return ((Number)value).longValue();
    }

    public List<Value> asList() {
        return (List<Value>)value;
    }

    public String asString() {
        return (String)value;
    }

    @Override
    public String toString() {
        return isNull() ? "NULL" : isVoid() ? "VOID" : String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if(this == VOID || o == VOID) {
            throw new RuntimeException("Can't use VOID: " + this + " ==/!= " + o);
        }

        if(this == o) {
            return true;
        }

        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Value that = (Value)o;
        if(this.isNumber() && that.isNumber()) {
            double difference = Math.abs(this.asDouble() - that.asDouble());
            return difference < 0.00000000001;
        } else {
          return this.value.equals(that.value);
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    public boolean isNumber() {
        return value instanceof Number;
    }

    public boolean isList() {
        return value instanceof List<?>;
    }

    public boolean isNull() {
        return this == NULL;
    }

    public boolean isVoid() {
        return this == VOID;
    }

    public boolean isString() {
        return value instanceof String;
    }

    public int compareTo(Value o) {
        if(this.isNumber() && o.isNumber()) {
            if(this.equals(o)) {
                return 0;
            } else {
                return this.asDouble().compareTo(o.asDouble());
            }
        } else if(this.isString() && o.isString()) {
            return this.asString().compareTo(o.asString());
        } else {
            throw new RuntimeException("Illegal expression: can't compare " + this + " to " + o);
        }
    }
}
