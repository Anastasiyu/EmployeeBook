public class Main {

        public static void main(String[] args) {
            EmployeeBook employeeBook = new EmployeeBook();

            employeeBook.addEmployee("Николаев", "Елисей", "Евгеньевич", 45600.00, 1);
            employeeBook.addEmployee("Сидоровa", "Лена", "Олеговна", 40200.00, 3);
            employeeBook.addEmployee("Прохоров", "Прохор", "Петрович", 42600.50, 2);
            employeeBook.addEmployee("Смирнов", "Владимир", "Владимирович", 41600.00, 4);
            employeeBook.addEmployee("Ветров", "Петр", "Петрович", 48900.00, 5);
            employeeBook.addEmployee("Петрова", "Петр", "Петрович", 46600.80, 3);
            employeeBook.addEmployee("Кротов", "Сергей", "Сергеевич", 38600.00, 3);
            employeeBook.addEmployee("Золотов", "Сергей", "Сергеевич", 48300.00, 1);
            employeeBook.addEmployee("Николаева", "Нина", "Николаевна", 49600.00, 4);



            employeeBook.addEmployee("Петров", "Петр", "Сергеевич", 49765, 3);


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

            employeeBook.indexSalaries(10);
            System.out.println("После индексации");

            employeeBook.printFullNameEmployees();
            employeeBook.indexSalariesForDrepartment(20,3);
            System.out.println("После индексации для отдела" + 1);

            employeeBook.printAllEmployeesFromDepartment(1);
            employeeBook.printEmloeesWithSalaryLessThan(55_800);
            employeeBook.printEmloeesWithSalaryGreaterOrEqualThan(55_300);

            System.out.printf("Сотрудник с минимальной ЗП из %id отдела: %s%n", employeeBook.findEmployeeWithMinSalary());
            System.out.printf("Сотрудник с максимальной ЗП из %id отдела: %s%n",  employeeBook.findEmployeeWithMaxSalary());
            //
           // System.out.printf( 1,"Сумма ЗП всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeeBook.totalSalaryForDepartment(3));
           // System.out.printf( 3,"Средняя ЗП всех сотрудников за месяц из отдела %d: %.3f%n", 4,  employeeBook.avarageSalaryForDepartment(4));


        }

    }
