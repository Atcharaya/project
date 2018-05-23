package com.example.asus.project.pages;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.asus.project.R;

public class Edit_Status_Change extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    Button buttonSubmit;
    Button buttonCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__status__change);

        buttonSubmit = (Button) findViewById(R.id.btn_save_edit_rq);
        buttonCancle = (Button) findViewById(R.id.btn_save_edit_back);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeStatus();
                //Toast.makeText(Edit_Status_Change.this, "Selected Radio Button is:" + status , Toast.LENGTH_LONG).show();
            }
        });

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void changeStatus() {

        selectedRadioButton  = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());

        String status = selectedRadioButton.getText().toString();

        if (status.equals("รับเรื่อง")){
            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
            finish();
        }else if (status.equals("วิเคราะห์ผลกระทบ/ออกแบบ")){
            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
            finish();
        }else  if (status.equals("ดำเนินการพัฒนา/ปรับแก้ไข")){
            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
            finish();
        }else if (status.equals("ทดสอบความถูกต้อง")){
            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
            finish();
        }else if (status.equals("รายงานผล")){
            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
            finish();
        }else if (status.equals("สำเร็จ")){
            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
