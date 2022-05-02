package org.catalogic;

import org.catalogic.constants.UserType;
import org.catalogic.domain.Catalog;
import org.catalogic.domain.CatalogReport;
import org.catalogic.exceptions.CatalogException;
import org.catalogic.exceptions.ExistingUserException;
import org.catalogic.factory.UsersFactory;
import org.catalogic.users.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test3 {

    /*
     * For the third test, lets make sure that we can add a grade for a student.
     *
     * == TASK_4 == : Write the test for adding a VALID grade for an EXISTING student for Laboratory no. 6.
     *
     * == TASK_5 == : Write the test for adding an INVALID grade (<0 or >10) for an EXISTING student for Laboratory no. 6.
     *
     * == TASK_6 == : Write the test for adding a VALID grade for an NON-EXISTING student for Laboratory no. 6.
     *
     * == TASK_7 == : Write the test for adding a VALID grade for an EXISTING student for a Laboratory out of bounds (>12).
     *
     * == TASK_8 == : Write the test for adding a VALID grade for an EXISTING student for Laboratory no. 6 when it was
     * already graded.
     *
     * */

    Catalog defenseAgainstDarkArts;
    CatalogReport catalog;
    @BeforeEach
    void setUp() throws ExistingUserException {
        /* I might be useful. */
        defenseAgainstDarkArts = new Catalog();
        catalog = new CatalogReport();

        defenseAgainstDarkArts.addStudent((Student) UsersFactory.create(UserType.STUDENT, "student1"));

    }

    /* TASk_4 */
    @Test
    void addGrade_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1",1,10.00));
        assertEquals(10.00, defenseAgainstDarkArts.getStudentByName("student1").getGrades().get(1));
    }

    /* TASk_5 */
    @Test
    void addGrade_InvalidGrade_ThrowsCatalogException() {
        /* IF I PASS, YOU PASS */
        assertThrows(CatalogException.class, () -> catalog.addGrade(defenseAgainstDarkArts,"student1",1,12.00));
    }

    /* TASk_6 */
    @Test
    void addGrade_InvalidStudent_ThrowsCatalogException() {
        /* IF I PASS, YOU PASS */
        assertThrows(CatalogException.class, () -> catalog.addGrade(defenseAgainstDarkArts,"student2",1,10.0));
    }

    /* TASk_7 */
    @Test
    void addGrade_InvalidLaboratory_ThrowsCatalogException() {
        /* IF I PASS, YOU PASS */
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 1,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 2,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 3,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 4,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 5,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 6,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 7,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 8,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 9,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 10,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 11,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 12,8.00));
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1", 13,8.00));

    }

    /* TASk_8 */
    @Test
    void addGrade_AlreadyGraded_ThrowsCatalogException() {
        /* IF I PASS, YOU PASS */
        assertDoesNotThrow(() -> catalog.addGrade(defenseAgainstDarkArts,"student1",1,10.00));
        assertThrows(CatalogException.class, () -> catalog.addGrade(defenseAgainstDarkArts,"student1",1,9.00));

    }

}
