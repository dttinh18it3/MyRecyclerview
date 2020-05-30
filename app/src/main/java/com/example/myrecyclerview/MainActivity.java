package com.example.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this, listView());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> listView() {
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setName("CHẠY NGAY ĐI");
        m.setDecription("Sơn Tùng M-TP");
        m.setImage(R.drawable.stmtpcnd);
        models.add(m);

        m = new Model();
        m.setName("LÀ 1 THẰNG CON TRAI");
        m.setDecription("J97");
        m.setImage(R.drawable.jack2);
        models.add(m);

        m = new Model();
        m.setName("HÃY TRAO CHO ANH");
        m.setDecription("Sơn Tùng M-TP");
        m.setImage(R.drawable.stmtphtca);
        models.add(m);

        m = new Model();
        m.setName("SÓNG GIÓ");
        m.setDecription("Jack ft K-ICM");
        m.setImage(R.drawable.jacksg);
        models.add(m);

        m = new Model();
        m.setName("HỒNG NHAN");
        m.setDecription("Jack");
        m.setImage(R.drawable.jack);
        models.add(m);

        m = new Model();
        m.setName("NƠI ẤY CON TÌM VỀ");
        m.setDecription("Hồ Quang Hiếu");
        m.setImage(R.drawable.hqh);
        models.add(m);

        m = new Model();
        m.setName("MỘT BƯỚC YÊU VẠN DẶM ĐAU");
        m.setDecription("Mr Siro");
        m.setImage(R.drawable.mrsiro);
        models.add(m);

        m = new Model();
        m.setName("LẠC TRÔI");
        m.setDecription("Sơn Tùng M-TP");
        m.setImage(R.drawable.stmtp);
        models.add(m);

        return models;
    }
}
