package sg.edu.np.mad.prac6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    ArrayList<User> data;
    public UserAdapter(ArrayList<User> input){
        data=input;
    }

    @Override
    public int getItemViewType(int position) {
        Character lastDigit = ((data.get(position).name).charAt((data.get(position).name).length() - 1)); //get last character
        if (lastDigit == '7'){
            return 1; //use the big layout
        }
        else{
            return 0; //use normal layout
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null; //= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        if(viewType == 1){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_rowb,parent,false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        }
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        String uName = data.get(position).name;
        String uDesc = data.get(position).description;
        holder.uName.setText(uName);
        holder.uDesc.setText(uDesc);
        holder.uPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.uPic.getContext();
                //AlertDialog alert = ListActivity.alert(holder.getAdapterPosition(), context);
                Integer uPos = holder.getAdapterPosition();

                DBHandler db = new DBHandler(context);
                ArrayList<User> userList = db.getUsers();
                User user = userList.get(uPos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}