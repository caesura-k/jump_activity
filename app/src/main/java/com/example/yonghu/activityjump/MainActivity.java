package com.example.yonghu.activityjump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_message;
    private Button btn_jump;
    public static final int REQ_CODE_COMM_SET = 1;
    /*request code：正整型数值就行，为了便于理解，取个名字*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message= (TextView) this.findViewById(R.id.tv_message);
        tv_message.setOnClickListener(this);
        btn_jump= (Button) this.findViewById(R.id.btn_jump);
        btn_jump.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(btn_jump.equals(view)){
            Intent intent =new Intent(this,EditActivity.class);
            startActivityForResult(intent,REQ_CODE_COMM_SET);
            /*startActivity跳转到另一个activity，返回的时候不会携带数据
            *startActivityForResult跳转到另一个activity，返回的时候可以带数据返回至当前activty，
            * 返回携带的数据在onActivityResult中接收处理，以上步骤是定义，没有为什么*/
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if (requestCode == REQ_CODE_COMM_SET) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = intent.getExtras();
                String message = bundle.getString("message");
                tv_message.setText(message);
                Log.d("intent with bundle", " setting succ");
            }
            else if (resultCode == RESULT_CANCELED) {  }
        }
    }
}
/* A Activity携带数据返回至B Activity时，则会自动调用B Activity的onAcvitityResult方法来处理数据；
*   1、参数requestCode：
*       正整数;如果有多个activity跳转返回至当前activity,request code可以区分出来，方便处理不同的数据
*   2、参数resultCode：
*       只有两个值，RESULT_OK、RESULT_CANCEL；表示activity是否跳转成功；要是被中断，值为RESULT_CANCEL
*   3、参数intent:
*       就是前一个页面携带数据的intent
* */
