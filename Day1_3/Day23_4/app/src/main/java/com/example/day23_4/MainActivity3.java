package com.example.day23_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn, btn1, btn2, btn3;
    EditText editText1;
    Dialog dialog;
    private void DiaLog1(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(false);
        editText1 = (EditText) dialog.findViewById(R.id.editTextText);
        dialog.show();
    }

    void try2(){
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLog1();
            }
        });
    }

    public void XacNhanXoa(){
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity3.this);
                alert.setTitle("Thông báo");
                alert.setMessage("Bạn có muốn đăng xuất không");
                alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();
            }
        });
    }

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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.try1,menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuSetting)
            Toast.makeText(MainActivity3.this,"Setting",Toast.LENGTH_LONG).show();
        else if(item.getItemId() == R.id.menuShare)
            Toast.makeText(MainActivity3.this,"Share",Toast.LENGTH_LONG).show();
        else if(item.getItemId() == R.id.menuLogout)
            Toast.makeText(MainActivity3.this,"Logout",Toast.LENGTH_LONG).show();
            return super.onContextItemSelected(item);
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
        btn1 = (Button) findViewById(R.id.button);
        registerForContextMenu(btn1);
        btn2 = (Button) findViewById(R.id.button2);
        XacNhanXoa();
        btn3 = (Button) findViewById(R.id.button4);
        ShowPopupMenu();
        try2();
    }
}