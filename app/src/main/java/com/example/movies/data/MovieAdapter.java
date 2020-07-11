package com.example.movies.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//ШАГ 10
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    //ШАГ 13
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {

        this.context = context;
        this.movies = movies;
    }
    //ШАГ 13

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //ШАГ 15
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
        //ШАГ 15
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        //ШАГ 16
        Movie currentMovie = movies.get(position);

        String title = currentMovie.getTitle();
        String year = currentMovie.getYear();
        String posterUrl = currentMovie.getPosterUrl();

        holder.titleTextView.setText(title);
        holder.yearTextView.setText(year);
        Picasso.get().load(posterUrl).fit().centerInside().into(holder.posterImageView);
        //ШАГ 16
    }

    @Override
    public int getItemCount() {

        //ШАГ 14
        //return 0;
        return movies.size();
    }




    //ШАГ 9
    public class MovieViewHolder extends RecyclerView.ViewHolder {


        //ШАГ 11
        ImageView posterImageView;
        TextView titleTextView;
        TextView yearTextView;
        //ШАГ 11

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            //ШАГ 12
            posterImageView = itemView.findViewById(R.id.posterImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            //ШАГ 12
        }
    }
    //ШАГ 9
}
