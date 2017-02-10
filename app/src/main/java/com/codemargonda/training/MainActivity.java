package com.codemargonda.training;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    RecyclerView rvList;
    AdapterLokasi adapterLokasi;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Lokasi> list  = new ArrayList<Lokasi>();
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] items = {
                "3101011001-Pulau Panggang",
                "3101011002-Pulau Kelapa",
                "3101011003-Pulau Untung Jawa",
                "3101021001-Pulau Harapan",
                "3101021002-Pulau Tidung",
                "3101021003-Pulau Pari",
                "3171011001-Gambir",
                "3171011002-Cideng",
                "3171011003-Petojo Utara",
                "3171011004-Petojo Selatan",
                "3171011005-Kebon Kelapa",
                "3171011006-Duri Pulo",
                "3171021001-Pasar Baru",
                "3171021002-Karang Anyar",
                "3171021003-Kartini",
                "3171021004-Gunung Sahari Utara",
                "3171021005-Mangga Dua Selatan",
                "3171031001-Kemayoran",
                "3171031002-Kebon Kosong",
                "3171031003-Harapan Mulya",
                "3171031004-Serdang",
                "3171031005-Gunung Sahari Selatan",
                "3171031006-Cempaka Baru",
                "3171031007-Sumur Batu",
                "3171031008-Utan Panjang"
        };

        rvList = (RecyclerView) findViewById(R.id.rvList);
        layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);

        adapterLokasi = new AdapterLokasi(list, this);
        rvList.setAdapter(adapterLokasi);

        for(int i=0;i<items.length;i++){
            Lokasi lokasi = new Lokasi(items[i]);
            list.add(lokasi);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem  = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Lokasi> newList = new ArrayList<>();
        for(Lokasi lokasi : list) {
            String location = lokasi.getTempat().toLowerCase();
            if(location.contains(newText))
                newList.add(lokasi);
        }
        adapterLokasi.setFilter(newList);
        return true;
    }
}
