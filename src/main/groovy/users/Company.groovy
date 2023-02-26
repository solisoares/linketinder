package users

class Company extends User{
    Long cnpj  // brazilian employer identification number

    Company(String name, String email,
            String country, String state,
            Long cep, String description,
            Long cnpj, List<String> skills) {
        super(name, email, country, state, cep, description, skills)
        this.cnpj = cnpj
    }


    @Override
    public String toString() {
        return """\
Company{
    cnpj=$cnpj,
    requiredSkills=$skills,
    super=${super.toString()}
}"""
    }
}