package com.anli;


import com.anli.Service.MementoCaretaker;
import com.anli.Service.impl.AddCommand;
import com.anli.Service.impl.DivideCommand;
import com.anli.Service.impl.MultiCommand;
import com.anli.Service.impl.SubtractCommand;
import com.anli.po.CalculatorDTO;

public class CalculatorV2 {

    public static int index = -1;
    private static MementoCaretaker mc = new MementoCaretaker();

    public static void main(String[] args) {
        CalculatorDTO calculatorDTO = new CalculatorDTO("6", "8", "+");
        handle(calculatorDTO);

        calculatorDTO.setNumA("8");
        calculatorDTO.setNumB("3");
        calculatorDTO.setCalculateType("-");
        handle(calculatorDTO);

        calculatorDTO.setNumA("4");
        calculatorDTO.setNumB("3");
        calculatorDTO.setCalculateType("*");
        handle(calculatorDTO);

        calculatorDTO.setNumA("8");
        calculatorDTO.setNumB("2");
        calculatorDTO.setCalculateType("/");
        handle(calculatorDTO);

        System.out.println("执行第一次REDO");
        undo(calculatorDTO, index);
        System.out.println("执行第二次REDO");
        undo(calculatorDTO, index);
        System.out.println("执行第一次UNDO");
        redo(calculatorDTO, index);
        System.out.println("执行第二次UNDO");
        redo(calculatorDTO, index);

    }


    public static void handle(CalculatorDTO calculatorDTO) {
        if ("+".equals(calculatorDTO.getCalculateType())) {
            calculatorDTO.setResult(new AddCommand(calculatorDTO.getNumA(), calculatorDTO.getNumB()).execute());
        } else if ("-".equals(calculatorDTO.getCalculateType())) {
            calculatorDTO.setResult(new SubtractCommand(calculatorDTO.getNumA(), calculatorDTO.getNumB()).execute());
        } else if ("*".equals(calculatorDTO.getCalculateType())) {
            calculatorDTO.setResult(new MultiCommand(calculatorDTO.getNumA(), calculatorDTO.getNumB()).execute());
        } else if ("/".equals(calculatorDTO.getCalculateType())) {
            calculatorDTO.setResult(new DivideCommand(calculatorDTO.getNumA(), calculatorDTO.getNumB()).execute());
        } else {
            calculatorDTO.setResult("计算格式有误");
        }
        // 保存备忘录
        mc.setMemento(calculatorDTO.save());
        index++;

        showCommand(calculatorDTO);
    }

    //回退
    public static void undo(CalculatorDTO calculatorDTO, int i) {
        System.out.println("******UNDO******");
        index--;
        // 撤销到上一个备忘录
        calculatorDTO.restore(mc.getMemento(i - 1));

        showCommand(calculatorDTO);
    }

    /**
     * 撤销回退
     */
    public static void redo(CalculatorDTO calculatorDTO, int i) {
        System.out.println("******REDO******");
        index++;
        // 恢复到下一个备忘录
        calculatorDTO.restore(mc.getMemento(i + 1));

        showCommand(calculatorDTO);
    }

    public static void showCommand(CalculatorDTO command) {
        System.out.println("展示"+ command.getNumA() + command.getCalculateType() +command.getNumB() + "="+ command.getResult());
    }


}