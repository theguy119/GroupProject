package com.example.enginetest;

import com.example.enginetest.OptionsActivity;
import com.example.enginetest.MainActivity;
import com.example.enginetest.SoundManager;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	
	
	//Aufgrund von nicht nachvollziehbaren Problemen beim kommunizieren
	//der Activitys hab ich Main und Option zusammengelegt damit es erstmal geht!
	
	private int counter = 0; // Dient nur dazu um auf einfache Weise anzugeben in welchem Layout beim drücken des BackButtons was passieren soll
	MediaPlayer bgsound;	//zum laden der Soundfiles
	private final static int MAX_VOLUME = 5;
	private float IngameVolume = 1.0f;
	
	//------------

	
	
	//-----------------
	
	
	private int volume = 1;	//Volume für Optionsmenue
	private int difficulty = 0;  //Schwierigkeitsgrad, wird benutzt um spezifische Activity zu starten
	private int CurrentVolume = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		SoundManager SManager = new SoundManager();//MainActivity wird gestartet und gezeigt, wenn nicht anders gewollt
		
		
		//---------SoundAufruf-------
		
		bgsound = MediaPlayer.create(MainActivity.this,R.raw.bg_music);
		bgsound.setLooping(true);		//Loop für den Sound
		bgsound.start();	
	
		
		
		
		
		
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void resetIt()
	{
		bgsound.start();
	}
	
	public void onStart(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()){
		
		case R.id.action_settings:
			setContentView(R.layout.enginelayout);
			return true;
			default:
				
		}
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	public void onStop()
	{
		MainActivity.this.onPause();
		bgsound.stop();
		
	}

	public void easyPressed (View view){
		
		difficulty = 1;									//je nach Schwierigkeit soll andere Activity geöffnet werden mit anderen Parametern(quasi leicht und mittel sind 2 verschieden games)
		bgsound.stop();	
		setContentView(new GameActivity(this));			//für unser Projekt erstmal uninteressant, weil nur eine Schwierigkeit die mit vorranschreitender Spieldauer zunimmt!
		
		
	}
	
	
	
	
	//Wenn mann auf den OptionsButton drückt:
	
	public void OptionsPressed(View view){
		MainActivity.this.finish();
		
		Intent i = new Intent(MainActivity.this, OptionsActivity.class);
	    startActivity(i);
	    
	    counter = 1;
		
	}
	
	
	public int getDifficulty(){
		
		
		return difficulty;
		
	}
	
	
	
	// Wenn man auf den BackButton drückt
	
	public void onBackPressed()
	{
		if(counter == 0)
		{
		bgsound.stop();
		MainActivity.this.finish();
		}
		if(counter == 1)
		{
			setContentView(R.layout.activity_main);
			bgsound.start();
			
		}
	}
	
	
	
	
	
	//Wenn man auf ExitButton im MainMenu drückt
	public void closeApp(View view){
		
		bgsound.stop();	
		AlertDialog.Builder ad = new AlertDialog.Builder(this); // Öffnet Dialog, der dich fragt ob du wirklich beenden willst
		
			ad.setTitle("Noch nix...");

				
				
			
			ad
					.setMessage("Drücke OK um die App zu beenden")
					.setCancelable(false)
					.setPositiveButton("OK!",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// schließt App wenn gedrückt
							
						
							
							MainActivity.this.finish();
						}
					  })
					  
					  
					  
					.setNegativeButton("NEIN!",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							//App läuft weiter, Dialog wird geschlossen
							
							dialog.cancel();
						}
					});

	
					AlertDialog alertDialog = ad.create();			// AlertDialog wird erstellt

					
					alertDialog.show();  // Alert Dialog wird angezeigt
				}
			
		
		
		

	
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}																		//hat android erstellt

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
	
