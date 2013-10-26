package cc.dividebyzero.octoninja.giphy;

import android.content.Context;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: zero
 * Date: 10/26/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Search {

    public interface SearchListener {
        public void onResult(SearchResult result);
    }

    private final Context context;

    private final SearchListener listener;

    public final SearchParams params;

    public Search(Context context,SearchParams params,SearchListener listener){
        this.context = context;
        this.params = params;
        this.listener = listener;
    }

    public Future execute(){
        return Ion.with(context)
                .load(createUrl())
                .asJsonObject()
                .setCallback(new FutureCallback<com.google.gson.JsonObject>() {
                    ;

                    @Override
                    public void onCompleted(Exception e, com.google.gson.JsonObject jsonObject) {
                        if( e != null){
                            e.printStackTrace();
                        }
                        SearchResult result = parseJson(jsonObject);
                        result.params = params;
                        if(listener != null)
                            listener.onResult(result);
                    }
                });
    }

    private SearchResult parseJson(JsonObject jsonObject) {

        android.util.Log.v("Search","json = "+jsonObject);
        if(jsonObject == null){
            return new SearchResult();
        }
        JsonArray data = jsonObject.getAsJsonArray("data");
        final int len = data.size();

        ArrayList<Gif> lollingCats = new ArrayList<Gif>(len);

        Gif gif;
        for ( int i = 0; i<len; i ++){
            JsonObject images = data.get(i).getAsJsonObject().getAsJsonObject("images");

            JsonObject original = images.getAsJsonObject("original");

            gif = new Gif();

            gif.height = original.get("height").getAsInt();
            gif.width = original.get("width").getAsInt();
            gif.url = original.get("url").getAsString();
            gif.frames = original.get("frames").getAsInt();

            lollingCats.add(gif);


        }


        SearchResult result = new SearchResult();
        result.data = lollingCats;
        return result;
    }

    private String createUrl() {

        StringBuffer buffy = new StringBuffer();

        buffy.append("http://api.giphy.com/v1/gifs/search?");
        buffy.append("q=");
        buffy.append(this.params.searchTerms.get(0));

        final int len = this.params.searchTerms.size();
        for(int i = 1; i< len; i++){
            buffy.append("+");
            buffy.append(this.params.searchTerms.get(i));
        }

        buffy.append("&api_key=dc6zaTOxFJmzC");

        android.util.Log.v("Search","URI>>"+buffy.toString()+"<<");
        return buffy.toString();
    }
}
