package sg.edu.np.mad.prac6;

import android.os.Parcelable;
import java.io.Serializable;

public class User implements Serializable{
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(String n, String d, int idd, boolean flw){
        name = n;
        description = d;
        id = idd;
        followed = flw;
    }
}
