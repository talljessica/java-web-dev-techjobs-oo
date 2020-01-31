package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {

    Job test_job1, test_job2, test_job3, test_job4, test_job5;
    Employer test_employer;
    Location test_location;
    PositionType test_positionType;
    CoreCompetency test_coreCompetency;


    @Before
    public void createJobObject() {
        test_job1 = new Job("My job", new Employer("44BSquared"),new Location("Kansas City"), new PositionType("Recruiter"), new CoreCompetency("Motivated to excel."));
        test_job2 = new Job();
        test_employer = new Employer("ACME");
        test_location = new Location("Desert");
        test_positionType = new PositionType("Quality control");
        test_coreCompetency = new CoreCompetency("Persistence");
        test_job3 = new Job("Product tester", test_employer, test_location, test_positionType, test_coreCompetency);
        test_job4 = new Job("Product tester", test_employer, test_location, test_positionType, test_coreCompetency);
        test_job5 = new Job("", test_employer, test_location, test_positionType, test_coreCompetency);
    }

    @Test
    public void testSettingJobId() {
    assertEquals(1, test_job2.getId() - test_job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
    assertTrue(test_job3.getName() instanceof String);
    assertTrue(test_job3.getEmployer() instanceof Employer);
    assertTrue(test_job3.getLocation() instanceof Location);
    assertTrue(test_job3.getPositionType() instanceof PositionType);
    assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);

    assertEquals("Product tester", test_job3.getName());
    assertEquals(test_employer, test_job3.getEmployer());
    assertEquals(test_location, test_job3.getLocation());
    assertEquals(test_positionType, test_job3.getPositionType());
    assertEquals(test_coreCompetency, test_job3.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testToStringContainsBlankLineBeforeAndAfter() {
        String testString = test_job1.toString();
        assertTrue(testString.startsWith("\n"));
        assertTrue(testString.endsWith("\n"));
    }

    @Test
    public void testToStringPutsFieldLabelsAndDataOnSeperateLines() {
        String testString = test_job1.toString();
        assertTrue(testString.contains("Name: My job\n"));
        assertTrue(testString.contains("Employer: 44BSquared\n"));
        assertTrue(testString.contains("Location: Kansas City\n"));
        assertTrue(testString.contains("Position Type: Recruiter\n"));
        assertTrue(testString.contains("Core Competency: Motivated to excel.\n"));
    }

    @Test
    public void testToStringEmptyFieldsMessage() {
        String testString = test_job5.toString();
        assertTrue(testString.contains("Data not available."));
    }

    @Test
    public void testToStringHasIdOnlyMessage() {
        assertEquals("OOPS! This job does not seem to exist.", test_job2.toString());
    }
}
