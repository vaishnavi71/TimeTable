package com.example.timestable;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generate(int times){
        ArrayList<String> t= new ArrayList<>();
        for (int i=1;i<=10;i++){
            t.add(Integer.toString(i*times));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,t);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar);
        listView= findViewById(R.id.list);
        seekBar.setMax(100);
        seekBar.setProgress(50);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int times;
                if(progress < min){
                    times= min;
                    seekBar.setProgress(min);
                }else{
                    times=progress;
                }
                generate(times);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generate(10);
    }
}
