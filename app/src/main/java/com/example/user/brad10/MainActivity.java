package com.example.user.brad10;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
        sp = getSharedPreferences("gamedata", MODE_PRIVATE);
        editor = sp.edit();

    }

    // 偏好設定 => save
    public void test1(View v){
        editor.putInt("stage", 3);
        editor.putString("user", "Brad");
        editor.commit();
        Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
    }
    // 偏好設定 => read
    public void test2(View v){
        int stage = sp.getInt("stage",0);
        String name = sp.getString("user","nobody");
        tv.setText("Stage: " + stage + "\n" +
                "User: " + name);
    }

    // 內存 write
    public void test3(View v){
        // 在 內存空間之下的 FileSystem
        try {
            FileOutputStream fout = openFileOutput("brad.data", MODE_PRIVATE);
            fout.write("Hello, Brad".getBytes());
            fout.flush();
            fout.close();
        } catch (IOException e) {
            Log.v("brad", e.toString());
        }

    }
    // 內存 read
    public void test4(View v){

    }
}
