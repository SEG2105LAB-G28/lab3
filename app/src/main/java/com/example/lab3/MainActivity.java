package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.R;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    private enum Operator {none, add, sub, mul, div, eq}
    private double value1=0, value2 = 0;

    private Operator opp = Operator.none;

    private boolean hasDot = false;

    private boolean requiresCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.resultText);

    }

	// Sample implementation of the onClickNumericalButton (...). 
	// Feel free to re-implement or modidy.
    public void onClickNumericalButton(View view) {
		
		
        //Getting ID of pressed Button
        int pressID = view.getId();

        //If we had an equal sign pressed last, standard operation is to clean
        if (opp == Operator.eq) {
            opp = Operator.none;
            resultText.setText("");
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            hasDot = false;
            resultText.setText("");
        }

        if (pressID == R.id.press0) {
            resultText.setText(resultText.getText() + "0");
        } else if (pressID == R.id.press1) {
            resultText.setText(resultText.getText() + "1");
        } else if (pressID == R.id.press2) {
            resultText.setText(resultText.getText() + "2");
        } else if (pressID == R.id.press3) {
            resultText.setText(resultText.getText() + "3");
        } else if (pressID == R.id.press4) {
            resultText.setText(resultText.getText() + "4");
        } else if (pressID == R.id.press5) {
            resultText.setText(resultText.getText() + "5");
        } else if (pressID == R.id.press6) {
            resultText.setText(resultText.getText() + "6");
        } else if (pressID == R.id.press7) {
            resultText.setText(resultText.getText() + "7");
        } else if (pressID == R.id.press8) {
            resultText.setText(resultText.getText() + "8");
        } else if (pressID == R.id.press9) {
            resultText.setText(resultText.getText() + "9");
        } else if (pressID == R.id.pressDot) {
            if (!hasDot) {
                resultText.setText(resultText.getText() + ".");
                hasDot = true;
            }
        } else {
            resultText.setText("ERROR");
        }

    }

    public void onClickFunctionButton(View view) {
		// Add your code here...
        int pressID = view.getId();


        if(pressID == R.id.pressPlus){
            if(!resultText.getText().toString().isEmpty()){
                value1 = Double.parseDouble(resultText.getText().toString());
                opp = Operator.add;
                requiresCleaning = true;
            }
        }
        else if(pressID == R.id.pressMinus){
            if(!resultText.getText().toString().isEmpty()) {
                value1 = Double.parseDouble(resultText.getText().toString());
                opp = Operator.sub;
                requiresCleaning = true;
            }
        }
        else if(pressID == R.id.pressMul){
            if(!resultText.getText().toString().isEmpty()) {
                value1 = Double.parseDouble(resultText.getText().toString());
                opp = Operator.mul;
                requiresCleaning = true;
            }
        }
        else if(pressID == R.id.pressDiv){
            if(!resultText.getText().toString().isEmpty()) {
                value1 = Double.parseDouble(resultText.getText().toString());
                opp = Operator.div;
                requiresCleaning = true;
            }
        }
        else if(pressID == R.id.pressEq){
            if(!resultText.getText().toString().isEmpty()) {
                value2 = Double.parseDouble(resultText.getText().toString());
                double result = 0;
                switch (opp) {
                    case add:
                        result = value1 + value2;
                        break;
                    case sub:
                        result = value1 - value2;
                        break;
                    case mul:
                        result = value1 * value2;
                        break;
                    case div:
                        if (value2 != 0) {
                            result = value1 / value2;
                        } else {
                            resultText.setText("ERROR");
                            return;
                        }
                        break;
                }
                resultText.setText(String.valueOf(result));
                opp = Operator.eq;
                requiresCleaning = true;
            }
        }
        else if (pressID == R.id.pressDot){
            if(!hasDot){
                resultText.setText(resultText.getText() + ".");
                hasDot = true;
            }
        }
    }

}