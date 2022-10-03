public class Main {

        public static void main(String[] args) {
            EmployeeBook employeeBook = new EmployeeBook();

            Employee el = new Employee("Николав", "Елисей", "Евгеньевич", 45600.00, 1);
            Employee elena = new Employee("Сидоровa", "Лена", "Олеговна", 40200.00, 3);
            Employee proxor = new Employee("Прохоров", "Прохор", "Петрович", 42600.50, 2);
            Employee ele = null;
            Employee vladimir = new Employee("Смирнов", "Владимир", "Владимирович", 41600.00, 4);
            Employee petr = new Employee("Ветров", "Петр", "Петрович", 48900.00, 5);
            Employee petro = new Employee("Петрова", "Петр", "Петрович", 46600.80, 3);
            Employee sergei = new Employee("Кротов", "Сергей", "Сергеевич", 38600.00, 3);
            Employee sergeu = new Employee("Золотов", "Сергей", "Сергеевич", 48300.00, 1);
            Employee nina = new Employee("Николаева", "Нина", "Николаевна", 49600.00, 4);


            employeeBook.addEmployee("Петров", "Петр", "Сергеевич", 49765, 3);
            employeeBook.addEmployee(proxor);

            employeeBook.changeSalary(elena, 44900);

            employeeBook.printAllEmployees();

            double totalSalaries = employeeBook.totalSalaries();
            System.out.printf("Сумма ЗП всех сотрудников за месяц: %.3f%n", totalSalaries);

            Employee employeeWithMinSalary = employeeBook.findEmployeeWithMinSalary();
            System.out.println("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);

            Employee employeeWithMaxSalary = employeeBook.findEmployeeWithMaxSalary();
            System.out.println("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);

            double averageSalary = employeeBook.averageSalary();
            System.out.printf("Средняя ЗП всех сотрудников за месяц: %.3f%n", averageSalary);
            employeeBook.printFullNameEmployees();

            employeeBook.indexSalaries(5);
            System.out.println("После индексации");

            employeeBook.printFullNameEmployees();

            System.out.printf("Сотрудник с минимальной ЗП из %id отдела: %s%n", 1, employeeBook.findEmployeeWithMinSalaryFromDepartment(1));
            System.out.printf("Сотрудник с максимальной ЗП из %id отдела: %s%n", 2, employeeBook.findEmployeeWithMaxSalaryFromDepartment(2));
            System.out.printf("Сумма ЗП всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeeBook.totalSalariesForDepartment(3));
            System.out.printf("Средняя ЗП всех сотрудников за месяц из отдела %d: %.3f%n", 4, employeeBook.avarageSalaryForDepartment(4));

            employeeBook.indexSalariesForDrepartment(2,5);
            System.out.println("После индексации для отдела" + 1);

            employeeBook.printAllEmployeesFromDepartment(1);
            employeeBook.printEmloeesWithSalaryLessThan(55_800);
            employeeBook.printEmloeesWithSalaryGreaterOrEqualThan(55_300);
        }

    }
