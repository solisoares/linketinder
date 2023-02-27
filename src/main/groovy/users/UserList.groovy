package users

abstract class UserList {
    List<User> users = new ArrayList<>()

    List<User> getAll() {
        return users
    }

    Integer count() {
        return users.size()
    }

    void add(User user) {
        users.add(user)
    }

    void remove(User user) {
        users.remove(user)
    }

    User get(String name) throws NoSuchElementException {
        User user

        users.each { ap ->
            if (ap.getName() == name)
                user = ap
        }

        if (!user)
            throw new NoSuchElementException("The User is not present")

        return user
    }

    List<User> getBySkill(String skill) {
        List<User> usersBySkill = []
        users.each { ap ->
            if (skill in ap.getSkills())
                usersBySkill << ap
        }

        if (!usersBySkill)
            throw new NoSuchElementException("There are no users with this skill")

        return usersBySkill
    }
}
