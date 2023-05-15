import java.util.ArrayList;

public abstract class Employee {



    /*
    Adaugati urmatoarele campuri cu tipurile aferente:
        - id -> identificator UNIC pentru fiecare angajat
        - nume -> numele si prenumele angajatului
        - salariu -> venitul angajatului
        - vechime -> numarul cu ani de cand este in firma
        - functie -> ce functie are (ex: programator ajutor)
        - proiecte -> array cu proiectele in care este alocat
     */
    protected int id = 0;
    protected String nume;
    protected long salariu;
    protected int vechime;
    protected String functie;
    protected Project []proiecte;

    /*
    Adaugati Constructor care seteaza campurile id, nume, salariu, vechime si functie
    Adaugati metode de setare informatii pentru toate, mai putin ID
     */
    public Employee(String nume, long salariu, int vechime, String functie){
        this.id++;
        this.nume = nume;
        this.salariu = salariu;
        this.vechime = vechime;
        this.functie = functie;
    }
    /*
    Adaugati metodele urmatoarele:
    - getDepartment(){
        - intoarce un string cu numele departamentului din care face parte angajatul
        - in cazul in care face parte din proiecte din mai multe departamente => intoarce un string cu toate numele de departamente
        }

*/


/*    -print(){
     - nu primeste nimic si afiseaza informatiile despre angajat
     - ATENTIE: metoda trebuie suprascrisa in fiecare tip de angajat
    }
     */

    public abstract void print();
    public abstract String getDepartament();

    public void setProiecte(Project[] proiecte){ this.proiecte = proiecte;}

    public String getNume(){
        return this.nume;
    }

    @Override
    public String toString() {
        return this.nume ;
    }

    public int getId(){return this.id;}

    public long getSalariu(){return this.salariu;}

    public abstract ArrayList<String> getSkills();
}
