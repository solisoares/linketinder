package users


abstract class User {
    String name
    String email
    String country
    String state
    Long cep  // Brazilian postal code abbreviation
    String description
    List<String> skills

    User(String name, String email, String country, String state, Long cep, String description, List<String> skills) {
        this.name = name
        this.email = email
        this.country = country
        this.state = state
        this.cep = cep
        this.description = description
        this.skills = skills
    }


    @Override
    String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", cep=" + cep +
                ", description='" + description + '\'' +
                '}';
    }
}
