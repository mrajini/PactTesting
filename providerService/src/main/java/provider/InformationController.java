package provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class InformationController {

    private Information information = new Information();

    @RequestMapping("/information")
    public Information information(@RequestParam(value="name", defaultValue="Mike") String name) {
        if (name.equals("Mike")) {
            HashMap contact = new HashMap<String, String>();
            contact.put("Email", "michael.mike@ariman.com");
            contact.put("Phone Number", "9090950");

            information.setContact(contact);
            information.setName("Micheal Mike");
            information.setSalary(45000);
            information.setNationality("Japan");
        }
      else {
            information.setContact(null);
            information.setName(name);
            information.setSalary(0);
        }

        return information;
    }
}
