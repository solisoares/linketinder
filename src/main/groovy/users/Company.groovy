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

    void update(String newName, String newEmail,
                String newCountry, String newState,
                Long newCep, String newDescription,
                Long newCnpj, List<String> newSkills)
    {
        // Get original fields for Elvis Check
        String originalName = getName()
        String originalEmail = getEmail()
        String originalCountry = getCountry()
        String originalState = getState()
        Long originalCep = getCep()
        String originalDescription = getDescription()
        Long originalCnpj = getCnpj()
        List<String> originalSkills = getSkills()

        // Set new fields if they are of type Groovy-Truth
        setName(newName?:originalName)
        setEmail(newEmail?:originalEmail)
        setCountry(newCountry?:originalCountry)
        setState(newState?:originalState)
        setCep(newCep?:originalCep)
        setDescription(newDescription?:originalDescription)
        setCnpj(newCnpj?:originalCnpj)
        setSkills(newSkills?:originalSkills)
    }
}