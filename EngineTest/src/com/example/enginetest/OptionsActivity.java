package com.example.enginetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.enginetest.MainActivity.PlaceholderFragment;

//___________________-MOMENTAN IN DER MAINACTIVITY WEIL BUG-______________

public class OptionsActivity extends MainActivity {
	Button b_plus;
	Button b_minus;
	Button b_number;
	
	
	
	private int volume = 3;
	private int CurrentVolume = 3;
	private final static int MAX_VOLUME = 5;
	private float IngameVolume = 1.0f;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options_layout);	
		checkVolumeNumber();
		
		
	    

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	

	//Für den SoundPlusButton im OptionsMenue
	public void setSoundVolumePlus(View v){
		
		
		 
		
		this.volume++;
		checkVolumeNumber();
		      }


	//Für den SoundMinusButton im OptionsMenue

	public void setSoundVolumeMinus(View v){
		

		
		if(volume >=0)
		{
		this.volume--;
		}
		if(volume <1)
		{
			this.volume = 1;
		}
		 
		checkVolumeNumber();
		      }
		
	public void checkVolumeNumber(){
		
		
		if(volume == 1)
		{
			
			b_number = (Button) findViewById(R.id.button_volume_number);
			b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no1));
			bgsound.setVolume(0.2f,0.2f);
			
		}
		
		if(volume == 2)
		{
			
			b_number = (Button) findViewById(R.id.button_volume_number);
			b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no2));
			bgsound.setVolume(0.4f,0.4f);
		}
		if(volume == 3)
		{
			
			b_number = (Button) findViewById(R.id.button_volume_number);
			b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no3));
			bgsound.setVolume(0.6f,0.6f);
		}
		if(volume == 4)
		{
			
			b_number = (Button) findViewById(R.id.button_volume_number);
			b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no4));
			bgsound.setVolume(0.8f,0.8f);
		}
		if(volume == 5)
		{
			
			b_number = (Button) findViewById(R.id.button_volume_number);
			b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no5));
			bgsound.setVolume(1.0f,1.0f);
			
		}
		if(volume > 5)
		{
			
			SoundOutOfVolumeNumber();
			bgsound.setVolume(0.2f,0.2f);
			
		}
	}
		
		
		public void SoundOutOfVolumeNumber()
		{
			
			if(volume >5)
			{
				
				this.volume = 1;
				checkVolumeNumber();
				
			}
		}
		
		public void onBackPressed()
		{
			OptionsActivity.this.finish();
			
			
			Intent i = new Intent(OptionsActivity.this, MainActivity.class);
		    startActivity(i);
		}


	
		
		
		

			
		
		
		
}