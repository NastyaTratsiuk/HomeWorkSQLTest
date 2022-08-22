import models.Author;
import models.Project;
import models.Session;
import models.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import services.AuthorTable;
import services.ProjectTable;
import services.SessionTable;
import services.TestTable;
import utils.Config;

import java.sql.*;

public class TestCase1InsertTest {

    @org.testng.annotations.Test
    public void testCasePass() {
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void inputNewTest(ITestResult result) {
        Author author = new Author(Config.authorName, Config.authorLogin, Config.authorEmail);
        AuthorTable.insertAuthor(author);
        Project project = new Project(result.getTestContext().getName());
        ProjectTable.insertProject( project);
        long getStartTime = result.getTestContext().getStartDate().getTime();
        Timestamp testStartTime = new Timestamp(getStartTime);
        Session session = new Session(result.id(), testStartTime, Integer.parseInt(Config.sessionNumber));
        SessionTable.insertSession( session);
        long getEndTime = result.getTestContext().getStartDate().getTime();
        Timestamp testEndTime = new Timestamp(getEndTime);
        Test test = new Test(result.getName(), result.getStatus(), result.getMethod().getMethodName(), project.getId(),
                session.getId(), testStartTime, testEndTime, Config.env, Config.browser, author.getId());
        Assert.assertNotEquals(TestTable.insertTest(test), 0,
                "The test was not added.");
    }
}