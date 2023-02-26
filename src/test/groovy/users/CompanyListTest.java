package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompanyListTest {

    UserList companyList = new CompanyList();
    Company co1, co2;


    @BeforeEach
    void setUp() {
        co1 = new Company(
                "Company1", "company1@ap.com",
                "Country1", "State1",
                1111111L, "Company1 description",
                11111111111L, Arrays.asList("Python", "Java"));
        co2 = new Company(
                "Company2", "company2@ap.com",
                "Country2", "State2",
                2222222L, "Company2 description",
                22222222222L, Arrays.asList("React", "TypeScript"));

        companyList.add(co1);
        companyList.add(co2);

    }

    @Test
    void getCompanies() {
        //given
        Company co1, co2;
        List<User> companies;

        //when
        companies = companyList.getAll();
        co1 = (Company) companies.get(0);
        co2 = (Company) companies.get(1);

        //then
        assertEquals("Company1", co1.getName());
        assertEquals("Company2", co2.getName());
    }

    @Test
    void testAddCompanies() {
        //given
        Company ap42 = new Company(
                "Company42", "company42@ap.com",
                "Country42", "State42",
                42L, "Company42 description",
                42L, Arrays.asList("Skill42a", "Skill42b"));

        //when
        companyList.add(ap42);

        //then
        assertEquals(3, companyList.count());
        assertEquals(ap42, companyList.getAll().get(companyList.count() - 1));
    }

    @Test
    void testGetCompany() {
        //given
        String companyName = "Company1";

        //when
        Company company = (Company) companyList.get(companyName);

        //then
        assertEquals("Company1", company.getName());
    }

    @Test
    void testGetCompanyException() {
        //given
        String companyName = "Name not present";

        //when & then
        assertThrows(NoSuchElementException.class, () -> companyList.get(companyName));
    }

    @Test
    void testGetCompaniesBySkill() {
        //given
        String skill = "Python";

        //when
        List<User> companiesPython = companyList.getBySkill(skill);

        //then
        assertEquals(1, companiesPython.size());
        assertEquals("Company1", companiesPython.get(0).getName());
    }

    @Test
    void testGetCompaniesBySkillException() {
        //given
        String skill = "Skill not present";

        //when & then
        assertThrows(NoSuchElementException.class, () -> companyList.getBySkill(skill));
    }
}