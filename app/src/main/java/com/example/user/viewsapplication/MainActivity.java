package com.example.user.viewsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText editTextInputN;
    EditText editTextInputdB;
    EditText editTextInputmW;
    EditText editTextInputdBm;

    EditText editTextOutputdB;
    EditText editTextOutputN;
    EditText editTextOutputdBm;
    EditText editTextOutputmW;

    double inputN = 0;
    double inputdB = 0;
    double inputmW = 0;
    double inputdBm = 0;

    double outputN = 0;
    double outputdB = 0;
    double outputmW = 0;
    double outputdBm = 0;

    String emptyString = "";
    int rnd = 4;
    double fakeValue = -42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void solve(View view)
    {
        //N -> dB
        editTextInputN = (EditText) findViewById(R.id.textInputN);
        inputN = GetValueFromText(editTextInputN);
        if(inputN!=0)
        {
            outputdB = GetdBbyN(inputN);
            editTextOutputdB = (EditText) findViewById(R.id.textOutputdB);
            editTextOutputdB.setText("");
            if(outputdB != fakeValue)
            {
                editTextOutputdB.setText(Double.toString(outputdB));
            }else{
                editTextOutputdB.setText("ДОХУЯ...");
            }
        }

        //dB -> N
        editTextInputdB = (EditText) findViewById(R.id.textInputdB);
        inputdB = GetValueFromText(editTextInputdB);
        if(inputdB!=0)
        {
            outputN = GetNbydB(inputdB);
            editTextOutputN = (EditText) findViewById(R.id.textOutputN);
            editTextOutputN.setText("");
            if(outputN != fakeValue)
            {
                editTextOutputN.setText(Double.toString(outputN));
            }else{
                editTextOutputN.setText("ДОХУЯ...");
            }

        }

        //mW -> dBm
        editTextInputmW = (EditText) findViewById(R.id.textInputmW);
        inputmW = GetValueFromText(editTextInputmW);
        if(inputmW!=0)
        {
            outputdBm = GetdBmbymW(inputmW);
            editTextOutputdBm = (EditText) findViewById(R.id.textOutputdBm);
            editTextOutputdBm.setText("");
            if(outputdBm != fakeValue)
            {
                editTextOutputdBm.setText(Double.toString(outputdBm));
            }else{
                editTextOutputdBm.setText("ДОХУЯ...");
            }

        }

        //dBm -> mW
        editTextInputdBm = (EditText) findViewById(R.id.textInputdBm);
        inputdBm = GetValueFromText(editTextInputdBm);
        if(inputdBm!=0)
        {
            outputmW = GetNbydB(inputdBm);
            editTextOutputmW = (EditText) findViewById(R.id.textOutputmW);
            editTextOutputmW.setText("");
            if(outputmW != fakeValue)
            {
                editTextOutputmW.setText(Double.toString(outputmW));
            }else{
                editTextOutputmW.setText("ДОХУЯ...");
            }
        }
    }

    private double GetValueFromText(EditText text)
    {
        double result =
                text.getText().toString().equals(emptyString)
                        ?0
                        :Double.parseDouble(text.getText().toString());
        return result;
    }

    private double GetdBbyN(double N)
    {
        if(N <= 1000000)
        {
            double result = 10 * Math.log10(N);
            return RoundValue(result);
        }else
        {
            return fakeValue;
        }

    }

    private double GetdBmbymW(double mW)
    {
        return GetdBbyN(mW);
    }

    private double GetNbydB(double dB)
    {
        if(dB <= 60)
        {
            double result = Math.pow(10, (dB/10));
            return RoundValue(result);
        }else
        {
            return fakeValue;
        }

    }

    private double GetmWbydBm(double dBm)
    {
        return GetNbydB(dBm);
    }

    private double RoundValue(double value)
    {
        double round = Math.pow(10,rnd);
        value*=round;
        value = Math.round(value);
        value/=round;
        return value;
    }

}
