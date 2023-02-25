package users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


class AplicantTest {

    Aplicant aplicant;

    @BeforeEach
    void testSetUp() {
        aplicant = new Aplicant(
                "Aplicant1", "aplicant1@ap.com",
                "Country1", "State1",
                1111111L, "Aplicant1 description",
                11111111111L, 21,Arrays.asList("Skill1a", "Skill1b"));
    }

    @Test
    void testGetName() {
        assertEquals("Aplicant1", aplicant.getName());
    }

    @Test
    void testSetName() {
        aplicant.setName("Renamed");
        assertEquals("Renamed", aplicant.getName());
    }

    @Test
    void testGetEmail() {
        assertEquals("aplicant1@ap.com", aplicant.getEmail());
    }

    @Test
    void testSetEmail() {
        aplicant.setEmail("Renamed");
        assertEquals("Renamed", aplicant.getEmail());
    }

    @Test
    void testGetCountry() {
        assertEquals("Country1", aplicant.getCountry());
    }

    @Test
    void testSetCountry() {
        aplicant.setCountry("Renamed");
        assertEquals("Renamed", aplicant.getCountry());
    }

    @Test
    void testGetState() {
        assertEquals("State1", aplicant.getState());
    }

    @Test
    void testSetState() {
        aplicant.setState("Renamed");
        assertEquals("Renamed", aplicant.getState());
    }

    @Test
    void testGetCep() {
        assertEquals(1111111L, aplicant.getCep());
    }

    @Test
    void testSetCep() {
        aplicant.setCep(10000000L);
        assertEquals(10000000L, aplicant.getCep());
    }

    @Test
    void testGetDescription() {
        assertEquals("Aplicant1 description", aplicant.getDescription());
    }

    @Test
    void testSetDescription() {
        aplicant.setDescription("Renamed");
        assertEquals("Renamed", aplicant.getDescription());
    }

    @Test
    void testGetCpf() {
        assertEquals(11111111111L, aplicant.getCpf());
    }

    @Test
    void testSetCpf() {
        aplicant.setCpf(10000000000L);
        assertEquals(10000000000L, aplicant.getCpf());
    }

    @Test
    void testGetAge() {
        assertEquals(21, aplicant.getAge());
    }

    @Test
    void testSetAge() {
        aplicant.setAge(100);
        assertEquals(100, aplicant.getAge());
    }

    @Test
    void testGetSkills() {
        assertEquals(Arrays.asList("Skill1a", "Skill1b"), aplicant.getSkills());
    }

    @Test
    void testSetSkills() {
        aplicant.setSkills(Arrays.asList("Renamed", "Renamed"));
        assertEquals(Arrays.asList("Renamed", "Renamed"), aplicant.getSkills());
    }
}