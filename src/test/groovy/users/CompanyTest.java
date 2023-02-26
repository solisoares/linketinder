package users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company company;

    @BeforeEach
    void setUp() {
        company = new Company("Company1", "company1@co.com",
                "Country1", "State1",
                11111111L, "Company1 description",
                11111111111111L, Arrays.asList("Skill1a", "Skill1b"));
    }

    @Test
    void testGetName() {
        assertEquals("Company1", company.getName());
    }

    @Test
    void testSetName() {
        company.setName("Renamed");
        assertEquals("Renamed", company.getName());
    }

    @Test
    void testGetEmail() {
        assertEquals("company1@co.com", company.getEmail());
    }

    @Test
    void testSetEmail() {
        company.setEmail("Renamed");
        assertEquals("Renamed", company.getEmail());
    }

    @Test
    void testGetCountry() {
        assertEquals("Country1", company.getCountry());
    }

    @Test
    void testSetCountry() {
        company.setCountry("Renamed");
        assertEquals("Renamed", company.getCountry());
    }

    @Test
    void testGetState() {
        assertEquals("State1", company.getState());
    }

    @Test
    void testSetState() {
        company.setState("Renamed");
        assertEquals("Renamed", company.getState());
    }

    @Test
    void testGetCep() {
        assertEquals(11111111L, company.getCep());
    }

    @Test
    void testSetCep() {
         company.setCep(10000000L);
        assertEquals(10000000L, company.getCep());
    }

    @Test
    void testGetDescription() {
        assertEquals("Company1 description", company.getDescription());
    }

    @Test
    void testSetDescription() {
        company.setDescription("Renamed");
        assertEquals("Renamed", company.getDescription());
    }

    @Test
    void testGetCnpj() {
        assertEquals(11111111111111L, company.getCnpj());
    }

    @Test
    void testSetCnpj() {
        company.setCnpj(10000000000000L);
        assertEquals(10000000000000L, company.getCnpj());
    }

    @Test
    void testGetSkills() {
        assertEquals(Arrays.asList("Skill1a", "Skill1b"), company.getSkills());
    }

    @Test
    void testSetSkills() {
        company.setSkills(Arrays.asList("Renamed", "Renamed"));
        assertEquals(Arrays.asList("Renamed", "Renamed"), company.getSkills());
    }

    @Test
    void testUpdate() {
        //given
        String newName = "-- Renamed --";
        String newEmail = null;
        String newCountry = "-- Renamed --";
        String newState = null;
        Long newCep = 42L;
        String newDescription = null;
        Long newCnpj = 42L;
        List<String> newSkills = Arrays.asList("-- Renamed --", "-- Renamed --");


        //when
        company.update(newName, newEmail,
                newCountry, newState,
                newCep, newDescription,
                newCnpj, newSkills);

        //then
        assertEquals("-- Renamed --", company.getName());
        assertEquals("company1@co.com", company.getEmail());
        assertEquals("-- Renamed --", company.getCountry());
        assertEquals("State1", company.getState());
        assertEquals(42L, company.getCep());
        assertEquals("Company1 description", company.getDescription());
        assertEquals(42L, company.getCnpj());
        assertEquals(Arrays.asList("-- Renamed --", "-- Renamed --"), company.getSkills());
    }
}


