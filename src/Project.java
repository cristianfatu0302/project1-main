import java.util.ArrayList;
import java.util.Arrays;

public class Project {
    /*
    Adaugati urmatoarele atribute cu tipurile corespunzatoare
    - id -> identificator UNIC pentru fiecare proiect
    - alteCosturi -> costul proiectului, mai putin salariu angajatilor
    - nume -> denumirea proiectului
    - descriere -> mai multe informatii despre proiect
    - angajati -> un array cu angajatii implicati in proiect
    - departament -> departamentul din care face parte
    - skills -> array de skilluri necesare pe proiect
     */
    public int id = 0 ;
    public long alteCosturi;
    public String nume;
    public String descriere;
    public Employee[] angajati = new Employee[0];
    public Department department;
    public ArrayList<String> skills;
        /*
    Adaugati Constructor care seteaza campurile id, nume, alteCosturi, descriere
    Adaugati metode de setare informatii pentru toate, mai putin ID
    Adaugati metode de preluare(get) de informatii
     */
    //constructor
    public Project(long alteCosturi, String nume, String descriere){
        this.id ++;
        this.alteCosturi = alteCosturi;
        this.nume = nume;
        this.descriere = descriere;

    }

    public void setAlteCosturi(long alteCosturi) {
        this.alteCosturi = alteCosturi;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setAngajati(Employee[] angajati) {
        this.angajati = angajati;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public Employee[] getAngajati() {
        return angajati;
    }

    public Department getDepartment() {
        return department;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public long getAlteCosturi(){ return this.alteCosturi;};

    /*
    Adaugati urmatoarele metode:
    - addEmployee(){
        - primeste un angajat si il adauga pe proiect
        - adauga proiectul la arrayul de proiecte al angajatului
        }
  */

    public void addEmployee(Employee e){
        Employee[] temp = new Employee[angajati.length + 1];
        for(int i = 0 ; i < angajati.length; i++){
            temp[i] = angajati[i];
        }

        temp[angajati.length] = e;
        angajati = temp;
    }

    /*
    - calcCostTotal(){
        - metoda care calculeaza si intoarce cost total
        cost total = alteCosturi + salarii lunare angajati
        ATENTIE: daca un angajat lucreaza pe mai multe proiecte se va presupune ca si cost per proiect doar partea corespunzatoare a salariului:
            ex: 12000 salariu si lucreaza pe 3 proiecte => cost proiect cu angajatul = 4000 ron
     } */

    public long calcCostTotal(){
        long suma = alteCosturi;
        for(Employee e : this.angajati){
            suma = suma + e.getSalariu()/e.proiecte.length;
        }

        return suma;
    }

    /*

     - print(){
        - afiseaza informatiile despre proiect
     } */

    public void print(){
        System.out.println("---PROIECT----");
        System.out.println("Avem proiectul cu numele: " + this.nume + " din departamentul " +department.getNume());
        System.out.println("Proiectul este descris astfel : " + this.descriere);
        System.out.println("Angajatii care se ocupa sunt: " );
        for(Employee e : angajati){
            System.out.println(e);
        }
    }

    /*

     -checkSkills(){
      - returneaza un boolean care spune daca inginerii care lucreaza la proiect au skillurile necesare impreuna
     */

    public boolean checkSkills(){

        for( int i = 0 ; i < skills.size(); i++){
            if(angajati[i] instanceof Engineer)
                if(!areSkilluri((((Engineer) angajati[i]).getSkills()))){
                    return false;
                }
        }

        return true;
    }

    public boolean areSkilluri(ArrayList<String> skillsAngajat){
        for(String skill : skillsAngajat){
            if(!skills.contains(skill)){
                return false;
            }
        }
        return true;
    }

    public void removeEmployee(Employee e){
        if(angajati == null){
            return; //nu avem ce sterge
        }

        ArrayList<Employee> updatedList = new ArrayList<>(Arrays.asList(angajati));
        updatedList.remove(e);
        angajati = updatedList.toArray(new Employee[0]);
    }
}
