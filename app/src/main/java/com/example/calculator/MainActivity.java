package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView number, clr, del, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, pt, add, mul, sub, div, mod, ext, eq;
    public String previousResult, currentInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eq = findViewById(R.id.equal);
        number = findViewById(R.id.math);
        clr = findViewById(R.id.clear);
        del = findViewById(R.id.delete);
        num1 = findViewById(R.id.one);
        num2 = findViewById(R.id.two);
        num3 = findViewById(R.id.three);
        num4 = findViewById(R.id.four);
        num5 = findViewById(R.id.five);
        num6 = findViewById(R.id.six);
        num7 = findViewById(R.id.seven);
        num8 = findViewById(R.id.eight);
        num9 = findViewById(R.id.nine);
        num0 = findViewById(R.id.zero);
        pt = findViewById(R.id.point);
        add = findViewById(R.id.addition);
        sub = findViewById(R.id.subract);
        mul = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);
        mod = findViewById(R.id.modulus);
        ext = findViewById(R.id.exit);


        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num0.getText().toString();
                number.setText(numbr);
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num1.getText().toString();
                number.setText(numbr);
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num2.getText().toString();
                number.setText(numbr);
            }
        });


        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num3.getText().toString();
                number.setText(numbr);
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num4.getText().toString();
                number.setText(numbr);
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num5.getText().toString();
                number.setText(numbr);
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num6.getText().toString();
                number.setText(numbr);
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num7.getText().toString();
                number.setText(numbr);
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num8.getText().toString();
                number.setText(numbr);
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + num9.getText().toString();
                number.setText(numbr);
            }
        });

        pt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + pt.getText().toString();
                number.setText(numbr);
            }
        });


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr = null;
                if (number.getText().length() > 0) {
                    StringBuilder str1 = new StringBuilder(number.getText());
                    int str2 = str1.length();
                    str1.deleteCharAt(str2 - 1);
                    String str3 = str1.toString();
                    number.setText(str3);
                }
            }
        });


        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + add.getText().toString();
                number.setText(numbr);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + sub.getText().toString();
                number.setText(numbr);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + mul.getText().toString();
                number.setText(numbr);

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + div.getText().toString();
                number.setText(numbr);

            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbr;
                numbr = number.getText().toString() + mod.getText().toString();
                number.setText(numbr);
            }
        });

        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expression=number.getText().toString();
                double result = evaluateExpression(expression);
                number.setText(String.valueOf(result));
            }
        });
    }
    public static double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || (c == '-' && (i == 0 || expression.charAt(i - 1) == '('))) {
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numStr.append(expression.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(numStr.toString()));
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char operator = operators.pop();
                    numbers.push(applyOperator(a, b, operator));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char operator = operators.pop();
            numbers.push(applyOperator(a, b, operator));
        }
        return numbers.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/' || operator == '%') {
            return 2;
        }
        return 0;
    }

    private static double applyOperator(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            case '%':
                if (b != 0) {
                    return a % b;
                } else {
                    throw new ArithmeticException("Modulo by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}