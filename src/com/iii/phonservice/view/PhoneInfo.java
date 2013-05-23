package com.iii.phonservice.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.iii.phoneservice.R;

public class PhoneInfo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phoneinfo_layout);

	}

	private void initialize() {
		EditText editBrand = (EditText) findViewById(R.id.brandName);
		editBrand.setText(android.os.Build.MANUFACTURER);
		
		EditText editModel = (EditText) findViewById(R.id.modelName);
		editModel.setText(android.os.Build.MODEL);
		
		EditText editImei = (EditText) findViewById(R.id.imei);
		
		EditText editSim = (EditText) findViewById(R.id.sim);
		
		String AndroidVersion = android.os.Build.VERSION.RELEASE;
		String product        = android.os.Build.PRODUCT;
		String menutral       =android.os.Build.MANUFACTURER;
		String device       =android.os.Build.DEVICE;

	}
}
