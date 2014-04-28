package josh.john.weeklymealplanner;

import josh.john.weeklymealplanner.recipeendpoint.Recipeendpoint;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

public class AppConstants {

    /**
     * Class instance of the JSON factory.
     */
    public static final JsonFactory JSON_FACTORY = new AndroidJsonFactory();

    /**
     * Class instance of the HTTP transport.
     */
    public static final HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();


    /**
     * Retrieve a Helloworld api service handle to access the API.
     */
    public static Recipeendpoint getApiServiceHandle() {
        // Use a builder to help formulate the API request.
    	Recipeendpoint.Builder recipe = new Recipeendpoint.Builder(AppConstants.HTTP_TRANSPORT,
                AppConstants.JSON_FACTORY,null);

        return recipe.build();
    }

}