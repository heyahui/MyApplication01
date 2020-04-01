package cn.edu.sdwu.android.classroom.sn170507180206;


import android.app.WallpaperManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.content.Context.WALLPAPER_SERVICE;

public class MainActivity001 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面,不要写文件名，使用资源ID来引用资源
        setContentView(R.layout.layout_cha4_1);
        //1)获取普通界面组件：获取普通界面组件
        Button button=(Button) findViewById(R.id.button1);
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
    }

            class MyClickListener implements View.OnClickListener {
                public void onClick(View view) {
                    Log.i(MainActivity001.class.toString(), "button click");

                }
     }
}
























































































































































