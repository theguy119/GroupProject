package com.example.enginetest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class GameActivity extends View {      			// Hier wird das eigentliche Spiel/App initialisiert, gestartet und angezeigt!

	public GameActivity(Context context) {				//Wenn du es so willst, dann ist das hier der Einstiegspunkt für dich um die Spielgrundlage zu basteln.
		super(context);
	
	}

	public GameActivity(Context context, AttributeSet attrs) {
		super(context, attrs);
	
	}

	public GameActivity(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
	}

}
