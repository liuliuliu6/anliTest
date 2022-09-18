package com.anli.po;

import lombok.Data;

/**
 * 计算器命令类
 */
@Data
public class CalculatorDTO {

    //第一个数字
    private String numA;

    //第二个数字
    private String numB;

    //运算符
    private String calculateType;

    public CalculatorDTO(){}

    //构造方法
    public CalculatorDTO(String numA, String numB) {
        this.numA = numA;
        this.numB = numB;
    }

}
