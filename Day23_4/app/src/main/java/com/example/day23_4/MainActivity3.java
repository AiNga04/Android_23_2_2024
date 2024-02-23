package com.example.day23_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn;
    public void ShowPopupMenu(){
        btn = (Button) findViewById(R.id.btnButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity3.this, btn);
                popupMenu.getMenuInflater().inflate(R.menu.try1, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.menuSetting)
                            Toast.makeText(MainActivity3.this,"Bạn đang chọn Setting",Toast.LENGTH_LONG).show();
                        else if(item.getItemId() == R.id.menuShare)
                            btn.setText("Chia sẻ");
                        else if(item.getItemId() == R.id.menuLogout)
                            return true;
                        return false;
                    }
                });
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.menuSetting)
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        else if (item.getItemId() == R.id.menuShare)
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        else if (item.getItemId() == R.id.menuLogout)
            Toast.makeText(this, "Loout", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.try1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ShowPopupMenu();
    }
}