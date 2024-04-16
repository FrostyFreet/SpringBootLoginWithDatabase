package com.website;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
public class WebsiteApplication {
	private static final Logger logger = LoggerFactory.getLogger(WebsiteApplication.class);
	private StudentsRepository studentsRepository;
	@Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
       return "index.html";
	}
	@Controller
	public class LoginController {
		@GetMapping("/login")
		public String login() {
			return "login"; // Returns the name of the Thymeleaf template "login.html"
		}
	}
	@Controller
	public class RegisterController {
		@GetMapping("/register")
		public String register() {
			return "register"; // Returns the name of the Thymeleaf template "register.html"
		}
	}
	@Controller
	public class loggedInController {
		 @GetMapping("/loggedIn")
		public String loggedIn() {
			 return "loggedIn"; // Returns the name of the Thymeleaf template "loggedIn.html"
		 }
	}

	@PostMapping("/register")
	public String Register(@ModelAttribute Students students) {
		studentsRepository.save(students);
		return "redirect:/";
	}
	@PostMapping("/login")
	public String Login(@ModelAttribute Students students) {
	Students found=studentsRepository.findByUsername(students.getUsername());
	if(found!=null){
		if(found.getPassword().equals(students.getPassword())){
            return "redirect:/loggedIn";
        }
        else{
            return "redirect:/login";
        }
	}
		return "redirect:/loggedIn";
	}
}
