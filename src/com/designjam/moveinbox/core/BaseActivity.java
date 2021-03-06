package com.designjam.moveinbox.core;

import android.os.Bundle;
import android.view.WindowManager;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.designjam.moveinbox.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class BaseActivity extends SlidingFragmentActivity {
	
	private int appTitle;
	protected SherlockListFragment menuFragment; 
	public Menu menu;
	
	public BaseActivity(int title){
		super();
		appTitle = title;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 

		
		setTitle(appTitle);
		setBehindContentView(R.layout.menu_frame);
		android.support.v4.app.FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
		menuFragment = new MenuList();
		ft.replace(R.id.menu_frame, menuFragment);
		ft.commit();
		
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidth(30);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffset(70);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//getSupportActionBar().setIcon(R.drawable.launchericon_artwork);
	}
	
	
	@Override	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		this.menu = menu;
		/*menu.findItem(R.id.add_alarm).setVisible(false);
		menu.findItem(R.id.save_alarm).setVisible(false);
		menu.findItem(R.id.cancel_alarm).setVisible(false);
		menu.findItem(R.id.cancel_alarm).setEnabled(false);
		menu.findItem(R.id.save_alarm).setEnabled(false);
		menu.findItem(R.id.add_alarm).setEnabled(false);
		
		return super.onCreateOptionsMenu(menu);
	}
	*/
	
}