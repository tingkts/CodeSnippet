package com.msi.example;

import java.lang.reflect.InvocationTargetException;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Test extends Activity {

	private Button mButton;	
    private PowerManager mPowerManager;
    private KeyguardManager mKeyguardManager;
 	private KeyguardLock mKeyguardLock;
 	private PowerManager.WakeLock mWakeLock;
 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mButton = (Button) findViewById(R.id.button1);
		mButton.setOnClickListener(new OnClickListener() {
			// @Override
			public void onClick(View v) {
		        mPowerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
				mKeyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
				
				//goToSleep
				try {
					mPowerManager.getClass().getMethod("goToSleep", new Class[]{long.class}).invoke(mPowerManager, SystemClock.uptimeMillis());
		        } catch (IllegalAccessException e) {
		            e.printStackTrace();
		        } catch (InvocationTargetException e) {
		            e.printStackTrace();
		        } catch (NoSuchMethodException e) {
		            e.printStackTrace();
		        }
				//wakeUp
				Message msg = mHandler1.obtainMessage(1);
				mHandler1.removeMessages(1);
				mHandler1.sendMessageDelayed(msg, 1000*5);	
			}
		});			
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mHandler1.removeMessages(1);
        if (mWakeLock != null) {
			mWakeLock.release();
			mWakeLock = null;
		}
		if (mKeyguardLock!=null) {
			mKeyguardLock.reenableKeyguard();
		} 		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	
	}

	private Handler mHandler1 = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
	            mWakeLock = mPowerManager.newWakeLock
	    		(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "Tag");
	    		mWakeLock.acquire();
	    		mKeyguardLock = mKeyguardManager.newKeyguardLock("");
	    		mKeyguardLock.disableKeyguard();
				break;
			default:
				break;
			}
		}
	};	
}
