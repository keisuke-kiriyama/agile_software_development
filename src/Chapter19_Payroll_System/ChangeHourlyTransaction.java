package Chapter19_Payroll_System;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private double itsRate;

    public ChangeHourlyTransaction(int empId, double rate) {
        super(empId);
        itsRate = rate;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new WeeklySchedule();
    }

    @Override
    PaymentClassification GetClassification() {
        return new HourlyClassification(itsRate);
    }
}
