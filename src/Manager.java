import java.util.ArrayList;

public class Manager extends Employee {


    /*
    Aceasta clasa trebuie sa fie un tip specific de angajat
    Pe langa campurile mostenite de la parinte, aceasta clasa va avea si:
    - subordonati -> un array de angajati pe care ii are in echipa sa
     */
    public Employee[] subordonati =  new Employee[0];

    public Manager(String nume, long salariu, int vechime, String functie){
        super(nume, salariu, vechime, functie);
    }
  /*
    Adaugati urmatoarele metode:

    - addEmployee(){
        - adauga subordonat si seteaza managerul pentru acesta
    }
     */

    public void print(){
        System.out.println("---MANAGER---");
        System.out.println("Nume: " + nume);
        System.out.println("Are urmatorii subordonati: ");
        for(int i = 0 ; i < this.subordonati.length; i++){
            System.out.println(this.subordonati[i]);
        }
    }

    public void addEmployee(Employee e){
        Employee[] employees = new Employee[subordonati.length + 1];
        for(int i = 0 ; i < subordonati.length; i++){
            employees[i] = subordonati[i];
        }

        employees[subordonati.length] = e;
        this.setSubordonati(employees);
    }

    public void setProiecte(Project [] proiecte){this.proiecte = proiecte;}
    public void setSubordonati(Employee[] subordonati) {
        this.subordonati = subordonati;
    }

    public String getDepartament(){
        return null;
    }

    public String getNume(){
        return this.nume;
    }

    @Override
    public ArrayList<String> getSkills() {
        return null;
    }


}
