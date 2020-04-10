package cn.edu.sdwu.android.classroom.sn170507180206;


import android.app.WallpaperManager;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.WALLPAPER_SERVICE;

public class MainActivity001 extends AppCompatActivity implements View.OnFocusChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面,不要写文件名，使用资源ID来引用资源
        setContentView(R.layout.layout_ch4_1);
        //1)获取普通界面组件：获取普通界面组件
        Button button=(Button) findViewById(R.id.button1);
        //点击长按图片成为
        ImageView imageView=(ImageView)findViewById(R.id.ch4_iv);
        //2)实现时间监听类，该监听类是一个特殊的JAVA类，必须实现一个XXXListener接口：
        //3)调用时间源的setXXXListener方法注册时间监听器

        button.setOnClickListener(new MyClickListener());
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {

                WallpaperManager wallpaperManager = (WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try {

                    wallpaperManager.setResource(R.raw.img);
                } catch (Exception e) {

                    Log.e(MainActivity001.class.toString(), e.toString());
                }
                return true;


            }

        });
        EditText email=(EditText) findViewById(R.id.ch4_1_email);
        email.setOnFocusChangeListener(this);

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ch4_1_11);
        linearLayout.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x=motionEvent.getX();
                float y=motionEvent.getY();
                TextView textview=(TextView) findViewById(R.id.ch4_1_tv);
                textview.setText("x:"+x+",y:"+y);;
                return true;
            }
        });
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        //参数b代表是否获取焦点
        //判断邮箱地址的合法性
        EditText editText=(EditText)view;
        if(!b){
            String content=editText.getText().toString();//得到editText的内容
            //判断邮箱地址的正则表达式
            String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern pattern=Pattern.compile(regEx1);
            //content email
            Matcher matcher=pattern.matcher(content);
            TextView textView=(TextView)findViewById(R.id.ch4_1_tv);
            if(matcher.matches()){
                textView.setText("");
            }else{
                textView.setText("email invalidate");
            }

        }
    }
    //2)实现监听类
    class MyClickListener implements View.OnClickListener {
                public void onClick(View view) {
                    Log.i(MainActivity001.class.toString(), "button click");

                }

     }
    public void startMain(View view){
        //界面跳转
        Intent intent=new Intent(this,MainActivity1.class);
        startActivity(intent);
    }
}
























































































































































