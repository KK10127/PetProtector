package edu.miracostacollege.cs134.petprotector;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView petImageView;

    public static final int RESULT_LOAD_IMAGE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect petImage view to the layout
        // setImageUri on the petImage View
        petImageView = findViewById(R.id.petImageView);
        petImageView.setImageURI(getUriToResource(this, R.drawable.none));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_LOAD_IMAGE) {
            Uri uri = data.getData();
            petImageView.setImageURI(uri);
        }
    }

    public void selectPetImage(View v) {

        // 1) Make a list(empty) of permissions
        // 2) As user grants them, add each permission to the list
        List<String> permsList = new ArrayList<>();
        int permReqCode = 100;
        int hasCameraPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int hasReadPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int hasWritePerm = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);


        // check to see if the camera permission is denied
        // if denied, add it to the list of permisions requested
        if (hasCameraPerm == PackageManager.PERMISSION_DENIED) {
            permsList.add(Manifest.permission.CAMERA);
        }
        if (hasReadPerm == PackageManager.PERMISSION_DENIED) {
            permsList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (hasWritePerm == PackageManager.PERMISSION_DENIED) {
            permsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        // Now that we've build the loist, lets ask the user
        if (permsList.size() > 0) {
            String [] perms = new String[permsList.size()];
            permsList.toArray(perms);

            ActivityCompat.requestPermissions(this, perms, permReqCode);
        }

        // After requesting permissions, found out which ones the user granted
        // check to see if all permissions were granted
        if (hasCameraPerm == PackageManager.PERMISSION_GRANTED &&
        hasReadPerm == PackageManager.PERMISSION_GRANTED &&
        hasWritePerm == PackageManager.PERMISSION_GRANTED) {
            // Open the Galery!
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
        } else {
            // Toast informing user need permissions
        }

        // Override onActivity Result


    }


    private static Uri getUriToResource(Context context, int id) {

        Resources res = context.getResources();

        String uri = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + res.getResourcePackageName(id) + "/"
                + res.getResourceTypeName(id) + "/"
                + res.getResourceEntryName(id);

        return Uri.parse(uri);
    }

}
