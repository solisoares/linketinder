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

    void update(String newName, String newEmail,
                String newCountry, String newState,
                Long newCep, String newDescription,
                Long newCpf, Integer newAge,
                List<String> newSkills)
    {
        // Get original fields for Elvis Check
        String originalName = getName()
        String originalEmail = getEmail()
        String originalCountry = getCountry()
        String originalState = getState()
        Long originalCep = getCep()
        String originalDescription = getDescription()
        Long originalCpf = getCpf()
        Integer originalAge = getAge()
        List<String> originalSkills = getSkills()

        // Set new fields if they are of type Groovy-Truth
        setName(newName?:originalName)
        setEmail(newEmail?:originalEmail)
        setCountry(newCountry?:originalCountry)
        setState(newState?:originalState)
        setCep(newCep?:originalCep)
        setDescription(newDescription?:originalDescription)
        setCpf(newCpf?:originalCpf)
        setAge(newAge?:originalAge)
        setSkills(newSkills?:originalSkills)
    }
}


