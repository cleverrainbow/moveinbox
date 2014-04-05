package com.designjam.moveinbox.core;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.designjam.moveinbox.R;
import com.designjam.moveinbox.ui.PapersBeforeGuideFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;



public class MenuMainActivity extends BaseActivity {

	private Fragment mainView;

	public MenuMainActivity() {
		super(R.string.app_name);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		if (savedInstanceState != null) {
			mainView = getSupportFragmentManager().getFragment(
					savedInstanceState, "mainView");
		}else{
			mainView = (Fragment) new PapersBeforeGuideFragment();
		}
		setContentView(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, mainView).commit();

		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new MenuList()).commit();

		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mainView", mainView);
	}

	public void switchContent(Fragment fragment) {
		mainView = fragment;
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment)
				.addToBackStack(null).commit();
		getSlidingMenu().showContent();
		this.invalidateOptionsMenu();
	}
	
	@Override
	public void onBackPressed(){
		if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
	}
}