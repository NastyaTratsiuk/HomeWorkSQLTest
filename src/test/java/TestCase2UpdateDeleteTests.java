
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import services.AuthorTable;
import services.ProjectTable;
import services.TestTable;
import utils.Config;
import utils.SortUtils;

import java.sql.Timestamp;

public class TestCase2UpdateDeleteTests{

    @BeforeClass
    public void sortAndInputListTests() {
        TestTable.listTestsForUpdateDelete(TestTable.getAllTest());
        TestTable.insertSortListTests(SortUtils.sortListTestsByID(TestTable.getAllTest()));
    }

    @Test
    public void testCase1Pass() {
       Assert.assertTrue(true);
    }

    @Test
    public void testCase2Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase3Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase4Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase5Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase6Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase7Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase8Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase9Pass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase10Pass() {
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void updateTests(ITestResult result) {
        long getStartTime = result.getTestContext().getStartDate().getTime();
        Timestamp testStartTime = new Timestamp(getStartTime);
        long getEndTime = result.getTestContext().getStartDate().getTime();
        Timestamp testEndTime = new Timestamp(getEndTime);
        models.Test newTest = new models.Test(result.getName(), result.getStatus(), result.getMethod().getMethodName(),
                ProjectTable.getIdProject(), 4, testStartTime, testEndTime, Config.env, Config.browser,
                AuthorTable.getIdAuthor());
        TestTable.listsAfterIResultTest.add(newTest);
    }

    @AfterTest
    public void deleteTestsBeforeMethod() {
        TestTable.updateTestAfterIResultTest(TestTable.listForUpdateAndDeleteAfterInput, TestTable.listsAfterIResultTest);
        for (int i = 0; i < TestTable.listForUpdateAndDeleteAfterInput.size(); i++) {
            Assert.assertEquals(TestTable.deleteTest(TestTable.listForUpdateAndDeleteAfterInput.get(i)), 0,
                    "The test was not deleted.");
        }
    }
}