package com.anli.Service.impl;

import com.anli.Service.Command;
import com.anli.po.CalculatorDTO;

import java.math.BigDecimal;

/**
 * 乘法
 */
public class MultiCommand extends CalculatorDTO implements Command {


    public MultiCommand(String numA, String numB) {
        super(numA, numB);
        setCalculateType("*");
    }

    @Override
    public void execute() {
        System.out.println("执行乘法:" + toString());

        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());

        BigDecimal result = A.multiply(B);
        System.out.println("结果为:"+ result);
    }

    @Override
    public void redo() {
        System.out.println("执行除法 REDO操作:" + toString());

        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());

        BigDecimal result = A.multiply(B);
        System.out.println("结果为:"+ result);
    }

    @Override
    public void undo() {
        System.out.println("执行除法 UNDO操作:" + toString());

        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());

        BigDecimal result = A.multiply(B);
        System.out.println("结果为:"+ result);
    }

    @Override
    public String toString() {
        return "" + this.getNumA() + this.getCalculateType() + this.getNumB();
    }
}
