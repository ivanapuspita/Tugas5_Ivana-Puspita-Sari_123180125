package com.example.tugas5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas5.R;
import com.example.tugas5.database.entitas.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewAdapter>{
    private List<User> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog {
        void onClick(int position);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.fullName.setText(list.get(position).fullName);
        holder.noHp.setText(list.get(position).noHp);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  ViewAdapter extends RecyclerView.ViewHolder{
        TextView fullName, noHp;

        public ViewAdapter(@NonNull View itemView) {

            super(itemView);
            fullName = itemView.findViewById(R.id.full_name);
            noHp = itemView.findViewById(R.id.no_hp);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dialog !=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }

}
