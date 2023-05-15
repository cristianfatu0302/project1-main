import java.util.Arrays;

public class Main {

    /*
    Aceasta clasa va reprezenta "Compania" noastra
     */
    public static void main(String[] args) {
	/*
	- Creati doua noi departamente (ex: IT si INDUSTRIAL) - da
    - Creati cativa angajati de ambele tipuri - da
    - Creati cateva proiecte  - da
    - Adaugati angajati in fiecare proiect - da
    - Adaugati proiectele in departamente - da
    - Calculati costul total pentru fiecare departament
    - Sterge un angajat din toate departamentele
    - Afiseaza lista de skilluri ale fiecarui angajat
    - verifica daca toate skillurile necesare de pe un proiect sunt acoperite
    - folositi metodele de get si set pentru salarii, proiecte etc si recalculati cost


	 */

        Employee[] angajatiProiect1 = new Employee[3];
        String[] skills = {"Java", "C++", "MatLab"};
        angajatiProiect1[0] = new Engineer("Alexandru", 5900, 1, "Dezvoltator", skills);
        angajatiProiect1[1] = new Engineer("Adrian", 6500, 2, "Inginer Software",new String[]{"Simulink", "Git", "C "});
        angajatiProiect1[2] = new Manager("Cristian", 12000, 3, "Manager");

        Employee[] angajatiProiect2 = new Employee[3];
        angajatiProiect2[0] = new Manager("Cristian", 12000, 3, "Manager");
        angajatiProiect2[1] = new Engineer("Filip", 7600, 2,"Tester", new String[]{"Testing", "Java"});
        angajatiProiect2[2] = new Engineer("Stefan", 7500, 3, "Inginer Software", new String[]{"SpringBoot", "Java", "CSS", "HTML"});

        Employee[] angajatiProiect3 = new Employee[3];

        angajatiProiect3[0] = new Engineer("Alexandra", 8000, 2, "Inginer Software", new String[]{"Python", "Django", "HTML", "CSS"});
        angajatiProiect3[1] = new Engineer("Mihai", 9000, 4, "Full Stack Developer", new String[]{"JavaScript", "React", "Node.js", "MongoDB"});
        angajatiProiect3[2] = new Manager("Andreea", 15000, 5, "Manager");


        Project[] projects = new Project[3];
        projects[0] = new Project(56000, "Aplicatie Web", "Aplicatie magazin online haine");
        projects[1] = new Project(25000, "Aplicatie Mobilă", "Aplicație mobilă pentru gestionarea bugetului personal");
        projects[2] = new Project(80000, "Platformă E-learning", "Platformă online pentru cursuri și lecții în diferite domenii");


        projects[0].setAngajati(angajatiProiect1);
        projects[1].setAngajati(angajatiProiect2);
        projects[2].setAngajati(angajatiProiect3);


        Department it = new Department(12, "IT", projects);


        Employee[] angajatiProiecteIndustrial1 = new Employee[3];

        angajatiProiecteIndustrial1[0] = new Engineer("Gabriel", 8500, 3, "Inginer Industrial", new String[]{"AutoCAD", "SolidWorks", "ProEngineer"});
        angajatiProiecteIndustrial1[1] = new Engineer("Elena", 7800, 2, "Inginer Procese Industriale", new String[]{"Lean Manufacturing", "Six Sigma", "MS Excel"});
        angajatiProiecteIndustrial1[2] = new Manager("Marian", 14000, 6, "Manager Industrial");

        Employee[] angajatiProiecteIndustrial2 = new Employee[3];

        angajatiProiecteIndustrial2[0] = new Engineer("Ana", 8200, 4, "Inginer Mecanic", new String[]{"CAD", "Mecanică", "Inginerie termică"});
        angajatiProiecteIndustrial2[1] = new Engineer("Ionut", 7500, 2, "Inginer Electrician", new String[]{"Automatizări", "Energie", "Sisteme de control"});
        angajatiProiecteIndustrial2[2] = new Manager("Catalina", 16000, 7, "Manager Tehnic");

        Project[] projectsIndustrial = new Project[2];

        projectsIndustrial[0] = new Project(150000, "Modernizare Liniilor de Producție", "Modernizarea și automatizarea liniilor de producție în fabrică");
        projectsIndustrial[1] = new Project(90000, "Optimizare Procese Industriale", "Analiza și optimizarea proceselor industriale pentru creșterea eficienței");

        projectsIndustrial[0].setAngajati(angajatiProiecteIndustrial1);
        projectsIndustrial[1].setAngajati(angajatiProiecteIndustrial2);

        Department industrial = new Department(15, "Industrial", projectsIndustrial);
        //imi setez proiectele pentru angajati
        for( Employee e : angajatiProiect1){
            e.setProiecte(projects);
        }

        for(Employee e :  angajatiProiect2){
            e.setProiecte(projects);
        }

        for(Employee e : angajatiProiect3){
            e.setProiecte(projects);
        }

        for(Employee e : angajatiProiecteIndustrial1){
            e.setProiecte(projectsIndustrial);
        }

        for(Employee e : angajatiProiecteIndustrial2){
            e.setProiecte(projectsIndustrial);
        }

        // costul total pentru fiecare departament

        System.out.println("Costul total pentru departamentul IT este: " + it.calcTotalCost());
        System.out.println("Costul total pentru departamentul INDUSTRIAL este: " + industrial.calcTotalCost());

        for(Project p : projects){
            p.setDepartment(it);
        }

        for(Project p : projects){
            p.print();
        }

        System.out.println();
        System.out.println("---DUPA STERGERE---");
        it.removeEmployee(angajatiProiect1[1]);


        for(Project p : projects){
            p.print();
        }

        for(Project p : projectsIndustrial){
            p.setDepartment(industrial);
        }

        System.out.println();
        for(Project p : projectsIndustrial){
            p.print();
        }


        System.out.println();
        System.out.println("---DUPA STERGERE---");
        industrial.removeEmployee(angajatiProiecteIndustrial2[1]);

        for(Project p : projectsIndustrial){
            p.print();
        }

        for(Employee e : angajatiProiect1){
            System.out.println("Lista skill-uri anagajat " + e.getNume() + ": ");
            String[] array = e.getSkills().toArray(new String[e.getSkills().size()]);
            for(int i = 0 ; i < e.getSkills().size(); i++){
                System.out.println(array[i]);
            }
        }


    }
}
