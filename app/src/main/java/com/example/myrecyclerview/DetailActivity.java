package com.example.myrecyclerview;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tv_detail_name, tv_detail_description;
    ImageView detail_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tv_detail_name = findViewById(R.id.tv_detail_name);
        tv_detail_description = findViewById(R.id.tv_detail_description);
        detail_image = findViewById(R.id.detail_image);

        Intent intent = getIntent();

        byte[] bytes = getIntent().getByteArrayExtra("Image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        tv_detail_name.setText(intent.getStringExtra("Name"));
        tv_detail_description.setText(intent.getStringExtra("Description"));
        detail_image.setImageBitmap(bitmap);
    }

    public void OpenList(View view) {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
