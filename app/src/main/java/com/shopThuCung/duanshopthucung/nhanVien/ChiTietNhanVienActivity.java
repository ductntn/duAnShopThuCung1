package com.shopThuCung.duanshopthucung.nhanVien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shopThuCung.duanshopthucung.Customer.ChiTietCustomerActivity;
import com.shopThuCung.duanshopthucung.DataBase.NhanVienDAO;
import com.shopThuCung.duanshopthucung.MainActivity;
import com.shopThuCung.duanshopthucung.R;

public class ChiTietNhanVienActivity extends AppCompatActivity {

    NhanVienDAO nhanVienDAO;
    String idNV, tenNV, chucVuNV, sdtNV, diaChiNV, ngaySinhNV;
    TextView tvIDNV, tvTenNV, tvChucVuNV, tvSdtNV, tvDiaChiNV, tvNgaySinhNV;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nhan_vien);

        nhanVienDAO = new NhanVienDAO(this);
        init();

        Toolbar
                toolbar = findViewById(R.id.toolbar_post_chiTiet);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent i = getIntent();
        idNV = i.getStringExtra("IdNV");
        tenNV = i.getStringExtra("TenNV");
        chucVuNV = i.getStringExtra("ChucVuNV");
        sdtNV = i.getStringExtra("SdtNV");
        diaChiNV = i.getStringExtra("DiaChiNV");
        ngaySinhNV = i.getStringExtra("NgaySinhNV");

        tvIDNV.setText( idNV);
        tvTenNV.setText(tenNV);
        tvChucVuNV.setText(chucVuNV);
        tvSdtNV.setText( sdtNV);
        tvDiaChiNV.setText( diaChiNV);
        tvNgaySinhNV.setText( ngaySinhNV);
    }

    void init(){
        tvIDNV = findViewById(R.id.nhanVien_detail_tvIDNhanVien);
        tvTenNV = findViewById(R.id.nhanVien_detail_tvTenNhanVien);
        tvChucVuNV = findViewById(R.id.nhanVien_detail_tvChucVuNhanVien);
        tvSdtNV = findViewById(R.id.nhanVien_detail_tvSDTNhanVien);
        tvDiaChiNV = findViewById(R.id.nhanVien_detail_tvDiaChiNhanVien);
        tvNgaySinhNV = findViewById(R.id.nhanVien_detail_tvNgaySinhNhanVien);
    }

    public void moveEditNV(View view) {
        Intent intent = new Intent(ChiTietNhanVienActivity.this,EditNhanVienActivity.class);
        intent.putExtra("IdNV",tvIDNV.getText());
        intent.putExtra("TenNV",tvTenNV.getText());
        intent.putExtra("ChucVuNV",tvChucVuNV.getText());
        intent.putExtra("SdtNV",tvSdtNV.getText());
        intent.putExtra("DiaChiNV",tvDiaChiNV.getText());
        intent.putExtra("NgaySinhNV",tvNgaySinhNV.getText());
        startActivity(intent);
    }

    public void DeleteNV(View view) {
        if(nhanVienDAO.delNV(tvIDNV.getText().toString())<0)
        {
            Toast.makeText(this, "Xoa khong thanh cong", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
        }

        startActivity(new Intent(ChiTietNhanVienActivity.this, MainActivity.class));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.kocogi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent1 = new Intent(ChiTietNhanVienActivity.this, ListNhanVienActivity.class);
                startActivity(intent1);;
                break;


        }
        return true;
    }
}