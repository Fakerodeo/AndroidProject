package com.example.logindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;
    private FirebaseAuth firebaseAuth;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();

        createExampleList();
        buildRecyclerView();
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.acm, "PASC", "PICT ACM Student Chapter"));
        mExampleList.add(new ExampleItem(R.drawable.artcircle, "Art Circle", "PICT Art Circle"));
        mExampleList.add(new ExampleItem(R.drawable.csi, "CSI", "PICT CSI Student Branch"));
        mExampleList.add(new ExampleItem(R.drawable.ieee, "PISB", "PICT IEEE Student Branch"));
        mExampleList.add(new ExampleItem(R.drawable.mun, "PICT MUN", "PICT Model United Nations"));
        mExampleList.add(new ExampleItem(R.drawable.tedx, "TedX PICT", "PICT TedX Organization"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(SecondActivity.this, "this is PASC", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SecondActivity.this, AcmActivity.class));
                        break;
                    case 1:
                        Toast.makeText(SecondActivity.this, "this is Art Circle", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SecondActivity.this, ArtCircleActivity.class));
                        break;
                    case 2:
                        Toast.makeText(SecondActivity.this, "this is CSI", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SecondActivity.this, CsiActivity.class));
                        break;
                    case 3:
                        Toast.makeText(SecondActivity.this, "this is PISB", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SecondActivity.this, IeeeActivity.class));
                        break;
                    case 4:
                        Toast.makeText(SecondActivity.this, "this is MUN", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SecondActivity.this, MunActivity.class));
                        break;
                    case 5:
                        Toast.makeText(SecondActivity.this, "this is TedX", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SecondActivity.this, TedXActivity.class));
                        break;
                }
            }
        });
    }

    private void Logout() {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logoutMenu: {
                Logout();
                break;
            }
            case R.id.profileMenu: {
                startActivity(new Intent(SecondActivity.this, ProfileActivity.class));
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
