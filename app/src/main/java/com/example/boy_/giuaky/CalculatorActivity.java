package com.example.boy_.giuaky;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    public static final String NUMBER1 = "NUMBER1";
    public static final String NUMBER2 = "NUMBER2";
    Button btnTru;
    Button btnChia;
    TextView number1;
    TextView number2;
//    public static void start(Context context, float number1, float number2 ){
//        Intent intent = new Intent(context, CalculatorActivity.class);
//        intent.putExtra(NUMBER1 , number1);
//        intent.putExtra(NUMBER2 , number2);
//        context.startActivity(intent);
//    }
    private float num1,num2;
    String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();
        setEvent();
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (extras != null){
            num1 = extras.getFloat(NUMBER1);
            num2 = extras.getFloat(NUMBER2);
            number1.setText("" + num1);
            number2.setText("" + num2);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    private void setEvent() {
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = num1 + " - " + num2 + " = " + (num1 - num2);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = num1 + " / " + num2 + " = " + (num1 / num2);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    private void init() {
        btnTru = (Button) findViewById(R.id.btnTru);
        btnChia = (Button) findViewById(R.id.btnChia);
        number1 = (TextView) findViewById(R.id.number1);
        number2 = (TextView) findViewById(R.id.number2);
    }
}
