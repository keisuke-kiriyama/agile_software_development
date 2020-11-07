package Chapter19_Payroll_System;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double itsSalary;
    private double itsCommissionRate;

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionRate) {
        super(empId, name, address);
        itsSalary = salary;
        itsCommissionRate = commissionRate;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    PaymentClassification GetClassification() {
        return new CommissionedEmployee();
    }
}
