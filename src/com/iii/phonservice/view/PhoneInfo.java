package com.iii.phonservice.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iii.phoneservice.R;
import com.iii.phoneservice.login.RegisterActivity;

public class PhoneInfo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phoneinfo_layout);
		initialize();

		Button btnYes = (Button) findViewById(R.id.btnYes);
		btnYes.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// 1. update info of phone to database
				// 2. show Login, register activity
				startActivity(new Intent(PhoneInfo.this, RegisterActivity.class));
				finish();
			}
		});
	}

	private void initialize() {
		EditText editBrand = (EditText) findViewById(R.id.brandName);
		editBrand.setText(android.os.Build.MANUFACTURER);

		EditText editModel = (EditText) findViewById(R.id.modelName);
		editModel.setText(android.os.Build.MODEL);
		editModel.setSelected(true);

		EditText editImei = (EditText) findViewById(R.id.imei);
		editImei.setText(getImei());

		EditText editSim = (EditText) findViewById(R.id.sim);
		editSim.setText(getOperatorName());

	}

	// -------------get Sim network--------------------------//
	private String getOperatorName() {
		// Get the phone number from the telephony manager, and display it
		TelephonyManager info = (TelephonyManager) getApplicationContext()
				.getSystemService(Context.TELEPHONY_SERVICE);
		String phoneOperatorName = info.getNetworkOperatorName();
		return phoneOperatorName;
	}

	// -------get imei of phone----------------------------------//
	private String getImei() {
		TelephonyManager tManager = (TelephonyManager) PhoneInfo.this
				.getSystemService(Context.TELEPHONY_SERVICE);
		String uid = tManager.getDeviceId();
		if (uid == null) {
			uid = "111111111111111";
		}
		return uid;
	}

	// -----------getNumber Car-------------------------------//
	private String getNumberSimCard() {
		String network;
		TelephonyManager tm = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);

		ConnectivityManager cm = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm.getActiveNetworkInfo().getTypeName().equals("MOBILE"))
			network = "cellnetwork/3G";
		else if (cm.getActiveNetworkInfo().getTypeName().equals("WIFI"))
			network = "wifi";
		else
			network = "na";

		String uphone = tm.getDeviceSoftwareVersion();
		return network;
	}
}
