package cc.dividebyzero.octoninja;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import cc.dividebyzero.octoninja.giphy.Search;
import cc.dividebyzero.octoninja.giphy.SearchParams;
import cc.dividebyzero.octoninja.giphy.SearchResult;

import java.util.ArrayList;

public class NinjaMaster extends Activity {
    private AdapterView grid;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ninja_master_acv);

        //THE GRID.
        this.grid = (AdapterView) findViewById(R.id.gridView);
        final GifAdapter gifAdapter = new GifAdapter(getApplicationContext());

        grid.setAdapter(gifAdapter);

        SearchParams params = new SearchParams();
        params.searchTerms = new ArrayList<String>();
        params.searchTerms.add("ninja");

        Search search = new Search(getApplicationContext(),params, new Search.SearchListener() {
            @Override
            public void onResult(SearchResult result) {
                if(result.data != null)
                    android.util.Log.d("SearchResult",result.data.toString());
                    gifAdapter.addData(result.data);
            }
        });

        search.execute();
    }


}
