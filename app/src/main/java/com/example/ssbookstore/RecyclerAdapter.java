package com.example.ssbookstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    static private ArrayList<Book> bookArrayList;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    public RecyclerAdapter(Context context, ArrayList<Book> bookArrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.bookArrayList = bookArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_bookitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Book book = bookArrayList.get(position);
        holder.bookName.setText(book.getName());
        holder.author.setText("by " + book.getAuthor());
        holder.date.setText(book.getDate()+"   >> ");

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UpdateBook.class);
                intent.putExtra("name", book.getName());
                intent.putExtra("author", book.getAuthor());
                intent.putExtra("date", book.getDate());
                intent.putExtra("description", book.getDescription());
                intent.putExtra("position", position);

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    public void deleteItem(int position){
        bookArrayList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookName, date, author;
        LinearLayout row;

        ViewHolder(View itemView){
            super(itemView);
            bookName = itemView.findViewById(R.id.bookName);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
            row = itemView.findViewById(R.id.row);
        }
    }

    Book getItem(int id){
        return bookArrayList.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
