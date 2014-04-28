package josh.john.weeklymealplanner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

import josh.john.weeklymealplanner.recipeendpoint.Recipeendpoint;
import josh.john.weeklymealplanner.recipeendpoint.Recipeendpoint.ListRecipe;
import josh.john.weeklymealplanner.recipeendpoint.model.CollectionResponseRecipe;
import josh.john.weeklymealplanner.recipeendpoint.model.Recipe;

import com.google.api.client.util.Strings;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();

		}
	}

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

	public void onClickGetGreeting(View view) {
		View rootView = view.getRootView();
		EditText greetingIdInputTV = (EditText) rootView
				.findViewById(R.id.editText1);
		greetingIdInputTV.setText("John");
		downloadRecipes recList = new downloadRecipes();
		
	}
	
	public void displayRecipe(CollectionResponseRecipe recipes) {
		
	}

	private class downloadRecipes extends
			AsyncTask<CollectionResponseRecipe, Void, CollectionResponseRecipe> {

		@Override
		protected CollectionResponseRecipe doInBackground(
				CollectionResponseRecipe... params) {
			Recipeendpoint APIHandle = AppConstants.getApiServiceHandle();

			try {
				ListRecipe getRecipeList = APIHandle.listRecipe();
				CollectionResponseRecipe recList = getRecipeList.execute();
				return recList;
			} catch (IOException e) {
				Log.e(CONNECTIVITY_SERVICE, "Exception during API call", e);
			}

			return null;
		}
		
        @Override
        protected void onPostExecute(CollectionResponseRecipe recipes) {
          if (recipes!=null) {
            displayRecipe(recipes);
          } else {
            Log.e(LOG_TAG, "No greetings were returned by the API.");
          }
        }

	}
}