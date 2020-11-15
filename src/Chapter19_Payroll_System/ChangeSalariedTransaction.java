package Chapter19_Payroll_System;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private double itsSalary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        itsSalary = salary;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new MonthlySchedule();
    }

    @Override
    PaymentClassification GetClassification() {
        return new SalariedClassification();
    }
}
