package com.example.calculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first;
    private Integer second;
    private Float firstFloat;
    private Float secondFloat;
    private String onOperation = "";
    private Boolean isOperationClick;
    private Boolean isEqualDoubleClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_all_clear:
                allClear(view);
                break;
            case R.id.btn_zero:
                clickingOnNumbers(view);
                break;
            case R.id.btn_one:
                clickingOnNumbers(view);
                break;
            case R.id.btn_two:
                clickingOnNumbers(view);
                break;
            case R.id.btn_three:
                clickingOnNumbers(view);
                break;
            case R.id.btn_four:
                clickingOnNumbers(view);
                break;
            case R.id.btn_five:
                clickingOnNumbers(view);
                break;
            case R.id.btn_six:
                clickingOnNumbers(view);
                break;
            case R.id.btn_seven:
                clickingOnNumbers(view);
                break;
            case R.id.btn_eight:
                clickingOnNumbers(view);
                break;
            case R.id.btn_nine:
                clickingOnNumbers(view);
                break;

        }
        isOperationClick = false;
        isEqualDoubleClick = false;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onOperationClick(View view) {
        Button button = findViewById(view.getId());
        switch (view.getId()){
            case R.id.btn_plus_minus:
                int checkNum = parseInt(textView.getText().toString());
                if(checkNum > 0){
                    textView.setText("-" + checkNum);
                }else {
                    textView.setText(Integer.toString(Math.abs(checkNum)));
                }
                break;
            case R.id.btn_percent:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_division:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_multiplication:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_subtraction:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_addition:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_equal:
                calculate(onOperation);
                break;
            case R.id.btn_floating_point:
                //resultCalculating(view);
                break;
        }
        isOperationClick = true;
    }

    @SuppressLint("SetTextI18n")
    private void calculate(String onOperation) {
        if (!isEqualDoubleClick){
            second = Integer.valueOf(textView.getText().toString());
        }else {
            first = Integer.valueOf(textView.getText().toString());
        }
        switch (onOperation){
            case "/":
                int result = first / second;
                isEqualDoubleClick = true;
                textView.setText(Integer.toString(result));
                break;
            case "x":
                result = first * second;
                isEqualDoubleClick = true;
                textView.setText(Integer.toString(result));
                break;
            case "-":
                result = first - second;
                isEqualDoubleClick = true;
                textView.setText(Integer.toString(result));
                break;
            case "+":
                result = first + second;
                isEqualDoubleClick = true;
                textView.setText(Integer.toString(result));
                break;
            case"%":
                result = (first * second) / 100;
                isEqualDoubleClick = true;
                textView.setText(Integer.toString(result));
                break;
        }

    }
    public void allClear(View view){
        textView.setText("0");
        first = 0;
        second = 0;
    }

    public void clickingOnNumbers(View view){
        Button button = findViewById(view.getId());
        String buttonText = button.getText().toString();
        if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(buttonText);
        }else {
            textView.append(buttonText);
        }
    }

    public void toPositiveOrNegative(View view){
        textView.getText().toString();
    }

    @SuppressLint("SetTextI18n")
    public void resultCalculating(View view){
        String str = textView.getText().toString();
        if (!isEqualDoubleClick){
            try {
                secondFloat = Float.parseFloat(str);
            } catch (NumberFormatException e1) {
                try {
                    second = parseInt(str);
                } catch (NumberFormatException e2) {
                    System.out.println("Строка не является числом.");
                }
            }
        }else {
            try {
                firstFloat = Float.parseFloat(str);
            } catch (NumberFormatException e1) {
                try {
                    first = parseInt(str);
                } catch (NumberFormatException e2) {
                    System.out.println("Строка не является числом.");
                }
            }
        }
        if (firstFloat != 0.0 && secondFloat != 0.0){
            Float resultFloat = firstFloat + secondFloat;
            isEqualDoubleClick = true;
            textView.setText(resultFloat.toString());
        }else {
            int result = first + second;
            isEqualDoubleClick = true;

        }
    }

    public void additionMethod(View view){
        String str = textView.getText().toString();
        try {
            firstFloat = Float.parseFloat(str);
        } catch (NumberFormatException e1) {
            try {
                first = parseInt(str);
            } catch (NumberFormatException e2) {
                System.out.println("Строка не является числом.");
            }
        }
    }
}