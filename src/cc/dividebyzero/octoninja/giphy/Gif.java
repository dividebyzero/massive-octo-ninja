package cc.dividebyzero.octoninja.giphy;

/**
 * Created with IntelliJ IDEA.
 * User: zero
 * Date: 10/26/13
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Gif {

    public int width;
    public int height;
    public String url;
    public int frames;


    @Override
    public String toString() {
        StringBuffer b= new StringBuffer("Gif{");
        b.append("width=");
        b.append(width);
        b.append(",height=");
        b.append(height);
        b.append(",url=");
        b.append(url);
        b.append(",frames=");
        b.append(frames);
        b.append("}");
        return b.toString();
    }
}
