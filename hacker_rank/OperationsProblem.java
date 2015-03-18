import java.util.*;

/**
 * The complexity for the solution is in the order of O(E) where E is the number of edges that the graph is made of.
 * it is implemented with a recursion method which is not the best for Java but I thought it was a simple and nice
 * solution. I didn't have time to solve the problem if the graph falls into an infinite loop because it has crossed
 * prerequisites but is something that HAS to be done in the next iteration of the problem
 **/
public class OperationsProblem {

    static class Part {
        public String getName() {
            return "X";
        }
    }

    static class Operation {
        private String name_;
        private Boolean _finished = false;

        public Operation(final String name) {
            name_ = name;
        }

        public String getName() {
            return name_;
        }


        public void operate(Part p) {
            System.out.println("Operation " + name_ + " on part " + p.getName());
            _finished = true;
        }

        private Set<String> _undonePrerequisites = new HashSet<>();

        public Boolean readyToOperate() {
            return _undonePrerequisites.isEmpty();
        }

        public String getUndonePrerequisite() {
            return _undonePrerequisites.iterator().next();
        }

        public void configurePrerequisites(String[] prerequisites) {
            _undonePrerequisites.addAll(Arrays.asList(prerequisites));
        }

        public void removePrerequisite(String prerequisite) {
            _undonePrerequisites.remove(prerequisite);
        }

        public boolean isFinished() {
            return _finished;
        }
    }

    static class StepManager {
        private Map<String, Operation> _operations = new HashMap<String, Operation>();
        private static int counter = 0;

        public void addOperation(final Operation operation, final String[] prerequisites) {
            operation.configurePrerequisites(prerequisites);
            _operations.put(operation.getName(), operation);
        }

        public void performOperation(String operationName, Part p) {
            doPerformOperation(operationName, p, new HashSet<String>());
        }

        private void doPerformOperation(String operationName, Part p, Set<String> parents) {
            System.out.println("count: " + counter);
            counter++;
            Operation op = _operations.get(operationName);
            if (op.isFinished()) {
                return;
            }

            while (!op.readyToOperate()) {
                String undonePrerequisite = op.getUndonePrerequisite();
                if (parents.contains(undonePrerequisite)) {
                    throw new RuntimeException("The graph can't be solved because of infinite loop between : " + undonePrerequisite + " and " + operationName);
                }

                parents.add(operationName);
                doPerformOperation(undonePrerequisite, p, parents);
                parents.remove(operationName);
                op.removePrerequisite(undonePrerequisite);
            }

            op.operate(p);
        }
    }

    public static void main(String[] args) throws Exception {
        StepManager manager = new StepManager();

//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String s;
//        while ((s = in.readLine()) != null && s.length() != 0) {
//            if (s.startsWith("#")) {
//                continue;
//            }
//            String[] parts = s.split(",");
//            manager.addOperation(new Operation(parts[0]),  Arrays.copyOfRange(parts, 1, parts.length));
//        }
        manager.addOperation(new Operation("1"), new String[]{"2", "3", "4", "5"});
        manager.addOperation(new Operation("2"), new String[]{"3", "4"});
        manager.addOperation(new Operation("3"), new String[]{"4"});
        manager.addOperation(new Operation("4"), new String[]{"5"});
        manager.addOperation(new Operation("5"), new String[]{});
        manager.addOperation(new Operation("6"), new String[]{"7"});
        manager.addOperation(new Operation("7"), new String[]{"2"});

        manager.performOperation("1", new Part());
    }
}
