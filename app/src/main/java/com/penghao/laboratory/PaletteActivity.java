package com.penghao.laboratory;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.widget.SeekBar.*;

public class PaletteActivity extends Activity 
{
	TextView textView;
	SeekBar redBar,greenBar,blueBar;
	int red,green,blue;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palette_activity);
		
		textView=(TextView) findViewById(R.id.mainTextView);
		redBar=(SeekBar) findViewById(R.id.red);
		greenBar=(SeekBar) findViewById(R.id.green);
		blueBar=(SeekBar) findViewById(R.id.blue);
		
		redBar.setOnSeekBarChangeListener(listener);
		greenBar.setOnSeekBarChangeListener(listener);
		blueBar.setOnSeekBarChangeListener(listener);
		//textView.setOnClickListener();
    }
	
	OnSeekBarChangeListener listener=new OnSeekBarChangeListener(){

		// 当进度条被拖动
		@Override
		public void onProgressChanged(SeekBar p1, int p2, boolean p3)
		{
			switch(p1.getId()){
				case R.id.red:// 如果是红色进度条被拖动
					red=p2;
					break;
				case R.id.green:// 如果是绿色进度条被拖动
					green=p2;
					break;
				case R.id.blue:// 如果是蓝色进度条被拖动
					blue=p2;
					break;
				default:break;
			}
			//设置背景颜色
			textView.setBackgroundColor(Color.rgb(red,green,blue));
			// 对文字进行反色处理，这样不论背景是什么颜色，文字都是清晰可见的
			textView.setTextColor(Color.rgb(0xff-red,0xff-green,0xff-blue));
			//设置文字，将int类型的数据格式化成类似0x44aad4的字符串
			textView.setText("0x"+String.format("%02x",red)+String.format("%02x",green)+String.format("%02x",blue));
		}

		@Override
		public void onStartTrackingTouch(SeekBar p1)
		{
			// TODO: Implement this method
		}

		@Override
		public void onStopTrackingTouch(SeekBar p1)
		{
			// TODO: Implement this method
		}
	};
}
