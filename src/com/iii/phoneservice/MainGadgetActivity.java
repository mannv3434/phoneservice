package com.iii.phoneservice;

import com.iii.phonservice.view.PhoneInfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainGadgetActivity extends Activity {

	private String TAG = MainGadgetActivity.this.toString();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		new WSClassReadInfo(this).execute();
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

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			progressDialog.setMessage("Checking phone info...");
			progressDialog.setCancelable(false);
			progressDialog.show();

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
			Log.i(TAG, "Errors");
		}

	}

}
