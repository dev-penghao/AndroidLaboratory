package com.penghao.laboratory;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity 
{
	Activity[] activitys={new PaletteActivity()};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
