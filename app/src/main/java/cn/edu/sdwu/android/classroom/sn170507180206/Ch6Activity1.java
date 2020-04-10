package cn.edu.sdwu.android.classroom.sn170507180206;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Ch6Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch6_1);
        String content=getString(R.string.hello);
        Log.i(Ch6Activity1.this.toString(),content);
        String sms=getString(sms,100,"张三");
        Log.i(Ch6Activity1.this.toString(),sms);


        //获取数组资源
        Resources resources=getResources();
        //整形数组
        int[] intArr=resources.getIntArray(R.array.intArr);
        for (int i=0;i<intArr.length;i++){
            Log.i(Ch6Activity1.this.toString(),intArr[i]+"");
        }
        resources.getStringArray(R.array.strArr);
        for (int i=0;i<intArr.length;i++){
            Log.i(Ch6Activity1.this.toString(),strArr[i]+"");
        }
        //普通类型数组
        TypedArray typedArray=resources.obtainTypedArray(android.R.array.commanArr);
        ImageView imageView=(ImageView)findViewById(R.id.ch6_1_iv);
        int resId=typedArray.getResourceId(0,0);
        imageView.setImageResource(resId);

        String str=typedArray.getString(1);
        Log.i(Ch6Activity1.this.toString(),str);

        //
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ch6_1_11);
        registerForContextMenu(linearLayout);

        XmlPullParser xmlPullParser=resources.getXml(R.xml.words);
        try {
            while (xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if(xmlPullParser.getEventType()==XmlPullParser.START_TAG){
                    if (xmlPullParser.getName().equals("word")){
                        String word=xmlPullParser.getAttributeValue(0);
                        Log.i(Ch6Activity1.class.toString(),word);
                    }
                }
                xmlPullParser.next();
            }
        } catch (Exception e) {
            Log.e(Ch6Activity1.class.toString(),e.toString());
        }
    }
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1,menu);
    }


    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mymenu_item1:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item2:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item3:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        //
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        return true;
    }
}














































































