package Chapter19_Payroll_System;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double itsSalary;

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        itsSalary = salary;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    PaymentClassification GetClassification() {
        return new MonthlySchedule();
    }
}
