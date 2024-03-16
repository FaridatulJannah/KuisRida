package com.example.kuisrida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Locale;

public class BonbelanjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonbelanja);

        TextView tvNama = findViewById(R.id.tvNama);
        TextView tvKode = findViewById(R.id.tvKode);
        TextView tvNamaBarang = findViewById(R.id.tvNamabrg);
        TextView tvHargaBarang = findViewById(R.id.tvHargabrg);
        TextView tvJumlah = findViewById(R.id.tvJumlah);
        TextView tvDiskon = findViewById(R.id.tvDiskon);
        TextView tvDiskonMember = findViewById(R.id.tvDiskonMember);
        TextView tvTotalPrice = findViewById(R.id.tvJmlhBayar);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("Nama");
        String kodebarang = intent.getStringExtra("Kodebarang");
        String namabarang = intent.getStringExtra("Nama Barang");
        int hargaBarang = intent.getIntExtra("Harga Barang", 0);
        int jumlah = intent.getIntExtra("Jumlah", 0);
        int diskon = intent.getIntExtra("Diskon", 0);
        double diskonMember = intent.getDoubleExtra("Diskon Member", 0);
        int hargaBayar = intent.getIntExtra("Harga Bayar", 0);

        tvNama.setText("Nama pembeli : " + nama );
        tvKode.setText("Kode barang : " + kodebarang);
        tvNamaBarang.setText("Nama Barang : " +namabarang);
        tvHargaBarang.setText("Harga Barang Rp. : " + hargaBarang);
        tvJumlah.setText("Jumlah Barang : " + jumlah);
        tvDiskon.setText("Diskon Pembelian di atas 10 juta Rp. : " + diskon);
        tvDiskonMember.setText("Diskon Membership Rp. : " + diskonMember );
        tvTotalPrice.setText("Total Harga Rp. : " + hargaBayar);

        Button btnshare = findViewById(R.id.btnshare);

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent();
                String text = "Halo " + nama +
                        "\nIni BON belanja kamu" +
                        "\nKode barang: " + kodebarang +
                        "\nNama barang: Rp. " + namabarang +
                        "\nHarga barang: Rp. " + hargaBarang +
                        "\nJumlah barang: " + jumlah +
                        "\nDiskon: Rp. " + diskon +
                        "\nDiskon membership: Rp. " + diskonMember +
                        "\nTotal Harga: Rp. " + hargaBayar;

                share.setAction(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, text);

                startActivity(Intent.createChooser(share,"Bagikan dengan"));
            }
        });
    }
}