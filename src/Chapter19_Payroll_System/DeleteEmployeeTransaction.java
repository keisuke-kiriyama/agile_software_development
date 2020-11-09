package Chapter19_Payroll_System;

public class DeleteEmployeeTransaction implements Transaction {
    private int itsEmpId;

    public DeleteEmployeeTransaction(int empId) {
        itsEmpId = empId;
    }

    @Override
    public void Execute() {
        PayrollDatabase.DeleteEmployee(itsEmpId);
    }
}
