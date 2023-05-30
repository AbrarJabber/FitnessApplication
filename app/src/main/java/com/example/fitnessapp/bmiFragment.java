package com.example.fitnessapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class bmiFragment extends Fragment {

    private View view;
    private  EditText edWeg,edHei;
    private TextView txtRes,txtInter;
    Button btnRes,btnReset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_bmi, container, false);

        edWeg=view. findViewById(R.id.edweg);

        edHei= view.findViewById(R.id.edhei);

        txtInter=view. findViewById(R.id.txtinter);
        txtRes=view. findViewById(R.id.txtres);

        btnRes= view. findViewById(R.id.btnres);
        btnReset= view.findViewById(R.id.btnreset);

        btnRes.setOnClickListener(v -> {

            String strweg= edWeg.getText().toString();
            String strhei= edHei.getText().toString();

            if(strweg.equals("")){
                edWeg.setError("Please Enter Your Weight ");
                edWeg.requestFocus();
                return;
            }
            if(strhei.equals("")){
                edHei.setError("Please Enter Your Height");
                edHei.requestFocus();
                return;
            }

            float weight = Float.parseFloat(strweg);
            float height = Float.parseFloat(strhei)/100;

            float bmiVlaue = BMICalculate(weight,height);

            txtInter.setText(interpreteBMI(bmiVlaue));
            txtRes.setText("BMI= "+bmiVlaue);


        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edHei.setText("");
                edWeg.setText("");
                txtInter.setText("");
                txtRes.setText("");
            }
        });



        return  view;
    }




    public float BMICalculate(float weight,float height){
        return weight / (height * height);
    }
    public String interpreteBMI(float bmiValue){
        if( bmiValue <16){
            return "Servely Underweight";
        }
        else if(bmiValue <18.5){
            return "Underweight";
        }
        else if(bmiValue < 25){
            return "Normal";
        }
        else if(bmiValue <30){
            return "OverWeight";
        }
        else
            return "Obese";
    }
}
