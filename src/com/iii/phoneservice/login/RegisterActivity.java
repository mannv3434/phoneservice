package com.iii.phoneservice.login;

import com.iii.phoneservice.MainGadgetActivity;
import com.iii.phoneservice.R;
import com.iii.phonservice.view.PhoneInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RegisterActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		// ---------------------finish register--------------------//
		ImageButton btnRegFinish = (ImageButton) findViewById(R.id.btnRegFinish);
		btnRegFinish.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ----------add info of new user to server-------//
				// if true - passing to login
				Intent intent = new Intent(RegisterActivity.this,
						LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
