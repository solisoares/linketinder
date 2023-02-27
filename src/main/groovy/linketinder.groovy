import cli.ApplicantsPage
import cli.CompaniesPage
import cli.MainPage
import users.Applicant
import users.ApplicantList
import users.Company
import users.CompanyList

// Instantiating Applicant and Company List Classes ====================================================================
ApplicantList applicantList = new ApplicantList()
CompanyList companyList = new CompanyList()

// Populating ==========================================================================================================
applicantList.add(new Applicant("Applicant1", "applicant1@ap.com", "Country1", "State1",
        1111111L, "Applicant1 description", 11111111111L, 21, Arrays.asList("Skill1a", "Skill1b")))
applicantList.add(new Applicant("Applicant2", "applicant2@ap.com", "Country2", "State2",
        2222222L, "Applicant2 description", 22222222222L, 22, Arrays.asList("Skill2a", "Skill2b")))
applicantList.add(new Applicant("Applicant3", "applicant3@ap.com", "Country3", "State3",
        3333333L, "Applicant3 description", 33333333333L, 23, Arrays.asList("Skill3a", "Skill3b")))
applicantList.add(new Applicant("Applicant4", "applicant4@ap.com", "Country4", "State4",
        4444444L, "Applicant4 description", 44444444444L, 24, Arrays.asList("Skill4a", "Skill4b")))
applicantList.add(new Applicant("Applicant5", "applicant5@ap.com", "Country5", "State5",
        5555555L, "Applicant5 description", 55555555555L, 25, Arrays.asList("Skill5a", "Skill5b")))

companyList.add(new Company("Company1", "company1@ap.com", "Country1", "State1",
        1111111L, "Company1 description", 11111111111L, Arrays.asList("Python", "Java")))
companyList.add(new Company("Company2", "company2@ap.com", "Country2", "State2",
        2222222L, "Company2 description", 22222222222L, Arrays.asList("Python", "Java")))
companyList.add(new Company("Company3", "company3@ap.com", "Country3", "State3",
        3333333L, "Company3 description", 33333333333L, Arrays.asList("Python", "Java")))
companyList.add(new Company("Company4", "company4@ap.com", "Country4", "State4",
        4444444L, "Company4 description", 44444444444L, Arrays.asList("Python", "Java")))
companyList.add(new Company("Company5", "company5@ap.com", "Country5", "State5",
        5555555L, "Company5 description", 55555555555L, Arrays.asList("Python", "Java")))

// Instantiating Applicants and Companies CLI Page =====================================================================
ApplicantsPage applicantsPage = new ApplicantsPage(applicantList)
CompaniesPage companiesPage = new CompaniesPage(companyList)

// Calling linketinder CLI page
MainPage mainPage = new MainPage(applicantsPage, companiesPage)
while (true)
    mainPage.init()