package com.example.enginetest;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	
	private int difficulty = 0;  //Schwierigkeitsgrad, wird benutzt um spezifische Activity zu starten
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);			//MainActivity wird gestartet und gezeigt, wenn nicht anders gewollt

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
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
	public void easyPressed (View view){
		
		difficulty = 1;									//je nach Schwierigkeit soll andere Activity ge�ffnet werden mit anderen Parametern(quasi leicht und mittel sind 2 verschieden games)
		setContentView(new GameActivity(this));
		
	}
	public void midPressed(View view){
		
		difficulty = 2;
		setContentView(new GameActivity(this));
	}

	public void hardPressed(View view){
		
		difficulty = 3;
		setContentView(new GameActivity(this));
		
	}
	@SuppressWarnings("deprecation")
	public void closeApp(View view){
		
		AlertDialog ad = new AlertDialog.Builder(this).create(); // �ffnet Dialog, der dich fragt ob du wirklich beenden willst
		ad.setTitle("App wirklich schlie�en?");
		ad.setButton("OK", new DialogInterface.OnClickListener() {        //Best�tigung via OnClickListener
																			//Hier gibt es noch Probleme, funktion veraltet? Wird nicht angezeigt!
			@Override
			public void onClick(final DialogInterface dialog, final int which) {
				MainActivity.this.finish();
				
			}
		});
		
		ad.setButton2("Nein!",new DialogInterface.OnClickListener() {  //gleiches Problem
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "App wird fortgesetzt!", Toast.LENGTH_LONG).show();
				
			};
		});
		
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
