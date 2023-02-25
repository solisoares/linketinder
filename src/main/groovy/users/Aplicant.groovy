package users


class Aplicant extends User {
    Long cpf  // brazilian social security number
    Integer age
    List<String> skills

    Aplicant(String name, String email,
             String country, String state,
             Long cep, String description,
             Long cpf, Integer age,
             List<String> skills) {
        super(name, email, country, state, cep, description)
        this.cpf = cpf
        this.age = age
        this.skills = skills
    }


    @Override
    public String toString() {
        return """\
Aplicant{
    cpf=$cpf,
    age=$age,
    skills=$skills,
    super=${super.toString()}
}"""
    }
}


