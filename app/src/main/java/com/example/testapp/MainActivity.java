package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText input1, input2;
    private Button countSquareButton, countTriangleButton, countCircleButton;
    TextView textData;
    Button buttonShow;
    boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textData = findViewById(R.id.textField);
        buttonShow = findViewById(R.id.buttonView);

        input1 = findViewById(R.id.input_L_P_D);
        input2 = findViewById(R.id.input_W_H);
        countSquareButton = findViewById(R.id.button_countSquare);
        countTriangleButton = findViewById(R.id.button_countTriangle);
        countCircleButton = findViewById(R.id.button_countCircle);

        input1.addTextChangedListener(executeWatcher);
        input2.addTextChangedListener(executeWatcher);

        Toast toast = Toast.makeText(this, "Created by Deviko Kelvin", Toast.LENGTH_LONG);
        toast.show();
    }

    private TextWatcher executeWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {
            String input1_input = input1.getText().toString().trim();
            String input2_input = input2.getText().toString().trim();

            countSquareButton.setEnabled(!input1_input.isEmpty() && !input2_input.isEmpty());
            countTriangleButton.setEnabled(!input1_input.isEmpty() && !input2_input.isEmpty());
            countCircleButton.setEnabled(!input1_input.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable)
        {

        }
    };

    public void Show(View view)
    {
        String text = "Apa sih.. idih Sok Kenal Sok Dekat~";
        show = !show;
        if(show == true)
            textData.setText(text);
        else
            textData.setText("");
    }

    public void countTriangle(View view)
    {
        EditText pedestal = findViewById(R.id.input_L_P_D);
        EditText height = findViewById(R.id.input_W_H);

        double ped = Double.parseDouble(pedestal.getText().toString());
        double hei = Double.parseDouble(height.getText().toString());

        TextView areares = findViewById(R.id.areaResultField);
        TextView cirres = findViewById(R.id.cicumferenceResultField);

        areares.setText("Area: " + Double.toString(ped*hei/2) + " cms²");
        cirres.setText("Circumference: " + Double.toString(ped*3) + " cms");
    }

    public void countSquare(View view)
    {
        EditText squareLength = findViewById(R.id.input_L_P_D);
        EditText squareWidth = findViewById(R.id.input_W_H);

        double length = Double.parseDouble(squareLength.getText().toString());
        double width = Double.parseDouble(squareWidth.getText().toString());

        TextView areares = findViewById(R.id.areaResultField);
        TextView cirres = findViewById(R.id.cicumferenceResultField);

        areares.setText("Area: " + Double.toString(length*width) + " cms²");
        cirres.setText("Circumference: " + Double.toString((length+width)*2) + " cms");
    }

    public void countCircle(View view)
    {
        EditText circDia = findViewById(R.id.input_L_P_D);

        double diam = Double.parseDouble(circDia.getText().toString());
        double phi = 3.14;

        TextView areares = findViewById(R.id.areaResultField);
        TextView cirres = findViewById(R.id.cicumferenceResultField);

        areares.setText("Area: " + Double.toString(phi*((diam/2)*(diam/2))) + " cms²");
        cirres.setText("Circumference: " + Double.toString(2*phi*(diam/2)) + " cms");
    }
}
