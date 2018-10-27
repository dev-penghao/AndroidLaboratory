package com.penghao.laboratory;

import android.app.*;
import android.media.*;
import android.os.*;
import android.text.format.*;
import java.io.*;
import java.util.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class RecoderActivity extends Activity 
{
	
	MediaRecorder mMediaRecorder;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recoder_activity);
		
		Button b1=(Button) findViewById(R.id.start);
		Button b2=(Button) findViewById(R.id.stop);
		
		b1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					startRecord();
					// TODO: Implement this method
				}
			});
		b2.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					stopRecode();
					// TODO: Implement this method
				}
			});
    }
	
	public void startRecord() {
		// 开始录音
		/* ①Initial：实例化MediaRecorder对象 */
		if (mMediaRecorder == null)
			mMediaRecorder = new MediaRecorder();
		try {
			/* ②setAudioSource/setVedioSource */
			mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置麦克风
			/*
			 * ②设置输出文件的格式：THREE_GPP/MPEG-4/RAW_AMR/Default THREE_GPP(3gp格式
			 * ，H263视频/ARM音频编码)、MPEG-4、RAW_AMR(只支持音频且音频编码要求为AMR_NB)
			 */
			mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
			/* ②设置音频文件的编码：AAC/AMR_NB/AMR_MB/Default 声音的（波形）的采样 */
			mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
//			fileName = DateFormat.format("yyyyMMdd_HHmmss", Calendar.getInstance(Locale.CHINA)) + ".m4a";
//			if (!FileUtils.isFolderExist(FileUtils.getFolderName(audioSaveDir))) {
//				FileUtils.makeFolders(audioSaveDir);
//			}
//			filePath = audioSaveDir + fileName;
			/* ③准备 */
			mMediaRecorder.setOutputFile("/sdcard/recoder_output.m4a");
			mMediaRecorder.prepare();
			/* ④开始 */
			mMediaRecorder.start();
		} catch (IllegalStateException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	public void stopRecode(){
		mMediaRecorder.stop();
		mMediaRecorder.release();
		mMediaRecorder=null;
	}
}
