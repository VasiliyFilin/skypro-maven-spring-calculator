package pro.sky.skypromavenspringcalculator.service;

import org.apache.coyote.BadRequestException;

public interface CalculatorService {
    String calculator();
    Integer plus(Integer num1, Integer num2) throws BadRequestException;
    Integer minus(Integer num1, Integer num2) throws BadRequestException;
    Integer multiply(Integer num1, Integer num2) throws BadRequestException;
    Integer divide(Integer num1, Integer num2) throws BadRequestException;
}
