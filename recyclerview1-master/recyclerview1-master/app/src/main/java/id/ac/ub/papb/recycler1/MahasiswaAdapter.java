package id.ac.ub.papb.recycler1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    private Context context;
    private ArrayList<Mahasiswa> data;

    public MahasiswaAdapter(Context context, ArrayList<Mahasiswa> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Mahasiswa mahasiswa = data.get(position);


        holder.txtNama.setText(mahasiswa.getName());
        holder.txtNim.setText(mahasiswa.getNim());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }


    public void addItem(Mahasiswa newMahasiswa) {

        data.add(newMahasiswa);

        notifyItemInserted(data.size() - 1);
    }


    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama, txtNim;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);


            txtNama = itemView.findViewById(R.id.tvNama);
            txtNim = itemView.findViewById(R.id.tvNim);
        }
    }
}
