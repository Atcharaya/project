package com.example.asus.project.pages;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.asus.project.R;
import com.example.asus.project.model.Success;
import com.example.asus.project.service.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Edit_Status_Change extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    Button buttonSubmit;
    Button buttonCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__status__change);
        Log.d("gg", "onCreate: "+getIntent().getStringExtra("rq_id"));
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

        if (status.equals("รับเรื่อง")){//1
            process(1,status);
//            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
//            finish();
        }else if (status.equals("วิเคราะห์ผลกระทบ/ออกแบบ")){//2
            process(2,status);
//            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
//            finish();
        }else  if (status.equals("ดำเนินการพัฒนา/ปรับแก้ไข")){//3
            process(3,status);
//            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
//            finish();
        }else if (status.equals("ทดสอบความถูกต้อง")){//4
            process(4,status);
//            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
//            finish();
        }else if (status.equals("รายงานผล")){//5
            process(5,status);
//            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
//            finish();
        }else if (status.equals("สำเร็จ")){//6
            process(6,status);
//            Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
//            finish();
        }
    }

    public void setSelectedRadioButton(RadioButton selectedRadioButton) {
        this.selectedRadioButton = selectedRadioButton;


    }

    public void process(int stt_id, final String status){
        String rq_id = getIntent().getStringExtra("rq_id");
        Call<Success> call = HttpManager.getInstance().getService().sch_change(rq_id,stt_id);
        call.enqueue(new Callback<Success>() {
            @Override
            public void onResponse(Call<Success> call, Response<Success> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Edit_Status_Change.this, "Status : " + status , Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(Edit_Status_Change.this, "Error : " + status , Toast.LENGTH_LONG).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Success> call, Throwable t) {
                Log.d("gg", "onFailure: "+t);
                Toast.makeText(Edit_Status_Change.this, "Fail : " + status , Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
