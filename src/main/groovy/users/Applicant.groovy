package users


class Applicant extends User {
    Long cpf  // brazilian social security number
    Integer age

    Applicant(String name, String email,
             String country, String state,
             Long cep, String description,
             Long cpf, Integer age,
             List<String> skills) {
        super(name, email, country, state, cep, description, skills)
        this.cpf = cpf
        this.age = age
    }


    @Override
    public String toString() {
        return """\
Applicant{
    cpf=$cpf,
    age=$age,
    skills=$skills,
    super=${super.toString()}
}"""
    }
}


