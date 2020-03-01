package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class Lab2Activity extends AppCompatActivity {

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, Lab2Activity.class);
    }

    private static final String STATE_VIEWS_COUNT = "views_count";

    private Lab2ViewsContainer lab2ViewsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        //ширина экрана
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();

        setTitle(getString(R.string.lab2_title, getClass().getSimpleName()));

        lab2ViewsContainer = findViewById(R.id.container);
        lab2ViewsContainer.setWidth(width);
        findViewById(R.id.button).setOnClickListener(view -> lab2ViewsContainer.clickHandler());

        /* Восстановление */
        if (savedInstanceState != null) {
            lab2ViewsContainer.changeOrientation(this.getResources().getConfiguration().orientation);
            lab2ViewsContainer.rebuild(savedInstanceState.getInt(STATE_VIEWS_COUNT));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_VIEWS_COUNT, lab2ViewsContainer.getCounter());
    }
}
