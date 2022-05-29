package sg.edu.np.mad.prac6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.acl.Group;

public class MessageGroup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        Button g1b, g2b;
        g1b = findViewById(R.id.g1b);
        g2b = findViewById(R.id.g2b);

        g1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag(new Group1());
            }
        });

        g2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag(new Group2());
            }
        });
    }

    public void frag(Fragment frag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,frag);
        ft.commit();
    }

}