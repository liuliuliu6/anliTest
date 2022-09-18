package com.anli.Service.impl;

import com.anli.Service.Command;
import com.anli.po.CalculatorDTO;

import java.math.BigDecimal;

/**
 * 减法
 */
public class SubtractCommand extends CalculatorDTO implements Command {

    public SubtractCommand(String numA, String numB) {
        super(numA, numB);
        setCalculateType("-");
    }

    @Override
    public void execute() {
        System.out.println("执行减法:" + toString());

        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());

        BigDecimal result = A.subtract(B);
        System.out.println("结果为:"+ result);
    }

    @Override
    public void redo() {
        System.out.println("执行减法 REDO操作:" + toString());

        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());

        BigDecimal result = A.subtract(B);
        System.out.println("结果为:"+ result);
    }

    @Override
    public void undo() {
        System.out.println("执行减法 UNDO操作:" + toString());
        double x1 = Double.parseDouble(this.getNumA()); //转化为double类型
        double x2 = Double.parseDouble(this.getNumB());
        System.out.println("结果为" + (x1 - x2));
    }

    @Override
    public String toString() {
        return "" + this.getNumA() + this.getCalculateType() + this.getNumB();
    }
}
