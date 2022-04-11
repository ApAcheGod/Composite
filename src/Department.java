import java.util.*;
import java.util.stream.Collectors;

public class Department implements Component, Collection{

    private String name;
    List<Component> children = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Component> getChildren() {
        return children;
    }

    public void setChildren(List<Component> children) {
        this.children = children;
    }

    public void addChildren(Component component){
        this.children.add(component);
    }

    @Override
    public void increaseTheSalary(int value) {
        children.forEach(component -> component.increaseTheSalary(value));
    }

    @Override
    public void decreaseTheSalary(int value) {
        children.forEach(component -> component.decreaseTheSalary(value));
    }

    @Override
    public int getPayslip() {
        return children.stream().mapToInt(Component::getPayslip).sum();
    }

    @Override
    public void getInformation() {
        System.out.println(name);
        children.forEach(Component::getInformation);
    }

    @Override
    public EmployeeIterator getIterator() {
        return new DepartmentIterator();
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    LinkedHashMap<Component, Integer> levels = new LinkedHashMap<>();

    public LinkedHashMap<Component, Integer> getLevel(){
        nextLevel(this, 0);
        return levels;
    }

    private void nextLevel(Component component, Integer level){
        if (component instanceof Employee){
            levels.put(component, level);
        }else{
            ((Department) component).children.forEach(component1 -> nextLevel(component1, level + 1));
        }
    }

    class DepartmentIterator implements EmployeeIterator{

        LinkedHashMap<Component, Integer> levels = getLevel();
        List<Component> sortedComponents = levels
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Component, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int step = 0;

        @Override
        public boolean hasNext() {
                return step < sortedComponents.size();
        }

        @Override
        public Component next() {
            return sortedComponents.get(step++);
        }
    }
}
