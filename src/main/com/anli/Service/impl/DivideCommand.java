package com.anli.Service.impl;

import com.anli.Service.Command;
import com.anli.po.CalculatorDTO;

import java.math.BigDecimal;

/**
 * 除法
 */
public class DivideCommand extends CalculatorDTO implements Command {


    public DivideCommand(String numA, String numB) {
        super(numA, numB);
        setCalculateType("/");
    }

    @Override
    public String execute() {
        System.out.println("执行除法:" + toString());
        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());
        if(B.intValue() == 0){
            return "除数不能为0";
        }
        BigDecimal result = A.divide(B, 8, BigDecimal.ROUND_HALF_UP);
        return ""+ result.doubleValue();
    }

    @Override
    public String redo() {
        System.out.println("执行除法 REDO操作:" + toString());

        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());

        BigDecimal result = A.divide(B, 8, BigDecimal.ROUND_HALF_UP);
        System.out.println("结果为:"+ result.doubleValue());
        return "" + result.doubleValue();
    }

    @Override
    public String undo() {
        System.out.println("执行除法 UNDO操作:" + toString());

        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());

        BigDecimal result = A.divide(B, 8, BigDecimal.ROUND_HALF_UP);
        System.out.println("结果为:"+ result.doubleValue());
        return "" + result.doubleValue();
    }

    @Override
    public String toString() {
        return "" + this.getNumA() + this.getCalculateType() + this.getNumB();
    }
}
