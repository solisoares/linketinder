package users

class Company extends User{
    Long cnpj  // brazilian employer identification number
    List<String> requiredSkills

    Company(String name, String email,
            String country, String state,
            Long cep, String description,
            Long cnpj, List<String> requiredSkills) {
        super(name, email, country, state, cep, description)
        this.cnpj = cnpj
        this.requiredSkills = requiredSkills
    }


    @Override
    public String toString() {
        return """\
Company{
    cnpj=$cnpj,
    requiredSkills=$requiredSkills,
    super=${super.toString()}
}"""
    }
}