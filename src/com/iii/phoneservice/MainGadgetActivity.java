package com.iii.phoneservice;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iii.phoneservice.login.LoginActivity;
import com.iii.phonservice.model.Phone;
import com.iii.phonservice.view.ContactActivity;
import com.iii.phonservice.view.PhoneInfo;

public class MainGadgetActivity extends Activity {

	private String TAG = MainGadgetActivity.this.toString();
	private static Phone myPhone;
	private static final int LOST_DIALOG = 4;
	private static final int RETIRED_DIALOG = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_login_layout);
		initialize();
		myPhone = new Phone("SAMSUNG", "GT-930", "12345678921457",
				"27-05-2013", "27-05-2013", 4, 0);
		checkStatusPhone();

	}

	private boolean checkStatusPhone() {
		int phoneStatus = myPhone.getStatus();
		switch (phoneStatus) {
		case 0:
			// ---------phone fresh-----------------//
			break;
		case 1:
			// ---------phone regular-----------------//
			break;
		case 2:
			// ---------phone for sale-----------------//
			break;
		case 3:
			// ---------phone retired-----------------//
			notification(3);
			break;
		case 4:
			// ---------phone lost-----------------//
			notification(4);
			break;

		default:
			break;
		}
		return false;
	}

	// --------method notification phone lost-------//
	@SuppressWarnings("deprecation")
	private void notification(int id) {

		switch (id) {
		case RETIRED_DIALOG: {
			AlertDialog builder = new AlertDialog.Builder(this).create();
			builder.setTitle("PHONE IS LOST");
			builder.setIcon(R.drawable.facebook);
			builder.setButton("OK", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(),
							"You clicked on OK", Toast.LENGTH_SHORT).show();
				}
			});
			builder.show();
		}
			break;
		case LOST_DIALOG: {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

			// Setting Dialog Title
			alertDialog.setTitle("PHONE IS LOST");

			// Setting Dialog Message
			alertDialog.setMessage("Do you want to contact owner?");

			// Setting Icon to Dialog
			alertDialog.setIcon(R.drawable.facebook);

			// Setting Positive "Yes" Button
			alertDialog.setPositiveButton("YES",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							// Write your code here to invoke YES event
							Toast.makeText(getApplicationContext(),
									"You clicked on YES", Toast.LENGTH_SHORT)
									.show();
							//-----get info of owner from ws-----------//
							//-----make toast-------------------------//
							Intent intent = new Intent(MainGadgetActivity.this,
									ContactActivity.class);
							startActivity(intent);
							finish();
							
						}
					});

			// Setting Negative "NO" Button
			alertDialog.setNegativeButton("NO",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// Write your code here to invoke NO event
							Toast.makeText(getApplicationContext(),
									"You clicked on NO", Toast.LENGTH_SHORT)
									.show();
							dialog.cancel();
						}
					});

			// Showing Alert Message
			alertDialog.show();
		}

		}

	}

	// -------------this method to init action login, register----//
	private void initialize() {
		Button btnRegister = (Button) findViewById(R.id.btnRegister);
		btnRegister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// -------ws to check info of phone-------------//
				new WSClassReadInfo(MainGadgetActivity.this).execute();
			}
		});

		Button btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainGadgetActivity.this,
						LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_gadget, menu);
		return true;
	}

	private class WSClassReadInfo extends AsyncTask<Void, Void, Void> {

		// ------------fields-------------------------------//
		private String TAG = WSClassReadInfo.this.toString();

		private ProgressDialog progressDialog;

		// ------------Constructor--------------------------//
		public WSClassReadInfo(Context context) {
			progressDialog = new ProgressDialog(context);
		}

		// -----------reading data here-------------------//
		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(1000);

			} catch (Exception e) {

				progressDialog.dismiss();
			}
			return null;
		}

		// ----------finish dialog-------------------------//
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			Intent intent = new Intent(MainGadgetActivity.this, PhoneInfo.class);
			startActivity(intent);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			finish();

			if (progressDialog != null)
				progressDialog.dismiss();

		}

		// --------run at main thread-----------------------//
		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			progressDialog.setMessage("Checking phone info...");
			progressDialog.setCancelable(false);
			progressDialog.show();

		}

		// --------processing------------------------------//
		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
			Log.i(TAG, "Errors");
		}

	}

}
