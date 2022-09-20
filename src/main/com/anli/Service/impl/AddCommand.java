package com.anli.Service.impl;

import com.anli.Service.Command;
import com.anli.po.CalculatorDTO;
import lombok.Data;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Stack;

/**
 * 加法命令类
 */
@Data
public class AddCommand extends CalculatorDTO implements Command {


    public AddCommand(String numA, String numB) {
        super(numA, numB);
        setCalculateType("+");
    }

    @Override
    public String execute() {
        System.out.println("执行加法 操作:" + toString());
        String firstNum = this.getNumA();
        String secondNum = this.getNumB();
        //判断是否为数字
        if(isNumeric(firstNum) && isNumeric(secondNum)){
            //TODO 暂未考虑负号  和 小数，目前只支持正整数
            return myAddMethod(firstNum, secondNum);
        }
        return "计算异常";

    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }


    public String myAddMethod(String firstNumStr, String secondNumStr){
        Stack<Integer> firstNumStack = new Stack<>();
        Stack<Integer> secondNumStack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        getNumStack(firstNumStr, firstNumStack);
        getNumStack(secondNumStr, secondNumStack);
        int maxLen = 0;
        if (firstNumStack.size() >= secondNumStack.size()) {
            maxLen = firstNumStack.size();
        } else {
            maxLen = secondNumStack.size();
        }
        int carry = 0;
        int firstNum;
        int secondNum;
        int tmpSum;
        while (maxLen != 0) {
            try {
                firstNum = firstNumStack.pop();
            } catch (Exception e1) {
                firstNum = 0;
            }
            try {
                secondNum = secondNumStack.pop();
            } catch (Exception e2) {
                secondNum = 0;
            }
            tmpSum = firstNum + secondNum + carry;
            carry = tmpSum / 10;
            sum.push(tmpSum % 10);
            maxLen -- ;
        }
        if (carry != 0) {
            sum.push(carry);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (sum.size() != 0) {
            stringBuffer.append(String.valueOf(sum.pop()));
        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * 字符串转化为栈
     * @param secondNum
     * @param numStack
     */
    private void getNumStack(String secondNum, Stack<Integer> numStack) {
        char[] intChar = secondNum.toCharArray();
        for (char num : intChar) {
            numStack.push(Character.getNumericValue(num));
        }
    }



    @Override
    public String redo() {
        System.out.println("执行加法 REDO操作:" + toString());
        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());
        BigDecimal result = A.add(B);
        System.out.println("结果为：" + result);
        return "" + result;
    }

    @Override
    public String undo() {
        System.out.println("执行加法 UNDO操作:" + toString());
        BigDecimal A  = new BigDecimal(this.getNumA());
        BigDecimal B  = new BigDecimal(this.getNumB());
        BigDecimal result = A.add(B);
        System.out.println("结果为：" + result);
        return "" + result;
    }

    @Override
    public String toString() {
        return "运算式：" + this.getNumA() + this.getCalculateType() + this.getNumB();
    }
}
