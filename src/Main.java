import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Instanciando os objetos para utilizar seus atributos
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter departament's name: ");
        Departament departament = new Departament(sc.nextLine());

        System.out.println("Enter worker data:");
        System.out.println("Name:");
        String name = sc.nextLine();

        System.out.println("Level (JUNIOR, MID_LEVEL, SENIOR): ");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Base salary:");
        double baseSalary = sc.nextDouble();
        sc.nextLine();

        Worker worker = new Worker(name, level, baseSalary, departament);

        System.out.println("How many contracts to this worker: ");
        int numberOfContracts = sc.nextInt();
        sc.nextLine();



        for (int i = 1; i <= numberOfContracts; i++){
            System.out.println("Contract #" + i + " data:");
            Date date = null;
            try {
                System.out.println("Date (DD/MM/YYYY):");
                date = sdf.parse(sc.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format.");
                continue;
            }

            System.out.println("Value per hour:");
            double valuePerHour = sc.nextDouble();
            sc.nextLine();

            System.out.println("Duration (hours):");
            int hours = sc.nextInt();
            sc.nextLine();

            // Instanciar um contrato (salvar) ao final de cada ciclo de perguntas
            HourContract newContract = new HourContract(date, valuePerHour, hours);
            worker.addContract(newContract);
        }

        // Data to income calculate
        System.out.println("-------- INCOME ----------");
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + departament.getName());
        System.out.println("Income for: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));


        sc.close();
    }
}