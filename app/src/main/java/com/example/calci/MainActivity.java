package com.example.calci;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    TextView inputTxt, outputTxt;
    String data;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputTxt = findViewById(R.id.inputTxt);
        outputTxt = findViewById(R.id.outputTxt);

        Button num0 = findViewById(R.id.number0);
        Button num1 = findViewById(R.id.number1);
        Button num2 = findViewById(R.id.number2);
        Button num3 = findViewById(R.id.number3);
        Button num4 = findViewById(R.id.number4);
        Button num5 = findViewById(R.id.number5);
        Button num6 = findViewById(R.id.number6);
        Button num7 = findViewById(R.id.number7);
        Button num8 = findViewById(R.id.number8);
        Button num9 = findViewById(R.id.number9);

        Button onn = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button ac = findViewById(R.id.ac);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.multiply);
        Button sub = findViewById(R.id.subtract);
        Button add = findViewById(R.id.add);
        Button equals = findViewById(R.id.equals);
        Button dot = findViewById(R.id.point);
        Button zero = findViewById(R.id.number0);
        Button del = findViewById(R.id.del);

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"0");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"9");
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTxt.setText("");
                outputTxt.setText("");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+".");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"*");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"/");
            }
        });
        off.setOnClickListener(view -> inputTxt.setVisibility(TextView.GONE));
        off.setOnClickListener(view -> outputTxt.setVisibility(TextView.GONE));

        onn.setOnClickListener(view -> {
            inputTxt.setVisibility(TextView.VISIBLE);
            inputTxt.setText("0");
        });
        onn.setOnClickListener(view -> {
            outputTxt.setVisibility(TextView.VISIBLE);
            outputTxt.setText("0");
        });

        del.setOnClickListener(view ->{
            String number = inputTxt.getText().toString();
            if(number.length()>1)
            {
                inputTxt.setText(number.substring(0, number.length()-1));
            }
            else if (number.length() == 1 && !number.equals("0"))
            {
                inputTxt.setText("0");
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult=" ";


                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Java",1,null).toString();

                outputTxt.setText(finalResult);
            }
        });

    }
}

