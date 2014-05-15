package josh.john.weeklymealplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.TextView;

public class DisplayMealPlan extends ActionBarActivity {

	TextView breakfast;
	TextView lunch;
	TextView dinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_meal_plan);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		DatabaseHelper db = new DatabaseHelper(this);
		String mpId = db.getWeeklyMealPlanID(message);

		TextView titleText = (TextView) findViewById(R.id.Meal_Plan_Name);
		titleText.setText(message + " " + mpId);
//		populate(mpId);
	}
/*
	public void populate(String weekId) {
		DatabaseHelper db = new DatabaseHelper(this);
		// ArrayList get
		ArrayList<String> daysOfWeek = db.getEachWeekDayID(weekId);
		ArrayList<String> mealTimes = null;
		for (int i = 0; i < daysOfWeek.size(); i++) {

			mealTimes = db.getMealTimes(daysOfWeek.get(i));

			switch (i) {
			case 0:
				breakfast = (TextView) findViewById(R.id.Sunday_Breakfast);
				breakfast.setText(mealTimes.get(0));
				registerForContextMenu(breakfast);
				lunch = (TextView) findViewById(R.id.Sunday_Lunch);
				lunch.setText(mealTimes.get(1));
				registerForContextMenu(lunch);
				dinner = (TextView) findViewById(R.id.Sunday_Dinner);
				dinner.setText(mealTimes.get(2));
				registerForContextMenu(dinner);
				break;
			case 1:
				breakfast = (TextView) findViewById(R.id.Monday_Breakfast);
				breakfast.setText(mealTimes.get(0));
				registerForContextMenu(breakfast);
				lunch = (TextView) findViewById(R.id.Monday_Lunch);
				lunch.setText(mealTimes.get(1));
				registerForContextMenu(lunch);
				dinner = (TextView) findViewById(R.id.Monday_Dinner);
				dinner.setText(mealTimes.get(2));
				registerForContextMenu(dinner);
				break;
			case 2:
				breakfast = (TextView) findViewById(R.id.Tuesday_Breakfast);
				breakfast.setText(mealTimes.get(0));
				registerForContextMenu(breakfast);
				lunch = (TextView) findViewById(R.id.Tuesday_Lunch);
				lunch.setText(mealTimes.get(1));
				registerForContextMenu(lunch);
				dinner = (TextView) findViewById(R.id.Tuesday_Dinner);
				dinner.setText(mealTimes.get(2));
				registerForContextMenu(dinner);
				break;
			case 3:
				breakfast = (TextView) findViewById(R.id.Wednesday_Breakfast);
				breakfast.setText(mealTimes.get(0));
				registerForContextMenu(breakfast);
				lunch = (TextView) findViewById(R.id.Wednesday_Lunch);
				lunch.setText(mealTimes.get(1));
				registerForContextMenu(lunch);
				dinner = (TextView) findViewById(R.id.Wednesday_Dinner);
				dinner.setText(mealTimes.get(2));
				registerForContextMenu(dinner);
				break;
			case 4:
				breakfast = (TextView) findViewById(R.id.Thursday_Breakfast);
				breakfast.setText(mealTimes.get(0));
				registerForContextMenu(breakfast);
				lunch = (TextView) findViewById(R.id.Thursday_Lunch);
				lunch.setText(mealTimes.get(1));
				registerForContextMenu(lunch);
				dinner = (TextView) findViewById(R.id.Thursday_Dinner);
				dinner.setText(mealTimes.get(2));
				registerForContextMenu(dinner);
				break;
			case 5:
				breakfast = (TextView) findViewById(R.id.Friday_Breakfast);
				breakfast.setText(mealTimes.get(0));
				registerForContextMenu(breakfast);
				lunch = (TextView) findViewById(R.id.Friday_Lunch);
				lunch.setText(mealTimes.get(1));
				registerForContextMenu(lunch);
				dinner = (TextView) findViewById(R.id.Friday_Dinner);
				dinner.setText(mealTimes.get(2));
				registerForContextMenu(dinner);
				break;
			case 6:
				breakfast = (TextView) findViewById(R.id.Saturday_Breakfast);
				breakfast.setText(mealTimes.get(0));
				registerForContextMenu(breakfast);
				lunch = (TextView) findViewById(R.id.Saturday_Lunch);
				lunch.setText(mealTimes.get(1));
				registerForContextMenu(lunch);
				dinner = (TextView) findViewById(R.id.Saturday_Dinner);
				dinner.setText(mealTimes.get(2));
				registerForContextMenu(dinner);
				break;
			}
		}

	}
*/
	public void registerForContextMenu(View view) {
		view.setOnCreateContextMenuListener(this);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		Log.d(menuInfo.toString(), "pressed");

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.wmp_a_u_r, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();

		DatabaseHelper db = new DatabaseHelper(this);
		switch (item.getItemId()) {
		case R.id.add_Recipe:
			db.addMealTimeToWeekDay(3, info.id);
			return true;
		case R.id.display_Recipe:
			// deleteNote(info.id);
			return true;
		case R.id.remove_Recipe:
			// deleteNote(info.id);
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_meal_plan, menu);
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
			View rootView = inflater.inflate(
					R.layout.fragment_display_meal_plan, container, false);
			return rootView;
		}
	}

}
