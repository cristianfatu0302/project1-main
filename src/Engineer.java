import java.util.ArrayList;

public class Engineer extends Employee{

    public Manager manager;
    public ArrayList<String> skills;
        /*
    Aceasta clasa trebuie sa fie un tip specific de angajat (employee)
    Pe langa campurile mostenite de la parinte, aceasta clasa va avea si:
        - skills -> un array skilluri pe care le are
        - manager -> managerul sau direct (null daca nu are)
     */
    //constructor pentru Engineer
    public Engineer(String nume, long salariu, int vechime, String functie, String[] skills){
        super(nume, salariu, vechime, functie);
        this.skills = new ArrayList<>();
        for(String skill:skills){
            this.skills.add(skill);
        }
    }
    public void print(){
        System.out.println("---ENGINEER---");
        System.out.println("ID-ul unic al angajatului: " + this.id);
        System.out.println("Nume: " + this.getNume());
        System.out.println("Vechime " + this.vechime );
        System.out.println("Salariu: " + this.salariu);
        System.out.println("Functia: " + this.functie);
        System.out.println("Are urmatoarele skill-uri: " + this.skills);
    }
    /*
    Adaugati urmatoarele metode:

    - participaTraining(){
        - primeste un array de skilluri si le adauga pe cele care nu erau deja existente in lista de skilluri ale angajatului
    }
     */
    public void participaTraining(String[] newSkills){
        for(String skill:newSkills){
            if(!skills.contains(skill)){
                skills.add(skill);
            }
        }
    }

    public void setSkills(String[] skills){
        for(String skill:skills){
            this.skills.add(skill);
        }
    }

    public void setManager(Manager manager){
        this.manager = manager;
    }

    public String getDepartament(){         
        return null;
    }

    public Manager getManager(){
        return this.manager;
    }

    public ArrayList<String> getSkills(){
        return this.skills;
    }
    @Override
    public String getNume(){
        return this.nume;
    }


}
