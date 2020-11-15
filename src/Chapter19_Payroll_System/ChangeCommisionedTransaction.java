package Chapter19_Payroll_System;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
    private double itsRate;
    private double itsSalary;

    public ChangeCommissionedTransaction(int empId, double rate, double salary) {
        super(empId);
        itsRate = rate;
        itsSalary = salary;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    PaymentClassification GetClassification() {
        return CommissionedClassification();
    }
}
