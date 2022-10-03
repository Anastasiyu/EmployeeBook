import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeBook {

    private final Map<String, Employee> employees;
     public  EmployeeBook() {
         employees = new HashMap<>();}

    // найти сотрудника по Ф.И.О. (ключ)
    private String getKey(Employee employee){
        return  employee.getSurName()+ " " + employee.getName()+ " " + employee.getPatronomicName();
    }
//добавить сотрудника
    public  void  addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);


    }
    public  void  addEmployee(String surName,
                              String name,
                              String patronymicName,
                              double salary,
                              int department){
        addEmployee(new Employee(surName, name, patronymicName, salary,department));
    }

    //удаление сотрудника по Ф.И.О
    public  void  removeEmployee(Employee employee){
        employees.remove(getKey(employee));
    }

    //удаление сотрудника по id
    public  void  removeEmployee(int id) {
        //поиск сотрудника, что он еще не удален.
        String  employeekeyForRemoving = null;
        for (String key: employees.keySet()) {
            if (employees.get(key).getId()==id){
                employeekeyForRemoving = key;
                break;
            }
        }
        //если сотрудник не удален удаляем
        if(employeekeyForRemoving !=null) {
            employees.remove(employeekeyForRemoving);
        }
    }
//заменить з.п., с проверкой есть ли этот сотрудник
    public  void  changeSalary(Employee employee,
                               double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }


//замена номера департамента

    public  void  changeDepartment(Employee employee,
                                   int newDepartment){
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setDepartment(newDepartment);
        }
    }

    // метод распечатать сотрудников по отделам

    public  void  printEmploeesByDepartment(){
        //по условию отделы от 1 до 5
        for (int department = 1; department <=5; department++) {
            System.out.println("Сотрудник из отдела" + department + ":");
            for (Employee employee : employees.values()) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.setSurName() + " " + employee.getName() + " " + employee.getPatronomicName());
                }
            }
        }
    }
    public void printEmloeesWithSalaryLessThan(double bound) {
        System.out.println("Сотрудник с ЗП меньшей, чем" + bound);
        {
            for (Employee employee : employees.values()) {
                if (employee.getSalary() < bound) {
                    System.out.printf("id: %d, ФИО: %s %s %s, ЗП %.2f%n",
                            employee.getId(),
                            employee.getSurName(),
                            employee.getName(),
                            employee.getPatronomicName(),
                            employee.getSalary()
                    );
                }

            }
        }
    }
    public void printEmloeesWithSalaryGreaterOrEqualThan(double bound) {
        System.out.println("Сотрудник с ЗП большей или равной, чем" + bound);
        {
            for (Employee employee : employees.values()) {
                if (employee.getSalary() < bound) {
                    System.out.printf("id: %d, ФИОЖ %s %s %s, ЗП %.2f%n",
                            employee.getId(),
                            employee.getSurName(),
                            employee.getName(),
                            employee.getPatronomicName(),
                            employee.getSalary()
                    );
                }
            }
        }
    }
    //проиндексировать всем ЗП
    public  void  indexSalaries(double index){
        for (Employee employee : employees.values()) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
        }
    }
    //проэндексировать по отделам
    public  void  indexSalariesForDrepartment(double index, int department){
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }
    public  double averageSalary() {
        int count = employees.values().size();
        if (count != 0) {
            return totalSalaries() / count;
        }
        return 0;
    }
    public  double avarageSalaryForDepartment(int department){
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                totalSalaryForDepartment += employee.getSalary();
                count++;
            }
        }
            return  count == 0? 0: totalSalaryForDepartment / count;
        }

        public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
            double minSalary = Double.MAX_VALUE;
            String key = null;
            for (Map.Entry<String, Employee> entry : employees.entrySet()) {
                Employee employee = entry.getValue();
                if (employee.getDepartment() == department && employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    key = entry.getKey();
                }
            }
            if (key != null) {
                return employees.get(key);
            }else{
                return null;

            }
        }
    public  Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary()< minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }else{
            return null;

        }
    }
    public  Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getDepartment() == department && employee.getSalary() < maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }else{
            return null;
        }
    }
    public  Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }else{
            return null;

        }
    }
    public  double totalSalaryForDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees.values()){
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return  sum;
    }
    public  double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            sum += employee.getSalary();

        }
        return sum;
    }
    public  void printFullNameEmployees() {
        for (Employee employee : employees.values()) {
                System.out.println(employee.getSurName() + " " + employee.getName() + " " + employee.getPatronomicName());

        }
    }

    public  void printAllEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }

    }
    public  void printAllEmployeesFromDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.printf("id: %d, ФИОЖ %s %s %s, ЗП %.2f%n",
                        employee.getId(),
                        employee.getSurName(),
                        employee.getName(),
                        employee.getPatronomicName(),
                        employee.getSalary()
                );
            }
        }
    }

}
