package com.example.yonghu.activityjump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_enter ;
    private Button btn_back ;
    String message ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        et_enter = (EditText) findViewById(R.id.et_enter);
        et_enter.setOnClickListener(this);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(btn_back.equals(view)){
            message= et_enter.getText().toString();

            Bundle bundle =new Bundle();
            bundle.putString("message",message);

            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtras(bundle);

            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
        /*将数据放入bundle中，然后将bundle绑定到intent上，
         *然后将intent放入setResult()方法中，intent就传给了onActivityResult()*/
