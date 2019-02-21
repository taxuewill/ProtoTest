package com.segway.prototest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.segway.prototest.R;
import com.segway.prototest.presenter.TestPresenter;

public class MainActivity extends AppCompatActivity implements  IProtoContact.IProtoView, View.OnClickListener{

    private static final String TAG = "ProtoMain";
    private Button mBtnReadProto,mBtnWriteProto,mBtnWriteReadProto;
    private Button mBtnNativeReadProto,mBtnNativeWriteProto,mBtnNativeWriteReadProto;
    private TextView mTvTime;
    private IProtoContact.IProtoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mBtnReadProto = findViewById(R.id.btn_read_proto);
        mBtnWriteProto = findViewById(R.id.btn_write_proto);
        mBtnWriteReadProto = findViewById(R.id.btn_write_read_proto);

        mBtnNativeReadProto = findViewById(R.id.btn_native_read_proto);
        mBtnNativeWriteProto = findViewById(R.id.btn_native_write_proto);
        mBtnNativeWriteReadProto = findViewById(R.id.btn_native_write_read_proto);

        mTvTime = findViewById(R.id.tv_time);

        mBtnWriteProto.setOnClickListener(this);
        mBtnReadProto.setOnClickListener(this);
        mBtnWriteReadProto.setOnClickListener(this);

        mBtnNativeReadProto.setOnClickListener(this);
        mBtnNativeWriteProto.setOnClickListener(this);
        mBtnNativeWriteReadProto.setOnClickListener(this);

        mPresenter = new TestPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read_proto:
                mPresenter.readProto();
                break;
            case R.id.btn_write_proto:
                mPresenter.writeProto();
                break;
            case R.id.btn_write_read_proto:
                mPresenter.writeReadProto();
                break;
            case R.id.btn_native_read_proto:
                mPresenter.nativeReadProto();
                break;
            case R.id.btn_native_write_proto:
                mPresenter.nativeWriteProto();
                break;
            case R.id.btn_native_write_read_proto:
                mPresenter.nativeWriteReadProto();
                break;
        }
    }

    @Override
    public void showTime(final long time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvTime.setText(String.valueOf((time/1000d)+"ms"));
            }
        });
    }
}
