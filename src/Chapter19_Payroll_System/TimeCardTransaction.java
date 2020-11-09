package Chapter19_Payroll_System;

public class TimeCardTransaction implements Transaction {
    private long itsDate;
    private double itsHours;
    private int itsEmpId;

    public TimeCardTransaction(long date, double hours, int empId) {
        itsDate = date;
        itsHours = hours;
        itsEmpId = empId;
    }

    public void Execute() {
        Employee e = PayrollDatabase.GetEmployee(itsEmpId);
        if (e != null) {
            PaymentClassification pc = e.GetClassification();
            if (pc instanceof HourlyClassification) {
                HourlyClassification hc = (HourlyClassification) pc;
                hc.AddTimeCard(new TimeCaard(itsDate, itsHours));
            } else {
                throw new RuntimeException("tried to add timecard to non-hourly employee.");
            }
        } else {
            throw new RuntimeException("No such employee.");
        }
    }
}
