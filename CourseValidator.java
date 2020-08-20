package saichand.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saichand.entity.Course;
import saichand.response.CourseResponse;

@Component
public class CourseValidator {



    public boolean isNameValid(String name)
    {
        return ((!name.equals(""))&&(name != null)&&(name.matches("^[a-zA-Z]*$")));
    }
    public boolean isDurationValid(Integer duration)
    {
        return (duration > 0 && duration<=60);
    }


    public CourseResponse isCourseValid(Course course)
    {
        String name = course.getCoursename();
        Integer duration = course.getCourseduration();
        Boolean passed = true;
        CourseResponse cr = new CourseResponse();
        if(isNameValid(name))
        {
            cr.setCoursename(name);
        }
        else
        {
            cr.setCoursename("Course Name cant contain numeric");
            passed = false;
        }
        if(isDurationValid(duration))
        {
            cr.setCourseduration(duration.toString());

        }
        else
        {
            cr.setCourseduration("Course Duration can be greater than 60 months");
            passed = false;
        }
        if(passed)
        {   cr.setEntry("Succesfully Registered");

        }
        else
        {
            cr.setEntry("Try Again");
        }
        return cr;
    }
}
