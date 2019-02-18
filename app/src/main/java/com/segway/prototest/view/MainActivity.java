package com.segway.prototest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.segway.prototest.R;
import com.segway.prototest.entry.PersonInfo;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ProtoMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonInfo.Person person = PersonInfo.Person.newBuilder().setName("will").setId(10).build();
        Log.i(TAG,"person is " +person.getName());
    }
}
