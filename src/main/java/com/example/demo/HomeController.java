package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        //first lets create employee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("55555-12-12234");

        //Now lets create a ;laptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");

        //add the laptop to the employee
        employee.setLaptop(laptop);

        //save the employee to the dataase
        employeeRepository.save(employee);

        //Grab all the employess from the databasea nd send them to
        //the template
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
}
