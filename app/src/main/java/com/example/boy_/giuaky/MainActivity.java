package com.example.boy_.giuaky;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTxtNumber1;
    EditText editTxtNumber2;
    Button btnSend;
    ListView listView;
    ArrayList<String> results = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initEvent();
    }

    private void init() {
        editTxtNumber1 = (EditText) findViewById(R.id.number1);
        editTxtNumber2 = (EditText) findViewById(R.id.number2);
        btnSend = (Button) findViewById(R.id.btnSend);
        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                results );
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);
    }
    private void initEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTxtNumber1.getText().toString().equalsIgnoreCase("") || editTxtNumber2.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext() , "Text is empty!" , Toast.LENGTH_LONG).show();
                    return;
                }
                try{
                    float number1 = Float.valueOf(editTxtNumber1.getText().toString());
                    float number2 = Float.valueOf(editTxtNumber2.getText().toString());
                    Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                    intent.putExtra(CalculatorActivity.NUMBER1 , number1);
                    intent.putExtra(CalculatorActivity.NUMBER2 , number2);
                    startActivityForResult(intent , 9999);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext() , "Text khong phai so!" , Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 9999){
            if (data != null) {
                results.add(data.getStringExtra("result"));
                arrayAdapter.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
