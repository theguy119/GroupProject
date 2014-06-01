package com.example.enginetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.enginetest.MainActivity.PlaceholderFragment;



public class OptionsActivity extends MainActivity {
	Button b_plus;
	Button b_minus;
	Button b_number;
	
	
	
	private int volume = 3;
	
	
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
	
	

public void setSoundVolumePlus(View v){
	
	
	 
	
	this.volume++;
	checkVolumeNumber();
	      }


	

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
		
		
	}
	
	if(volume == 2)
	{
		
		b_number = (Button) findViewById(R.id.button_volume_number);
		b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no2));
		
	}
	if(volume == 3)
	{
		
		b_number = (Button) findViewById(R.id.button_volume_number);
		b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no3));
		
	}
	if(volume == 4)
	{
		
		b_number = (Button) findViewById(R.id.button_volume_number);
		b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no4));
		
	}
	if(volume == 5)
	{
		
		b_number = (Button) findViewById(R.id.button_volume_number);
		b_number.setBackgroundDrawable(getResources().getDrawable(R.drawable.no5));
		
		
	}
	if(volume >= 5)
	{
		
		SoundOutOfVolumeNumber();
		
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
	


}