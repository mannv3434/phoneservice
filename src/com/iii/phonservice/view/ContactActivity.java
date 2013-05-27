package com.iii.phonservice.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iii.phoneservice.R;

public class ContactActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		Button btnSend = (Button) findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog();
				finish();
			}
		});
		Button btnCancel = (Button) findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog();
				finish();
			}
		});
	}

	@SuppressWarnings("deprecation")
	private void showDialog() {
		AlertDialog builder = new AlertDialog.Builder(this).create();
		builder.setTitle("PHONE APP IS LOCKED");
		builder.setIcon(R.drawable.facebook);
		builder.setButton("OK", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "You clicked on OK",
						Toast.LENGTH_SHORT).show();
			}
		});
		builder.show();
	}

}
