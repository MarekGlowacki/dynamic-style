package online.javafun.dynamicstyle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        BigDecimal averageSalary = employeeRepository.getAverageSalary();
        model.addAttribute("employees", employees);
        model.addAttribute("averageSalary", averageSalary);
        return "index";
    }
}
