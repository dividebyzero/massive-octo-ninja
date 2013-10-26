package cc.dividebyzero.octoninja.giphy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zero
 * Date: 10/26/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchParams {

    public List<String> searchTerms = new ArrayList<String>();

    public int page = 0;

    public int limit = 25;

    public int getOffset(){
        return limit * page;
    }
}
