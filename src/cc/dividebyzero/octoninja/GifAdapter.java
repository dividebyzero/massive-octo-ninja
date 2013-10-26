package cc.dividebyzero.octoninja;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import cc.dividebyzero.octoninja.giphy.Gif;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zero
 * Date: 10/26/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class GifAdapter extends BaseAdapter {

    private final Context context;
    List<Gif> data = new ArrayList<Gif>();


    public GifAdapter(final Context context){
        this.context =  context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iv = new ImageView(context);
        Ion.with(iv)
                .placeholder(R.drawable.cat)
                .error(R.drawable.cat)
                //.animateLoad(spinAnimation)
                //.animateIn(fadeInAnimation)
                .load(data.get(i).url);

        return iv;
    }

    public void addData(List<Gif> newData){
        data.addAll(newData);
        notifyDataSetChanged();
    }

}
