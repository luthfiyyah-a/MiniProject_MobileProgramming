package com.ppb.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class KontakAdapter extends ArrayAdapter<Kontak> {
    public KontakAdapter(Context context, int resource, List<Kontak> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Kontak dtKontak = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView tNama = convertView.findViewById(R.id.tNama);
        TextView tNoHp = convertView.findViewById(R.id.tnoHp);

        tNama.setText(dtKontak.getNama());
        tNoHp.setText(dtKontak.getNoHp());

        return convertView;
    }
}

