package id.ac.umn.norbertus_37417;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class AdapterLibrary extends RecyclerView.Adapter<AdapterLibrary.ItemLibraryViewHolder> {

    private final Context context;
    private final LinkedList<Library> listLibrary;
    private final LibraryItemClickListener listener;

    public AdapterLibrary(Context context, LinkedList<Library> listLibrary, LibraryItemClickListener listener){
        this.context = context;
        this.listLibrary = listLibrary;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemLibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_library, parent, false);
        return new ItemLibraryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLibraryViewHolder holder, int position) {
//        Log.d("heroism", String.valueOf(position));
        holder.title.setText(listLibrary.get(position).getTitle());
        holder.type.setText(listLibrary.get(position).getType());
        holder.delete.setOnClickListener(v->{
            Log.d("heroism", "Set Click");
            listener.onDeleteLibrary(position);
        });
    }

    @Override
    public int getItemCount() {
        return listLibrary.size();
    }

    class ItemLibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, type;
        ImageView sound, delete;
        AdapterLibrary adapter;
        public ItemLibraryViewHolder(@NonNull View itemView, AdapterLibrary adapter) {
            super(itemView);
            this.title = itemView.findViewById(R.id.item_title);
            this.type = itemView.findViewById(R.id.item_type);
            this.sound = itemView.findViewById(R.id.item_sound);
            this.delete = itemView.findViewById(R.id.item_delete);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public void onClick(View view) {
            Log.d("heroism", "---------------Go to Detail Activity--------------------");
            listener.goToDetailLibrary(listLibrary.get(getAdapterPosition()));
//            Log.d("jo", getAdapterPosition())
//            Intent intent = new Intent(context.getApplicationContext(), LibraryDetailActivity.class);
//            view.setOnClickListener( v -> {
//                listener.goToDetailLibrary(listLibrary.get(getAdapterPosition()));
//            });
//            delete.setOnClickListener(v -> {
//                Log.d("heroism", "Delete");
//                listener.onDeleteLibrary(getAdapterPosition());
//            });
//            Log.d("heroism", String.valueOf());

//            if(delete.callOnClick())
//                Log.d("heroism", "Di Click");
//            if(delete.isPressed())
//                listener.onDeleteLibrary(getAdapterPosition());
//            if(view.isPressed())
//                listener.goToDetailLibrary(listLibrary.get(getAdapterPosition()));
//            delete.setOnTouchListener((view1, motionEvent) -> {
//                listener.onDeleteLibrary(getAdapterPosition());
//                return false;
//            });
//            view.setOnTouchListener((view12, motionEvent) -> {
//                listener.goToDetailLibrary(listLibrary.get(getAdapterPosition()));
//                return false;
//            });
        }
    }
}
