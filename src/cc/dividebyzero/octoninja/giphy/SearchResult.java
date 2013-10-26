package cc.dividebyzero.octoninja.giphy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zero
 * Date: 10/26/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchResult {

    public SearchParams params;

    public List<Gif> data;

    @Override
    public String toString() {
        StringBuffer b = new StringBuffer("SearchResult{");
        b.append("params=");
        b.append( params != null ?params.toString():"null");
        b.append(",data=");
        b.append(data!=null ? data.toString(): "null");
        b.append("}");
        return b.toString();
    }
}
