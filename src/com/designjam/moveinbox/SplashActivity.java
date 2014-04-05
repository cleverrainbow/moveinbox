package com.designjam.moveinbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.moveinbox.R;
import com.munichjam.core.MenuMainActivity;

public class SplashActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Button button = (Button) findViewById(R.id.start_move);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.start_move) {
			Intent intent = new Intent(this, MenuMainActivity.class);
			startActivity(intent);
		}
		
	}
	
	

}
