import java.util.ArrayList;

public class Department {
      /*
    Adaugati urmatoarele atribute cu tipurile corespunzatoare
    - id -> identificator UNIC pentru fiecare departament
    - nume -> denumirea departamentului
    - proiecte ->un array cu proiectele din departament
     */
    private int id;
    private String nume;
    private Project[] proiecte;

    //constructorul fara parametrii
    public Department() {
        this.id = 0;
        this.nume = null;
        for(int i = 0; i < proiecte.length; i++){
            this.proiecte[i] = null;
        }
    }
    //constructorul cu parametrii
    public Department(int id,String nume,Project[] proiecte){
        this.id = id;
        this.nume = nume;
        this.proiecte = new Project[proiecte.length];
        for(int i = 0 ;  i < proiecte.length; i++){
            this.proiecte[i] = proiecte[i];
        }
    }
    /*
    Implementati urmatoarele metode METODE:
    - addProject(){
           - primeste un proiect si il adauga in lista de proiecte
           - ATENTIE: adauga si angajatii din acel proiect care nu sunt deja in departament
    } */

    public void addProject(Project p){
        Project[] temp = new Project[proiecte.length + 1];

        for(int i = 0 ; i < proiecte.length; i++){
            temp[i] = this.proiecte[i];
        }

        temp[proiecte.length] = p;
        this.proiecte = temp;
    }

    /*
    - calcTotalCost(){
        - calculeaza si returneaza costul total al departamentului
            -> acest cost reprezinta costul tuturor proiectelor din departament
    }*/

    public long calcTotalCost(){
        long calcul = 0;
        for(Project p : proiecte){
            calcul = calcul + p.calcCostTotal();
        }

        return calcul;
    }

    /*

    - removeEmployee(){
        - sterge angajatul din toate proiectele din departament
    } */

    public void removeEmployee(Employee e){
        for(Project p : this.proiecte){
            if(p!=null){
                p.removeEmployee(e);
            }
        }
    }

    /*

    -calAngajati(){
        - calculeaza numarul total de angajati
        - ATENTIE: un angajat care lucreaza pe mai multe proiecte nu trebuie numarat de mai multe ori
     */

    public int calAngajati(){
        ArrayList<Employee> angajatiPeProiecte = new ArrayList<>();

        for(Project p : this.proiecte){
            Employee[] temp = p.getAngajati();
            for(Employee e : temp){
                if(!angajatiPeProiecte.contains(e)){
                    angajatiPeProiecte.add(e);
                }
            }
        }
        return angajatiPeProiecte.size();
    }


    public String getNume(){return this.nume;}
}
