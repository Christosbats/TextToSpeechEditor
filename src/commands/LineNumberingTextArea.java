package commands;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;

public class LineNumberingTextArea 
{
    private JTextArea textArea;

    public LineNumberingTextArea(JTextArea textArea)
    {
        this.textArea = textArea;
        textArea.setBackground(Color.lightGray);
        textArea.setEditable(false);
    }

    public void updateLineNumbers()
    {
        String lineNumbersText = getLineNumbersText();
        textArea.setText(lineNumbersText);
    }

    private String getLineNumbersText()
    {
        int caretPosition = textArea.getDocument().getLength();
        Element root = textArea.getDocument().getDefaultRootElement();
        StringBuilder lineNumbersTextBuilder = new StringBuilder();
        lineNumbersTextBuilder.append("0 ").append(System.lineSeparator());

        for (int elementIndex = 1; elementIndex < root.getElementIndex(caretPosition)+1; elementIndex++)
        {
            lineNumbersTextBuilder.append(elementIndex).append(System.lineSeparator());
        }

        return lineNumbersTextBuilder.toString();
    }
}