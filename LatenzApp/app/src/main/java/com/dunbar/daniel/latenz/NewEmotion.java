package com.dunbar.daniel.latenz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dunbar.daniel.latenz.colorpicker.ColorPickerView;
import com.dunbar.daniel.latenz.colorpicker.OnColorChangedListener;
import com.dunbar.daniel.latenz.colorpicker.OnColorSelectedListener;

public class NewEmotion extends AppCompatActivity implements OnColorChangedListener, OnColorSelectedListener{
    private TextView emotion_tv;
    private RelativeLayout emotion_text_layout;
    private TextView emotion_definition_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_emotion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("New Emotion");
        setSupportActionBar(toolbar);

        emotion_tv = (TextView) findViewById(R.id.emotion_tv);
        emotion_text_layout = (RelativeLayout) findViewById(R.id.emotion_text_section);
        emotion_definition_tv = (TextView) findViewById(R.id.emotion_definition_tv);

        ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_picker_view);
        colorPickerView.addOnColorChangedListener(this);
        colorPickerView.addOnColorSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_emotion_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.save_emotion) {
            //Add to database if connection is available
            //Otherwise show toast error
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onColorChanged(int selectedColor) {
        emotion_text_layout.setBackgroundColor(selectedColor);
        Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));
    }

    @Override
    public void onColorSelected(int selectedColor) {
        emotion_text_layout.setBackgroundColor(selectedColor);
    }
}
