package com.iii.phoneservice.viewmarket;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.iii.phoneservice.R;
import com.iii.phonservice.adapter.MaketAdapter;
import com.iii.phonservice.model.Message;

public class MainActivity_Viewmarket extends Activity implements OnClickListener, OnItemClickListener {

	private ListView lvMessage;
	private Button btnMessPrivate, btnMessGroup, btnMessPublic;
	private ArrayList<Message> lstMessage;
	private MaketAdapter adapter;
	private ImageView imgback;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_market);
		init();
		showListView();
		
	}

	private void init() {
		lvMessage = (ListView)findViewById(R.id.lvMessage);
		btnMessPrivate = (Button)findViewById(R.id.btnMessPrivateview);
		btnMessGroup = (Button)findViewById(R.id.btnMessGroupview);
		btnMessPublic = (Button)findViewById(R.id.btnMessPublicview);
		imgback = (ImageView) findViewById(R.id.imgback);
		/*
		TabHost tabhost = (TabHost)findViewById(R.id.tabhost);
			tabhost.addTab(tabhost.newTabSpec("Tab1").setIndicator("",getResources().getDrawable(R.drawable.ic_launcher)).setContent(new Intent(getBaseContext(), Activity1.class)));
			tabhost.addTab(tabhost.newTabSpec("Tab2").setIndicator("",getResources().getDrawable(R.drawable.ic_launcher)).setContent(new Intent(getBaseContext(), Activity1.class)));
			tabhost.addTab(tabhost.newTabSpec("Tab3").setIndicator("",getResources().getDrawable(R.drawable.ic_launcher)).setContent(new Intent(getBaseContext(), Activity1.class)));
		*/	
		btnMessPrivate.setOnClickListener(this);
		btnMessPrivate.setBackgroundResource(R.drawable.header_select);
		
		btnMessGroup.setOnClickListener(this);
		btnMessGroup.setBackgroundResource(R.drawable.header1);
		
		btnMessPublic.setOnClickListener(this);
		btnMessPublic.setBackgroundResource(R.drawable.header1);
		imgback.setOnClickListener(this);
		
		lstMessage = new ArrayList<Message>();
			lstMessage.add(new Message("image1", "Message one", "Content message one", "20:30"));
			lstMessage.add(new Message("image2", "Message two", "Content message two", "21:30"));
		adapter = new MaketAdapter(lstMessage, this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnMessPrivateview:
			btnMessPrivate.setBackgroundResource(R.drawable.header_select);
			btnMessPublic.setBackgroundResource(R.drawable.header1);
			btnMessGroup.setBackgroundResource(R.drawable.header1);
//			Toast.makeText(getBaseContext(), "private Message", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnMessPublicview:
			btnMessPublic.setBackgroundResource(R.drawable.header_select);
			btnMessPrivate.setBackgroundResource(R.drawable.header1);
			btnMessGroup.setBackgroundResource(R.drawable.header1);
//			Toast.makeText(getBaseContext(), "Public Message", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnMessGroupview:
			btnMessGroup.setBackgroundResource(R.drawable.header_select);
			btnMessPublic.setBackgroundResource(R.drawable.header1);
			btnMessPrivate.setBackgroundResource(R.drawable.header1);
//			Toast.makeText(getBaseContext(), "Group Message", Toast.LENGTH_SHORT).show();
			break;
		case R.id.imgback:
//			Toast.makeText(getBaseContext(), "back", Toast.LENGTH_SHORT).show();
			break;
		}
	}
	private void showListView() {
		lvMessage.setAdapter(adapter);
		lvMessage.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int i, long arg3) {
		Toast.makeText(getBaseContext(), lstMessage.get(i).getName(), Toast.LENGTH_SHORT).show();
	}

}
