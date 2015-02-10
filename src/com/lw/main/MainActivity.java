package com.lw.main;

import com.lw.fragment.BitmapListFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getFragmentManager().beginTransaction().replace(R.id.fragment,new BitmapListFragment()).commit();
	}

}
