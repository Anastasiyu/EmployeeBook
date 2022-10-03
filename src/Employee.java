public class Employee {
    private int id;

    private  String surName;
    private String name;
    private  String patronomicName;
    private int department;
    private double salary;
    private static int idCounter = 0;


    public Employee(String surName, String name, String patronymicName, double salary, int department) {

        this.id = ++idCounter;
        this.name = name;
        this.surName = surName;
        this.patronomicName = patronomicName;
        if (department <0) {
            throw new IllegalArgumentException("Номер отдела не может быть отрицательным");
        }
        this.department = department;
        if (salary <0) {
            throw new IllegalArgumentException("Оплата труда не может быть меньше 0 )");
        }
        this.salary = salary;

    }


    public int getId() {
        return id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronomicName() {
        return patronomicName;
    }

    public void setPatronomicName(String patronomicName) {
        this.patronomicName = patronomicName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department <0) {
            throw new IllegalArgumentException("Номер отдела не может быть отрицательным");
        }
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <0) {
            throw new IllegalArgumentException("Оплата труда не может быть меньше 0 )");
        }
        this.salary = salary;
    }
    @Override
    public String toString() {
        return   "" + id + "/ Ф.И.О.: " + surName + " "+ name+" "+ patronomicName  + ", номер отдела- " + department + ". Сумма зарплаты: " + salary +"рублей.";
    }


    public String setSurName() {
        return surName;
    }
}
