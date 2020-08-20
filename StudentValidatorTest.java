package saichand.validationtest;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import saichand.entity.Student;
import saichand.repository.CourseRepository;
import saichand.validation.StudentValidator;
import org.junit.Test;



public class StudentValidatorTest {



    @Autowired
    StudentValidator testobj;
    @Autowired
    Student studobj;


    @Test
    public void isValidFnameTest()
    {
        Assert.assertEquals(testobj.isValidFname("saichand"), true);
        Assert.assertEquals(testobj.isValidFname("saich1234"), false);
        Assert.assertEquals(testobj.isValidFname("123456"), false);
    }
    @Test
    public void isValidLnameTest()
    {
        Assert.assertEquals(testobj.isValidLname("Gatram"), true);
        Assert.assertEquals(testobj.isValidLname(""), true);
        Assert.assertEquals(testobj.isValidLname(null), true);
        Assert.assertEquals(testobj.isValidLname("123456"), false);
    }
    @Test
    public void isVaLidEmailTest()
    {
        Assert.assertEquals(testobj.isValidEmail("saichand.gatram@seamless.se"), true);
        Assert.assertEquals(testobj.isValidEmail("saichand.gatram@@seamless.se"), false);
        Assert.assertEquals(testobj.isValidEmail("1234gatramsaichand@gmail.com"), false);
    }
    @Test
    public void isPhoneValidTest()
    {
        Assert.assertEquals(testobj.isValidPhone("9398284963"), true);
        Assert.assertEquals(testobj.isValidPhone("00987652431"), false);
        Assert.assertEquals(testobj.isValidPhone("98231456234223"), false);
        Assert.assertEquals(testobj.isValidPhone("919398284963"), true);
    }

    @Test
    public void isValidCidTest()
    {
        Assert.assertEquals(testobj.isValidCid(1), true);
        Assert.assertEquals(testobj.isValidCid(100), false);
    }

    @Test
    public void isValidStudentTest()
    {
        studobj = new Student("saichand", "gatram", "1234@gmail.com", "9398284963", 2);
        Assert.assertEquals(testobj.isStudentValid(studobj), false);
    }
}
