package cli

import users.ApplicantList
import users.Company
import users.CompanyList
import users.User


class CompaniesPage extends PageCrudCli {
    CompanyList companyList = new CompanyList()

    CompaniesPage() {
        this.title =       "*        Companies Page      *"
        this.divider =     "------------------------------"
        this.showSession = "  This is the companies page  "
        this.options = [0: ["Add company", { add() }],
                        1: ["Remove company", { remove() }],
                        2: ["Update company", { update() }],
                        3: ["Show company", { show() }],
                        4: ["Show all companies", { showAll() }],
                        5: ["Show companies by skill", { showBySkill() }],]
    }

    CompaniesPage(CompanyList companyList) {
        this()
        this.companyList = companyList
    }

    void add() {
        Scanner sc = new Scanner(System.in)

        String name = null
        String email = null
        String country = null
        String state = null
        Long cep = null
        String description = null
        Long cnpj = null
        List<String> skills = null

        printf "Name: ";          name = sc.nextLine();
        printf "Email: ";         email = sc.nextLine();
        printf "Country: ";       country = sc.nextLine();
        printf "State: ";         state = sc.nextLine();
        printf "Cep: ";           cep = Long.parseLong(sc.nextLine());
        printf "Description: ";   description = sc.nextLine();
        printf "CNPJ: ";           cnpj = Long.parseLong(sc.nextLine());
        printf "Skills: ";        skills = sc.nextLine().split();

        companyList.add(new Company(name, email, country, state, cep, description, cnpj, skills))

        quit()
    }

    void remove() {
        Scanner sc = new Scanner(System.in)

        String whichCompany

        printf "Which Company? "; whichCompany = sc.nextLine()

        Company company = (Company) companyList.get(whichCompany)
        companyList.remove(company)

        quit()
    }

    void update() {
        Scanner sc = new Scanner(System.in)

        String whichCompany

        String name = null
        String email = null
        String country = null
        String state = null
        Long cep = null
        String description = null
        Long cnpj = null
        List<String> skills = null

        printf "Which company? "; whichCompany = sc.nextLine()

//        println "(You can skip each field by pressing ENTER)"

        printf "new Name: ";          name = sc.nextLine();
        printf "new Email: ";         email = sc.nextLine();
        printf "new Country: ";       country = sc.nextLine();
        printf "new State: ";         state = sc.nextLine();
        printf "new Cep: ";           cep = Long.parseLong(sc.nextLine());
        printf "new Description: ";   description = sc.nextLine();
        printf "new CNPJ: ";           cnpj = Long.parseLong(sc.nextLine());
        printf "new Skills: ";        skills = sc.next().split();

        Company company = (Company) companyList.get(whichCompany)
        company.update(name, email, country, state, cep, description, cnpj, skills)

        quit()
    }

    void show() {
        Scanner sc = new Scanner(System.in)
        String companyName
        printf "Which Company? "; companyName = sc.nextLine()
        Company company = (Company) companyList.get(companyName)

        println "Name: " + company.getName()
        println "Email: " + company.getEmail()
        println "Country: " + company.getCountry()
        println "State: " + company.getState()
        println "Cep: " + company.getCep()
        println "Description: " + company.getDescription()
        println "CNPJ: " + company.getCnpj()
        println "Required Skills: " + company.getSkills()

        quit()
    }

    void showAll() {
        List<User> companies = companyList.getAll()
        println "→ Companies"
        companies.each {company ->
            println "- " + company.name
        }

        quit()
    }

    void showBySkill() {
        Scanner sc = new Scanner(System.in)
        String skill
        printf "Which Skill? "; skill = sc.nextLine()
        List<User> companiesBySkill = companyList.getBySkill(skill)
        println "→ Companies that require a `${skill}` skill"
        companiesBySkill.each {company ->
            println "- " + company.name
        }

        quit()
    }
}
