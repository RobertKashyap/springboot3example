package com.springboot3example;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // provides spring MVC features
@RequestMapping("/api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        SpringApplication.run(Main.class, args);// starts a basic tomcat server
    }

    /*
     * @GetMapping("/greet")
     * public GreetResponse greet() {
     * GreetResponse response = new GreetResponse(
     * "Hello",
     * new Person("Robert", 24, 30_000.05),
     * List.of("java", "ASM", "Bfck"));
     * return response;
     * }
     * 
     * // POJO blueprint to return JSON data via rest annotation (via jackson
     * library,
     * // json parser for java)
     * record GreetResponse(
     * String greet,
     * Person person,
     * List<String> favProgLang) {
     * }
     * 
     * record Person(String name, int age, double savings) {
     * }
     */
    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age) {
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer age) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            // Update fields only if the corresponding parameters are provided
            if (name != null) {
                customer.setName(name);
            }

            if (email != null) {
                customer.setEmail(email);
            }

            if (age != null) {
                customer.setAge(age);
            }

            customerRepository.save(customer);
        }
    }

    //another way to update via RequestBody instead of parameters
    // @PutMapping("{customerId}")
    // public void updateCustomer(
    // @PathVariable("customerId") Integer id,
    // @RequestBody NewCustomerRequest request) {
    // Customer customer = customerRepository.findById(id).get();
    // customer.setName(request.name());
    // customer.setEmail(request.email());
    // customer.setAge(request.age());
    // customerRepository.save(customer);
    // }
}
