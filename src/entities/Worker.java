package entities;

import java.util.ArrayList;
import java.util.Calendar;

public class Worker {
    private String name;
    private Double baseSalary;
    private ArrayList<HourContract> contracts = new ArrayList<>();
    private WorkerLevel workerLevel;
    private Departament departament;

    public Worker(String name,WorkerLevel workerLevel, Double baseSalary, Departament departament) {
        this.name = name;
        this.workerLevel = workerLevel;
        this.baseSalary = baseSalary;
        this.departament = departament;
        this.contracts = new ArrayList<>();
    }

    public Worker(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public ArrayList<HourContract> getContracts() {
        return contracts;
    }
    public void setContracts(ArrayList<HourContract> contracts) {
        this.contracts = contracts;
    }

    public Departament getDepartament() {
        return departament;
    }
    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public WorkerLevel getWorkerLevel() {
        return workerLevel;
    }

    public void setWorkerLevel(WorkerLevel workerLevel) {
        this.workerLevel = workerLevel;
    }

    // Métodos da classe Worker
    public void addContract(HourContract contract){
        this.contracts.add(contract); // Ajustado para essa estrutura, pois a anterior "this.contract = contract" não adicionava nada
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public Double income(int year, int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if(year == c_year && month == c_month){
                sum += c.totalValue();
            }
        }
        return sum;
    }

}
