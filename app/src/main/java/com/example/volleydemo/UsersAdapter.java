package com.example.volleydemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.usersDataHolder> {


    List<Users> usersList;
    Context context;

    public UsersAdapter(List<Users> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public usersDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.rv_usersinfo, null );
        return new usersDataHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull usersDataHolder holder, int position) {
        final Users usersData = usersList.get( position );
        holder.userId.setText( usersData.getId());
        holder.FirstName.setText( usersData.getFirstName() );
        holder.LastName.setText( usersData.getLastName() );
        holder.Email.setText( usersData.getEmail() );
        Picasso.get().load( usersData.getProfileImg()).into( holder.imageViewUser1 );


    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public class usersDataHolder extends RecyclerView.ViewHolder {
        TextView userId, FirstName, LastName, Email;
        ImageView imageViewUser1;

        public usersDataHolder(@NonNull View itemView) {
            super( itemView );
            userId = itemView.findViewById( R.id.textViewId );
            FirstName = itemView.findViewById( R.id.textViewFirstName );
            LastName = itemView.findViewById( R.id.textViewLastName );
            Email = itemView.findViewById( R.id.textViewEmail );
            imageViewUser1 = itemView.findViewById( R.id.imageViewUsers );
        }
    }
}
