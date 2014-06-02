package com.example.enginetest;

import android.app.Activity;
import android.media.MediaPlayer;

public class SoundManager extends Activity{

	MediaPlayer bgsound;
	
	public boolean musicIsOn;
	public SoundManager() {
		// TODO Auto-generated constructor stub
	}

	
	
	 
	   public void initSound()
	   {
		   bgsound = MediaPlayer.create(SoundManager.this,R.raw.bg_music);
			   
	   }
	   
	   public void StartMusic()
	   {
		 
		 //---------SoundAufruf-------
			
		   
			bgsound.setLooping(true);		//Loop für den Sound
			bgsound.start();	
			
			
			
		   
	   }
	   
	   public void StopMusic()
	   {
		   bgsound.stop();
	   }
	   
	   public boolean checkCurrentMusicStatus()
	   {
		   
		   if(musicIsOn == true)
		   {
			   return true;
		   }
		   else return false;
		   
	   }
	
	
}
