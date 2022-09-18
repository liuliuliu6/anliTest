package com.anli.Service.impl;

import com.anli.Service.Command;
import com.anli.po.CalculatorDTO;

/**
 * 加法命令类
 */

public class AddCommand extends CalculatorDTO implements Command {


    public AddCommand(String numA, String numB) {
        super(numA, numB);
        setCalculateType("+");
    }

    @Override
    public void execute() {
        System.out.println("执行加法 操作:" + toString());
        double x1 = Double.parseDouble(this.getNumA()); //转化为double类型
        double x2 = Double.parseDouble(this.getNumB());
        System.out.println("" + (x1 + x2));
    }

    @Override
    public void redo() {
        System.out.println("执行加法 REDO操作:" + toString());
        double x1 = Double.parseDouble(this.getNumA()); //转化为double类型
        double x2 = Double.parseDouble(this.getNumB());
        System.out.println("" + (x1 + x2));
    }

    @Override
    public void undo() {
        System.out.println("执行加法 UNDO操作:" + toString());
        double x1 = Double.parseDouble(this.getNumA()); //转化为double类型
        double x2 = Double.parseDouble(this.getNumB());
        System.out.println("结果为" + (x1 + x2));
    }

    @Override
    public String toString() {
        return "结果为" + this.getNumA() + this.getCalculateType() + this.getNumB();
    }
}
