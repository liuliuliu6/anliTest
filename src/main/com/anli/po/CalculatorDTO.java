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

    //结果
    private String result;

    public CalculatorDTO(){}

    //构造方法
    public CalculatorDTO(String numA, String numB) {
        this.numA = numA;
        this.numB = numB;
    }

    //构造方法
    public CalculatorDTO(String numA, String numB, String calculateType) {
        this.numA = numA;
        this.numB = numB;
        this.calculateType = calculateType;
    }

    //构造方法
    public CalculatorDTO(String numA, String numB, String calculateType, String result) {
        this.numA = numA;
        this.numB = numB;
        this.calculateType = calculateType;
        this.result = result;
    }


        /**
         * 保存状态
         */
    public CalculatorDTO save() {
        return new CalculatorDTO(this.numA, this.numB, this.calculateType, this.result);
    }

    /**
     * 恢复状态
     */
    public void restore(CalculatorDTO calculatorDTO) {
        this.numA = calculatorDTO.getNumA();
        this.numB = calculatorDTO.getNumB();
        this.calculateType = calculatorDTO.getCalculateType();
        this.result = calculatorDTO.getResult();
    }

}
