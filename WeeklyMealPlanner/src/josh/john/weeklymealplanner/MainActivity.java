package josh.john.weeklymealplanner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "josh.john.weeklymealplanner";
	SharedPreferences prefs = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// This sets up the shared preferences for first time app usage
		// All code was got from https://www.youtube.com/watch?v=wc_v3edv3TA
		boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
				.getBoolean("isfirstrun", true);

		// This is used for when the app is first activated to create the database
		if (isFirstRun) {
			DatabaseHelper db = new DatabaseHelper(this);
			db.createWMP("mealPlanName");
			Log.d("Just created db", "Just created db");

			getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
					.putBoolean("isfirstrun", false).commit();
		}

		Log.d("Inside main", " main");

		// uses an intent and passes the meal plan name
		// All code is got from 
		// http://developer.android.com/training/basics/firstapp/starting-activity.html#StartActivity
		Intent intent = new Intent(this, WMP.class);
		intent.putExtra(MainActivity.EXTRA_MESSAGE, "mealPlanName");

		Log.d(EXTRA_MESSAGE.toString(), "mealPlanName");
		startActivity(intent);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();

		}
	}

	// All these below were generated by the ADT plugin for eclipse
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}