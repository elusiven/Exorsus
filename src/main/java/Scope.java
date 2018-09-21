import java.util.HashMap;
import java.util.Map;

public class Scope {

    private Scope parent;
    private Map<String, Value> variables;

    Scope() {
        this(null);
    }

    Scope(Scope p) {
        parent = p;
        variables = new HashMap<String, Value>();
    }

    public boolean isGlobalScope() {
        return parent == null;
    }

    public void assignParam(String var, Value value) {
        variables.put(var, value);
    }

    public void assign(String var, Value value) {
        if(resolve(var) != null) {
            this.reAssign(var, value);
        } else {
            variables.put(var, value);
        }
    }

    public void reAssign(String id, Value value) {
        if(variables.containsKey(id)) {
            // Variable exists in this scope
            variables.put(id, value);
        } else if(parent != null) {
            // var was not declared in current scope
            // parent scope will re-assign in that case
            parent.reAssign(id, value);
        }
    }

    // Check if specific variable resolves in specific scope
    public Value resolve(String var) {
        Value value = variables.get(var);
        if(value != null) {
            // The variable is in x scope and exists
            return value;
        } else if(!isGlobalScope()) {
            return parent.resolve(var);
        } else {
            // Unknown
            return null;
        }
    }

    public Boolean exists(String var) {
        return variables.containsKey(var);
    }

    public Scope parent() {
        return parent;
    }

    public Boolean hasParent() {
        if (parent() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Value> var: variables.entrySet()) {
            sb.append(var.getKey()).append("->").append(var.getValue()).append(",");
        }

        return sb.toString();
    }
}
