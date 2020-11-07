package Chapter19_Payroll_System;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double itsHourlyRate;

    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
        super(empId, name, address);
        itsHourlyRate = hourlyRate;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new HoulyClassification(itsHourlyRate);
    }

    @Override
    PaymentClassification GetClassification() {
        return new WeeklySchedule;
    }
}
