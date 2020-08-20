package saichand.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saichand.entity.Student;
import saichand.repository.CourseRepository;
import saichand.response.StudentResponse;
import  java.util.regex.*;

@Component
public class StudentValidator {


    @Autowired
    CourseRepository courserepo;

    public boolean isValidFname(String fname)
    {
        return ((!fname.equals(""))&&(fname != null)&&(fname.matches("^[a-zA-Z]*$")));
    }

    public boolean isValidLname(String lname)
    {
        if(lname == null) return true;
        return (lname.matches("^[a-zA-Z]*$"));
    }

    public boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public boolean isValidPhone(String phone)
    {
        Pattern pat = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = pat.matcher(phone);
        return (m.find() && m.group().equals(phone));
    }

    public boolean isValidCid(Integer cid)
    {
        if(courserepo.findById(cid) != null)
        {
            return true;
        }
        return false;
    }

    public StudentResponse isStudentValid(Student student)
    {
        String firstname = student.getFirstname();
        String lastname = student.getLastname();
        String emailid = student.getEmailid();
        String phone = student.getPhone();
        Integer cid = student.getCid();
        StudentResponse sr = new StudentResponse();
        boolean passed = true;
        if(isValidFname(firstname))
        {
            sr.setFirstname(firstname);
        }
        else
        {
            sr.setFirstname("First Name can't be empty and only contains alphabets");
            passed = false;
        }
        if(isValidLname(lastname))
        {
            sr.setLastname(lastname);
        }
        else
        {
            sr.setLastname("Last Name can't contain numbers");
            passed = false;
        }
        if(isValidEmail(emailid))
        {
            sr.setEmailid(emailid);
        }
        else
        {
            sr.setEmailid("Email id entered is invalid");
            passed = false;
        }
        if(isValidPhone(phone))
        {
            sr.setPhone(phone);
        }
        else
        {
            sr.setPhone("Phone number enterd is invalid");
            passed = false;
        }
        if(isValidCid(cid))
        {
            sr.setCid(cid.toString());
        }
        else
        {
            sr.setCid("The Course doesn't exists");
            passed = false;
        }
        if(passed)
        {
            sr.setEntry("Succesfully Registered");
        }
        else
        {
            sr.setEntry("Try Again");
        }
        return sr;
    }
}
