package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicantListTest {

    UserList applicantList = new ApplicantList();
    Applicant ap1, ap2;


    @BeforeEach
    void setUp() {
        ap1 = new Applicant(
                "Applicant1", "applicant1@ap.com",
                "Country1", "State1",
                1111111L, "Applicant1 description",
                11111111111L, 21, Arrays.asList("Python", "Java"));
        ap2 = new Applicant(
                "Applicant2", "applicant2@ap.com",
                "Country2", "State2",
                2222222L, "Applicant2 description",
                22222222222L, 22, Arrays.asList("React", "TypeScript"));

        applicantList.add(ap1);
        applicantList.add(ap2);

    }

    @Test
    void getApplicants() {
        //given
        Applicant ap1, ap2;
        List<User> applicants;

        //when
        applicants = applicantList.getAll();
        ap1 = (Applicant) applicants.get(0);
        ap2 = (Applicant) applicants.get(1);

        //then
        assertEquals("Applicant1", ap1.getName());
        assertEquals("Applicant2", ap2.getName());
    }

    @Test
    void testAddApplicants() {
        //given
        Applicant ap42 = new Applicant(
                "Applicant42", "applicant42@ap.com",
                "Country42", "State42",
                42L, "Applicant42 description",
                42L, 21, Arrays.asList("Skill42a", "Skill42b"));

        //when
        applicantList.add(ap42);

        //then
        assertEquals(3, applicantList.count());
        assertEquals(ap42, applicantList.getAll().get(applicantList.count() - 1));
    }

    @Test
    void testGetApplicant() {
        //given
        String applicantName = "Applicant1";

        //when
        Applicant applicant = (Applicant) applicantList.get(applicantName);

        //then
        assertEquals("Applicant1", applicant.getName());
    }

    @Test
    void testGetApplicantException() {
        //given
        String applicantName = "Name not present";

        //when & then
        assertThrows(NoSuchElementException.class, () -> {
            applicantList.get(applicantName);
        });
    }

    @Test
    void testGetApplicantsBySkill() {
        //given
        String skill = "Python";

        //when
        List<User> applicantsPython = applicantList.getBySkill(skill);

        //then
        assertEquals(1, applicantsPython.size());
        assertEquals("Applicant1", applicantsPython.get(0).getName());
    }

    @Test
    void testGetApplicantsBySkillException() {
        //given
        String skill = "Skill not present";

        //when & then
        assertThrows(NoSuchElementException.class, () -> {
            applicantList.getBySkill(skill);
        });
    }
}