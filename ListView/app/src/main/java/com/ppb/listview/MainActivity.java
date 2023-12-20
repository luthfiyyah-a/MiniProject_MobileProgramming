package com.ppb.listview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ImageView add;
    private KontakAdapter kAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        add = findViewById(R.id.add);
        add.setOnClickListener(operasi);

        ArrayList<Kontak> listKontak = new ArrayList<>();
        kAdapter = new KontakAdapter(this, 0, listKontak);
        lv.setAdapter(kAdapter);
    }

    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.add) {
                tambah_data();
            }
        }
    };

    private void add_item(String nm, String hp) {
        Kontak newKontak = new Kontak(nm, hp);
        kAdapter.add(newKontak);
    }

    private void tambah_data() {
        AlertDialog.Builder buat = new AlertDialog.Builder(this);
        buat.setTitle("Add Kontak");

        View vAdd = LayoutInflater.from(this).inflate(R.layout.add_kontak, null);
        final EditText nm = vAdd.findViewById(R.id.nm);
        final EditText hp = vAdd.findViewById(R.id.hp);

        buat.setView(vAdd);

        buat.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                add_item(nm.getText().toString(), hp.getText().toString());
                Toast.makeText(getBaseContext(), "Data Tersimpan", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        buat.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        buat.show();
    }
}
