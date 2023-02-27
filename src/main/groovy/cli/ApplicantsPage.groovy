package cli

import users.*

class ApplicantsPage extends PageCrudCli {
    ApplicantList applicantList = new ApplicantList()

    ApplicantsPage() {
        this.title =       "*        Applicants Page      *"
        this.divider =     "-------------------------------"
        this.showSession = "  This is the applicants page  "
        this.options = [0: ["Add applicant", { add() }],
                        1: ["Remove applicant", { remove() }],
                        2: ["Update applicant", { update() }],
                        3: ["Show applicant", { show() }],
                        4: ["Show all applicants", { showAll() }],
                        5: ["Show applicants by skill", { showBySkill() }],
        ]
    }

    ApplicantsPage(ApplicantList applicantList) {
        this()
        this.applicantList = applicantList
    }

    void add() {
        Scanner sc = new Scanner(System.in)

        String name = null
        String email = null
        String country = null
        String state = null
        Long cep = null
        String description = null
        Long cpf = null
        Integer age = null
        List<String> skills = null

        printf "Name: ";          name = sc.nextLine();
        printf "Email: ";         email = sc.nextLine();
        printf "Country: ";       country = sc.nextLine();
        printf "State: ";         state = sc.nextLine();
        printf "Cep: ";           cep = Long.parseLong(sc.nextLine());
        printf "Description: ";   description = sc.nextLine();
        printf "Cpf: ";           cpf = Long.parseLong(sc.nextLine());
        printf "Age: ";           age = Integer.parseInt(sc.nextLine());
        printf "Skills: ";        skills = sc.next().split();

        applicantList.add(new Applicant(name, email, country, state, cep, description, cpf, age, skills))

        quit()
    }

    void remove() {
        Scanner sc = new Scanner(System.in)

        String whichApplicant

        printf "Which Applicant? "; whichApplicant = sc.nextLine()

        Applicant applicant = (Applicant) applicantList.get(whichApplicant)
        applicantList.remove(applicant)

        quit()
    }

    void update() {
        Scanner sc = new Scanner(System.in)

        String whichApplicant

        String name = null
        String email = null
        String country = null
        String state = null
        Long cep = null
        String description = null
        Long cpf = null
        Integer age = null
        List<String> skills = null

        printf "Which Applicant? "; whichApplicant = sc.nextLine()

//        println "(You can skip each field by pressing ENTER)"

        printf "Name: ";          name = sc.nextLine();
        printf "Email: ";         email = sc.nextLine();
        printf "Country: ";       country = sc.nextLine();
        printf "State: ";         state = sc.nextLine();
        printf "Cep: ";           cep = Long.parseLong(sc.nextLine());
        printf "Description: ";   description = sc.nextLine();
        printf "Cpf: ";           cpf = Long.parseLong(sc.nextLine());
        printf "Age: ";           age = Integer.parseInt(sc.nextLine());
        printf "Skills: ";        skills = sc.next().split();

        Applicant applicant = (Applicant) applicantList.get(whichApplicant)
        applicant.update(name, email, country, state, cep, description, cpf, age, skills)

        quit()
    }


    void show() {
        Scanner sc = new Scanner(System.in)
        String applicantName
        printf "Which Applicant? "; applicantName = sc.nextLine()
        Applicant applicant = (Applicant) applicantList.get(applicantName)

        println "Name: " + applicant.getName()
        println "Email: " + applicant.getEmail()
        println "Country: " + applicant.getCountry()
        println "State: " + applicant.getState()
        println "Cep: " + applicant.getCep()
        println "Description: " + applicant.getDescription()
        println "Cpf: " + applicant.getCpf()
        println "Age: " + applicant.getAge()
        println "Skills: " + applicant.getSkills()

        quit()
    }

    void showAll() {
        List<User> applicants = applicantList.getAll()
        println "→ Applicants"
        applicants.each {applicant ->
            println "- " + applicant.name
        }

        quit()
    }

    void showBySkill() {
        Scanner sc = new Scanner(System.in)
        String skill
        printf "Which Skill? "; skill = sc.nextLine()
        List<User> applicantsBySkill = applicantList.getBySkill(skill)
        println "→ Applicants that have `${skill}` skill"
        applicantsBySkill.each {applicant ->
            println "- " + applicant.name
        }

        quit()
    }

}
