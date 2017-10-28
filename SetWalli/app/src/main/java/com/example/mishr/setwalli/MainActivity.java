package com.example.mishr.setwalli;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView imgv;
    Button cameracall,setwall;
    Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgv = (ImageView)findViewById(R.id.imageview);
        cameracall = (Button)findViewById(R.id.cameraclick);
        setwall = (Button)findViewById(R.id.setwall);


        cameracall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,123);
                  Toast.makeText(MainActivity.this, "Camera is Invoked..!!", Toast.LENGTH_LONG).show();
            }
        });

        setwall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    getApplicationContext().setWallpaper(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                   Toast.makeText(MainActivity.this, "Setting Wallpaper", Toast.LENGTH_SHORT).show();
                   Toast.makeText(MainActivity.this, "Wallpaper Set..!!", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            bitmap = (Bitmap) bundle.get("data");
            imgv.setImageBitmap(bitmap);
        }
    }
}



