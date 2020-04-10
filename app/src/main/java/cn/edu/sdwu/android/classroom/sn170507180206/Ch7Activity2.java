package cn.edu.sdwu.android.classroom.sn170507180206;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.list;

public class Ch7Activity2 extends AppCompatActivity {
    private ArrayList list;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch7_2);

        list= new ArrayList();
        list.add("item1");
        list.add("item2");
        list.add("item3");

        ListView listView=(ListView)findViewById(R.id.ch7_2_lv);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content=list.get(i).toString();
                Toast.makeText(Ch7Activity2.this,content,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void refrech(View view){
        list.add("item4");
        list.add("item5");

        arrayAdapter.notifyDataSetChanged();
    }

}
