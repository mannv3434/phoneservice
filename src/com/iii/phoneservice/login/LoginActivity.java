package com.iii.phoneservice.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.iii.phoneservice.R;
import com.iii.phoneservice.viewmarket.MainActivity_Viewmarket;
import com.iii.phoneservice.viewmarket.MainTabMarket;

public class LoginActivity extends Activity {
	private Button btnLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		btnLogin= (Button)findViewById(R.id.imageButton1);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, MainTabMarket.class));
				
			}
		});
	}
}
