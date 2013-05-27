package com.iii.phoneservice.viewmarket;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.iii.phoneservice.R;
import com.iii.phoneservice.filter.FilterActivity;

@SuppressWarnings("deprecation")
public class MainTabMarket extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.footer);
		TabHost tabhost = getTabHost();
		TabWidget tab=getTabWidget();
		tabhost.addTab(tabhost.newTabSpec("Tab1")
				.setIndicator("", getResources().getDrawable(R.drawable.home))
				.setContent(new Intent(getBaseContext(), MainActivity_Viewmarket.class)));
		tab.getChildAt(0).setBackgroundColor(Color.YELLOW);
		tabhost.addTab(tabhost
				.newTabSpec("Tab2")
				.setIndicator("",
						getResources().getDrawable(R.drawable.contacy))
				.setContent(new Intent(getBaseContext(), Contact.class)));
		tab.getChildAt(1).setBackgroundColor(Color.YELLOW);
		
		tabhost.addTab(tabhost
				.newTabSpec("Tab3")
				.setIndicator("",
						getResources().getDrawable(R.drawable.phoneprofile))
				.setContent(new Intent(getBaseContext(), MainActivity_Viewmarket.class)));
		tab.getChildAt(2).setBackgroundColor(Color.YELLOW);
		
		tabhost.addTab(tabhost
				.newTabSpec("Tab4")
				.setIndicator("", getResources().getDrawable(R.drawable.filter))
				.setContent(new Intent(getBaseContext(), FilterActivity.class)));
		tab.getChildAt(3).setBackgroundColor(Color.YELLOW);
	}
}
