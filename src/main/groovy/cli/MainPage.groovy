package cli

class MainPage extends PageCli {
    ApplicantsPage applicantsPage = new ApplicantsPage()
    CompaniesPage companiesPage = new CompaniesPage()

    MainPage() {
        this.title = "*     Main Page     *"
        this.divider = "---------------------"
        this.showSession = "This is the main page"
        this.options = [0: ["Applicants", { applicantsPage.init() }],
                        1: ["Companies", { companiesPage.init() }]]
    }

    MainPage(ApplicantsPage applicantsPage, CompaniesPage companiesPage) {
        this()
        this.applicantsPage = applicantsPage
        this.companiesPage = companiesPage
    }
}

