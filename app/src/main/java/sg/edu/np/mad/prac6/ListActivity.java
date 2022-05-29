package sg.edu.np.mad.prac6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Context;

import java.util.Random;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    //public static ArrayList<User>  userList = initRandomUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /*ImageView imgv = findViewById(R.id.listicon);
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert = alert();
                alert.show();
            }
        });*/
        DBHandler db = new DBHandler(this);
        ArrayList<User> userList = db.getUsers();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter madpt = new UserAdapter(userList);
        LinearLayoutManager mlm = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(mlm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(madpt);
    }

    /*public static AlertDialog alert(Integer position, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Profile");
        builder.setMessage(userList.get(position).name);
        builder.setCancelable(true);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Random rand = new Random();
                Integer genInt = Math.abs(rand.nextInt());
                Intent act = new Intent(context,MainActivity.class);
                act.putExtra("position",position);
                context.startActivity(act);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //cancel action
            }
        });
        AlertDialog ad = builder.create();
        return ad;
    }

    public static ArrayList<User> initRandomUser(){
        ArrayList<User> userList = new ArrayList<User>();

        while (userList.size() <20) {
            Random rand = new Random();
            String randName = "Name" + Integer.toString(rand.nextInt());
            String randDesc = "Description "+ Integer.toString(Math.abs(rand.nextInt()));
            Integer randId;
            Boolean randFollowed = rand.nextBoolean();

            while (true){
                Boolean repeatId = false;
                randId = Math.abs(rand.nextInt());
                for(User i : userList){
                    if(i.id == randId){
                        repeatId = true;
                    }
                }
                if(repeatId == false){
                    break;
                }
            }
            User usr = new User(randName,randDesc,randId,randFollowed);
            userList.add(usr);
        }
        return userList;
    }*/
}
