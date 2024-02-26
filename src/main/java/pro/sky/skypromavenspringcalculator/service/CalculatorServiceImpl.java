package pro.sky.skypromavenspringcalculator.service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public String calculator() {
        return "Добро пожаловать в калькулятор";
    }
    public Integer plus(Integer num1, Integer num2) throws BadRequestException {
        checkNullNums(num1, num2);
        return num1 + num2;
    }
    public Integer minus(Integer num1, Integer num2) throws BadRequestException {
        checkNullNums(num1, num2);
        return num1 - num2;
    }
    public Integer multiply(Integer num1, Integer num2) throws BadRequestException {
        checkNullNums(num1, num2);
        return num1 * num2;
    }
    public Integer divide(Integer num1, Integer num2) throws BadRequestException {
        checkNullNums(num1, num2);
        if (num2 == 0) {
            throw new IllegalArgumentException("На 0 делить нельзя!");
        }
        return num1 / num2;
    }

    private void checkNullNums(Integer num1, Integer num2) throws BadRequestException {
        if (num1 == null || num2 == null) {
            throw new BadRequestException();
        }
    }

}
