package com.cmpe277.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.cmpe277.R;

/**
 * 
 * @author DEVEN Home Activity that contains the first screen after splash
 *         screen for showing intent behavior
 * 
 */
public class HomeActivity extends Activity {
	private Button button1;
	private Button button2;
	private boolean isB1Pressed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		getActionBar().setTitle(R.string.title);

		/**
		 * Hide Home Icon
		 */
		getActionBar().setDisplayShowHomeEnabled(false);

		button1 = (Button) findViewById(R.id.button_1);
		button2 = (Button) findViewById(R.id.button_2);

		/**
		 * Set On Click Listener for Buttons
		 */
		button1.setOnClickListener(onClickListener);
		button2.setOnClickListener(onClickListener);
	}

	/**
	 * On Click Listener for Buttons
	 */
	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View view) {
			int id = view.getId();
			switch (id) {
			/**
			 * Action on pressing Button 1. Display SJSU home page in web
			 * browser.
			 */
			case R.id.button_1:
				String sjsuURL = "http://www.sjsu.edu/";
				Intent myIntent = new Intent(Intent.ACTION_VIEW,
						Uri.parse(sjsuURL));
				startActivity(myIntent);
				break;
			/**
			 * Action on pressing Button 2. If SJSU page is displayed then show
			 * a dialog saying assignment completed.
			 */
			case R.id.button_2:
				if (isB1Pressed)
					showDialog();
				break;

			default:
				break;
			}

		}
	};

	@Override
	protected void onStop() {
		Log.d("******On Stop", " Called**********");
		isB1Pressed = true;
		super.onStop();
	}

	/**
	 * function for displaying dialog
	 */
	public void showDialog() {
		/**
		 * Alert dialog for displaying message
		 */
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle(getResources().getString(R.string.dialog_title));
		dialog.setMessage(getResources().getString(R.string.dialog_message));
		dialog.setPositiveButton(getResources().getString(R.string.ok),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

					}
				});
		dialog.show();
	}

}
