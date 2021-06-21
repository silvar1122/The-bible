package com.example.projectbibleapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SeekbarFragment extends Fragment {
    SeekBar seekBar;
    ContentResolver contentResolver;
    Window window;
    int brightness;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.seekbar_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Add Setting permission in Manifest
        seekBar=view.findViewById(R.id.seekBar);
        contentResolver=getContext().getContentResolver();
        window=requireActivity().getWindow();

        seekBar.setMax(255);
        seekBar.setKeyProgressIncrement(1);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(Settings.System.canWrite(getContext())){
                //Toast.makeText(getContext(),"You can change the brightness",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent=new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:"+requireActivity().getApplication().getPackageName()));
                startActivity(intent);
            }
        }

        try {
            brightness=Settings.System.getInt(contentResolver,Settings.System.SCREEN_BRIGHTNESS);
            seekBar.setProgress(brightness);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brightness=progress;
                Settings.System.putInt(contentResolver,Settings.System.SCREEN_BRIGHTNESS,brightness);
                WindowManager.LayoutParams layoutParams=window.getAttributes();
                layoutParams.screenBrightness=brightness/(float)300;
                window.setAttributes(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    }

