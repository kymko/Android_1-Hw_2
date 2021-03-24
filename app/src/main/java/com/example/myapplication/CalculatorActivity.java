package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {
    EditText display;
    Button clearBTN;
    Button zeroBtn;
    Button oneBtn;
    Button twoBtn;
    Button threeBtn;
    Button fourBtn;
    Button fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, addBtn, subtractBtn, multiplyBtn, divideBtn, equalBtn;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = findViewById(R.id.input);
        zeroBtn = findViewById(R.id.zeroBTN);
        clearBTN = findViewById(R.id.clearBTN);
        oneBtn = findViewById(R.id.oneBTN);
        twoBtn = findViewById(R.id.twoBTN);
        threeBtn = findViewById(R.id.threeBTN);
        fourBtn = findViewById(R.id.fourBTN);
        fiveBtn = findViewById(R.id.fiveBTN);
        sixBtn = findViewById(R.id.sixBTN);
        sevenBtn = findViewById(R.id.sevenBTN);
        eightBtn = findViewById(R.id.eightBTN);
        nineBtn = findViewById(R.id.nineBTN);
        addBtn = findViewById(R.id.plusBTN);
        subtractBtn = findViewById(R.id.minusBTN);
        multiplyBtn = findViewById(R.id.multiplyBTN);
        divideBtn = findViewById(R.id.divideBTN);
        equalBtn = findViewById(R.id.equalsBTN);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        display.setShowSoftInputOnFocus(false);


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });


    }

    public void updateString(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
        vibrator.vibrate(25);
    }

    public void zeroBTN(View view) {
        updateString("0");
    }

    public void oneBTN(View view) {

        updateString("1");
    }

    public void twoBTN(View view) {

        updateString("2");
    }

    public void threeBTN(View view) {
        updateString("3");
    }

    public void fourBTN(View view) {
        updateString("4");
    }

    public void fiveBTN(View view) {
        updateString("5");
    }

    public void sixBTN(View view) {

        updateString("6");
    }

    public void sevenBTN(View view) {
        updateString("7");

    }

    public void eightBTN(View view) {
        updateString("8");
    }

    public void nineBTN(View view) {
        updateString("9");
    }

    public void equalBTN(View view) {

        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression expression = new Expression(userExp);

        String result = String.valueOf(expression.calculate());
        display.setText(result);
        display.setSelection(result.length());
        vibrator.vibrate(30);
    }

    public void clearBTN(View view) {
        vibrator.vibrate(30);

        display.setText("");
    }

    public void parenthesesBTN(View view) {
        int cursorPoss = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPoss; i++) {
            if (display.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;
            }

            if (display.getText().toString().substring(i, i + 1).equals(")")) {
                closePar += 1;
            }
        }
        if (openPar == closePar || display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
            updateString("(");
            display.setSelection(cursorPoss + 1);

        } else if (closePar < openPar && !display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
            updateString(")");
        }
        display.setSelection(cursorPoss + 1);
    }


    public void addBTN(View view) {
        updateString("+");
    }

    public void subtractBTN(View view) {
        updateString("-");
    }

    public void multiplyBTN(View view) {
        updateString("×");
    }

    public void divideBTN(View view) {
        updateString("÷");
    }

    public void plusMinusBTN(View view) {
        updateString("+-");
    }

    public void exponentBTN(View view) {
        updateString("^");
    }

    public void pointBTN(View view) {
        updateString(".");
    }

    public void backspaceBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
        vibrator.vibrate(30);
    }
}