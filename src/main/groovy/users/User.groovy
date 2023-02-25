package users


abstract class User {
    String name
    String email
    String country
    String state
    Long cep  // Brazilian postal code abbreviation
    String description

    User(String name, String email, String country, String state, Long cep, String description) {
        this.name = name
        this.email = email
        this.country = country
        this.state = state
        this.cep = cep
        this.description = description
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
