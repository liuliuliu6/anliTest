package com.anli.Service;

import com.anli.po.CalculatorDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录
 */
public class MementoCaretaker {

    private final List<CalculatorDTO> history = new ArrayList<>();

    public CalculatorDTO getMemento(int i) {
        return history.get(i);
    }

    public void setMemento(CalculatorDTO memento) {
        history.add(memento);
    }
}
