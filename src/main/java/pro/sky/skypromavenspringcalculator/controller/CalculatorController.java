package pro.sky.skypromavenspringcalculator.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypromavenspringcalculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String calculator() {
        return calculatorService.calculator();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(value = "num1") Integer num1,
                       @RequestParam(value = "num2") Integer num2) throws BadRequestException {
        if (num1 == null || num2 == null) {
            throw new BadRequestException();
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }
    @GetMapping(path = "/minus")
    public String minus(@RequestParam(value = "num1") Integer num1,
                        @RequestParam(value = "num2") Integer num2) throws BadRequestException {
        if (num1 == null || num2 == null) {
            throw new BadRequestException();
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }
    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(value = "num1") Integer num1,
                           @RequestParam(value = "num2") Integer num2) throws BadRequestException {
        if (num1 == null || num2 == null) {
            throw new BadRequestException();
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }
    @GetMapping(path = "/divide")
    public String divide(@RequestParam(value = "num1") Integer num1,
                         @RequestParam(value = "num2") Integer num2) throws BadRequestException {
        if (num1 == null || num2 == null) {
            throw new BadRequestException();
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }

}
