package users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


class ApplicantTest {

    Applicant applicant;

    @BeforeEach
    void testSetUp() {
        applicant = new Applicant(
                "Applicant1", "applicant1@ap.com",
                "Country1", "State1",
                1111111L, "Applicant1 description",
                11111111111L, 21,Arrays.asList("Skill1a", "Skill1b"));
    }

    @Test
    void testGetName() {
        assertEquals("Applicant1", applicant.getName());
    }

    @Test
    void testSetName() {
        applicant.setName("Renamed");
        assertEquals("Renamed", applicant.getName());
    }

    @Test
    void testGetEmail() {
        assertEquals("applicant1@ap.com", applicant.getEmail());
    }

    @Test
    void testSetEmail() {
        applicant.setEmail("Renamed");
        assertEquals("Renamed", applicant.getEmail());
    }

    @Test
    void testGetCountry() {
        assertEquals("Country1", applicant.getCountry());
    }

    @Test
    void testSetCountry() {
        applicant.setCountry("Renamed");
        assertEquals("Renamed", applicant.getCountry());
    }

    @Test
    void testGetState() {
        assertEquals("State1", applicant.getState());
    }

    @Test
    void testSetState() {
        applicant.setState("Renamed");
        assertEquals("Renamed", applicant.getState());
    }

    @Test
    void testGetCep() {
        assertEquals(1111111L, applicant.getCep());
    }

    @Test
    void testSetCep() {
        applicant.setCep(10000000L);
        assertEquals(10000000L, applicant.getCep());
    }

    @Test
    void testGetDescription() {
        assertEquals("Applicant1 description", applicant.getDescription());
    }

    @Test
    void testSetDescription() {
        applicant.setDescription("Renamed");
        assertEquals("Renamed", applicant.getDescription());
    }

    @Test
    void testGetCpf() {
        assertEquals(11111111111L, applicant.getCpf());
    }

    @Test
    void testSetCpf() {
        applicant.setCpf(10000000000L);
        assertEquals(10000000000L, applicant.getCpf());
    }

    @Test
    void testGetAge() {
        assertEquals(21, applicant.getAge());
    }

    @Test
    void testSetAge() {
        applicant.setAge(100);
        assertEquals(100, applicant.getAge());
    }

    @Test
    void testGetSkills() {
        assertEquals(Arrays.asList("Skill1a", "Skill1b"), applicant.getSkills());
    }

    @Test
    void testSetSkills() {
        applicant.setSkills(Arrays.asList("Renamed", "Renamed"));
        assertEquals(Arrays.asList("Renamed", "Renamed"), applicant.getSkills());
    }
}