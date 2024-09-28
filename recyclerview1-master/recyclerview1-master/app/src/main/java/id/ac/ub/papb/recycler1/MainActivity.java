package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> dataMahasiswa;

    private EditText inputName, inputNim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        inputName = findViewById(R.id.input_name);
        inputNim = findViewById(R.id.input_nim);

        dataMahasiswa = new ArrayList<>();
        dataMahasiswa.add(new Mahasiswa("Muhamad Irkham Maulana", "225150601111009"));  // Data awal
        dataMahasiswa.add(new Mahasiswa("Mirna", "225150601111010"));

        adapter = new MahasiswaAdapter(this, dataMahasiswa);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onAddButtonClick(View view) {
        String name = inputName.getText().toString().trim();
        String nim = inputNim.getText().toString().trim();

        if (name.isEmpty() || nim.isEmpty()) {
            Toast.makeText(this, "Mohon isi nama dan NIM", Toast.LENGTH_SHORT).show();
            return;
        }

        Mahasiswa newMahasiswa = new Mahasiswa(name, nim);
        adapter.addItem(newMahasiswa);

        inputName.setText("");
        inputNim.setText("");

        Toast.makeText(this, "Mahasiswa ditambahkan", Toast.LENGTH_SHORT).show();
    }
}
