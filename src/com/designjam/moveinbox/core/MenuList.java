package com.designjam.moveinbox.core;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.designjam.moveinbox.R;

public class MenuList extends SherlockListFragment {
	
	//TODO make a method that takes partner's name for an item in the menu
	String[] menu = {"Name", "Paper", "Housing", "Guide", "Language", "Fun", "Shop", "My Box"};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list, container, false);
		
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter<String> menuAdapter = new ArrayAdapter<String>(getActivity(),
				R.layout.menu_layout, menu);
		
		setListAdapter(menuAdapter);
	}
	
	

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Fragment newContent = null; 
		/*switch(position) {
		case 0: 
			newContent = new MyAlarmListFragment();
			break;
		case 1: 
			newContent = new PartnerAlarmFragment();
			break;
		case 2: 
			newContent = new GalleryFragment();
			break;
		case 3: 
			newContent = new SettingsFragment();
			break;
		}*/
		if (newContent != null) {
			switchFragment(newContent);
		}
	}

	private void switchFragment(Fragment fragment) {
		if (getActivity() == null) {
			return;
		}
		
		/*
		if (getActivity() instanceof MenuMainActivity) {
			MenuMainActivity mma = (MenuMainActivity) getActivity();
			mma.switchContent(fragment);
		}
		*/ 
	}
	
}
