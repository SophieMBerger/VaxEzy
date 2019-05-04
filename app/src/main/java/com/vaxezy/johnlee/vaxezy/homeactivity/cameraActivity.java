package com.vaxezy.johnlee.vaxezy.homeactivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.vaxezy.johnlee.vaxezy.R;
import com.vaxezy.johnlee.vaxezy.Record;
import com.vaxezy.johnlee.vaxezy.RecordBase;
import com.vaxezy.johnlee.vaxezy.VisionAPI;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class cameraActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    public static final int cameraData = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.imageView = (ImageView) this.findViewById(R.id.imageview);
        Button photoButton = (Button) this.findViewById(R.id.photoButton);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            VisionAPI visionApi = new VisionAPI("https://vaxez.blob.core.windows.net/vaxezy/receipt.jpg");
                RecordBase.GetRecordBase().records.add(new Record());
                Intent intent = new Intent(cameraActivity.this, HomeActivity.class);
                startActivity(intent);
        }
    }

    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }
    private static File getOutputMediaFile(int type){

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }
        File mediaFile;
        if (type == cameraData){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + ".jpg");
        } else {
            return null;
        }
        return mediaFile;
    }


}

