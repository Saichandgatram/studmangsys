package saichand.validationtest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import saichand.entity.Course;
import saichand.validation.CourseValidator;

public class CoursevalidatorTest {

    @Autowired
    CourseValidator testobj;

    @Autowired
    Course courseobj;

    @Test
    public void isNameValidTest()
    {
        Assert.assertEquals(testobj.isNameValid("ECE"), true);
        Assert.assertEquals(testobj.isNameValid("CSE"), true);
        Assert.assertEquals(testobj.isNameValid("MBA"), true);
        Assert.assertEquals(testobj.isNameValid("MBA1234"), false);
    }

    @Test
    public void isDurationValidTest()
    {
        Assert.assertEquals(testobj.isDurationValid(48), true);
        Assert.assertEquals(testobj.isDurationValid(60), true);
        Assert.assertEquals(testobj.isDurationValid(100), false);
        Assert.assertEquals(testobj.isDurationValid(-45), false);
        Assert.assertEquals(testobj.isDurationValid(0), false);

    }

    @Test
    public void isCourseValidTest()
    {
        courseobj = new Course("ECE", 48);
        Assert.assertEquals(testobj.isCourseValid(courseobj), true);
        courseobj.setCoursename("EA12");
        courseobj.setCourseduration(65);
        Assert.assertEquals(testobj.isCourseValid(courseobj), false);
    }

}
