public class Main {
    public static void main(String[] args) {
        Department university = new Department("Университет");

        Department UMU = new Department("УМУ");
        university.addChildren(UMU);

        Department trainingDepartment = new Department("Учебный отдел");
        UMU.addChildren(trainingDepartment);

        trainingDepartment.addChildren(new Employee("Сотрудник 1", 100));
        trainingDepartment.addChildren(new Employee("Сотрудник 2", 200));
        trainingDepartment.addChildren(new Employee("Сотрудник 3", 300));

        Department OpDepartment = new Department("Отдел по работе с ОП");
        UMU.addChildren(OpDepartment);

        OpDepartment.addChildren(new Employee("Сотрудник 4", 400));
        OpDepartment.addChildren(new Employee("Сотрудник 5", 500));


        Department PFU = new Department("ПФУ");
        university.addChildren(PFU);
        PFU.addChildren(new Employee("Сотрудник 6", 600));
        PFU.addChildren(new Employee("Сотрудник 7", 700));

        Department accountancy = new Department("Бухгалтерия");

        PFU.addChildren(accountancy);
        accountancy.addChildren(new Employee("Сотрудник 8", 800));
        accountancy.addChildren(new Employee("Сотрудник 9", 900));

        Department OK = new Department("OK");
        university.addChildren(OK);
        OK.addChildren(new Employee("Сотрудник 10", 1000));
        OK.addChildren(new Employee("Сотрудник 11", 1100));
        OK.addChildren(new Employee("Сотрудник 12", 1200));

        System.out.println(university.getPayslip()); // 7800

        System.out.println(UMU.getPayslip()); // 1500

        university.increaseTheSalary(1000);

        System.out.println(university.getPayslip()); // 19800

        university.getInformation();
    }
}
