package com.example.lab2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class Lab2ViewsContainer extends LinearLayout {

    private int minViewsCount;
    private int viewsCount;

    public Lab2ViewsContainer(Context context) {
        this(context, null);
    }

    public Lab2ViewsContainer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Lab2ViewsContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Lab2ViewsContainer, defStyleAttr, 0);

        minViewsCount = a.getInt(R.styleable.Lab2ViewsContainer_lab2_minViewsCount, 0);
        if (minViewsCount < 0) {
            throw new IllegalArgumentException("minViewsCount can't be less than 0");
        }

        a.recycle();
    }

    int width = 0;
    public void setWidth(int value)
    {
        width = value;
    }

    int horizontalOrientation = 3;
    public void setHorizontalOrientation(int value)
    {
        horizontalOrientation = value;
    }

    int viewInVerticalLayout = 2;

    int counter = 0;
    public int getCounter()
    {
        return  counter;
    }

    int row = 0;
    public void setRow(int value)
    {
        row = value;
    }

    public void clickHandler()
    {
        if (counter % (horizontalOrientation*viewInVerticalLayout) == 0)
        {
            createVerticalLayout();
            row++;
        }

        int value = counter % (horizontalOrientation*viewInVerticalLayout);
        View view = (View) findViewWithTag(row - 1 + "." + value);
        view.setVisibility(View.VISIBLE);

        counter++;
    }

    public void createVerticalLayout()
    {
        LinearLayout.LayoutParams paramMain = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                1.0f
        );
        LinearLayout llMain = new LinearLayout(getContext());
        llMain.setOrientation(LinearLayout.HORIZONTAL);

        llMain.setLayoutParams(paramMain);
        addView(llMain);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                width / horizontalOrientation,
                width / horizontalOrientation * viewInVerticalLayout
        );

        for (int i = 0; i < horizontalOrientation; i++)
        {
            LinearLayout ll = new LinearLayout(getContext());

            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setLayoutParams(param);
            llMain.addView(ll);

            twoViews(ll, viewInVerticalLayout, i);
        }
    }
    //параметры для двух вьюх
    public void twoViews(LinearLayout ll, int viewInVerticalLayout, int id)
    {
        Random rnd = new Random();

        double randomValue = 1 + 0.5 * rnd.nextDouble();

        LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                (float) randomValue
        );

        LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                (float) (viewInVerticalLayout - randomValue)
        );

        createView(ll, param2, id);

        createView(ll, param1, id + horizontalOrientation);
    }
    //создание вью
    public void createView(LinearLayout ll, LinearLayout.LayoutParams param, int tag)
    {
        Random rnd = new Random();

        View view = new View(getContext());

        int color1 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        view.setBackgroundColor(color1);

        view.setLayoutParams(param);

        view.setTag(row + "." + tag);

        view.setVisibility(View.INVISIBLE);

        ll.addView(view);
    }

    public void rebuild(int counter)
    {
        setRow(0);

        for (int i = 0; i < counter; i++) {
            clickHandler();
        }
    }

    public void changeOrientation(int orientation)
    {
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            setHorizontalOrientation(3);
        else
            setHorizontalOrientation(6);
    }
}