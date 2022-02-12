import java.util.ArrayList;
import java.util.List;

public class Department implements Component{

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
}
