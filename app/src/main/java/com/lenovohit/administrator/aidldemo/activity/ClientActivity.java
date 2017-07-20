package com.lenovohit.administrator.aidldemo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lenovohit.administrator.aidldemo.R;
import com.lenovohit.administrator.aidldemo.service.ClientService;


/**
 * Created by SharkChao on 2017-07-20.
 */

public class ClientActivity extends Activity {

    private TextView tvProcess;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        tvProcess= (TextView) findViewById(R.id.tvProcess);
        Intent intent=new Intent(this, ClientService.class);
         startService(intent);
    }
    public static void startTwoActivity(Context context){
        context.startActivity(new Intent(context,ClientActivity.class));
    }

}
