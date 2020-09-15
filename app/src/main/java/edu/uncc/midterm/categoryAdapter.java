package edu.uncc.midterm;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;

import edu.uncc.midterm.utils.User;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder> {

    ArrayList<User> data;

    public categoryAdapter(ArrayList<User> data){
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        User user;
        TextView userName;
        TextView userState;
        TextView userAge;
        TextView userGroup;
        ImageView gender;
        String age;
        Context context;
        Drawable female;
        Drawable male;

        public void setUp(User user){
            age = String.valueOf(user.age) + " Years Old";
            this.user = user;
            this.userName.setText(user.name);
            this.userState.setText(user.state);
            this.userAge.setText(age);
            this.userGroup.setText(user.group);
            if(user.gender.equals("Female")){
                this.gender.setImageDrawable(female);
            } else if (user.gender.equals("Male")){
                this.gender.setImageDrawable(male);
            }
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            userName = itemView.findViewById(R.id.nameId);
            userState = itemView.findViewById(R.id.stateId);
            userAge = itemView.findViewById(R.id.ageId);
            userGroup = itemView.findViewById(R.id.groupId);
            gender = itemView.findViewById(R.id.genderIcon);
            female = context.getResources().getDrawable(R.drawable.avatar_female);
            male = context.getResources().getDrawable(R.drawable.avatar_male);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = data.get(position);
        holder.setUp(user);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
