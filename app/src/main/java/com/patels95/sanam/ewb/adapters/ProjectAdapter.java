package com.patels95.sanam.ewb.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.patels95.sanam.ewb.R;
import com.patels95.sanam.ewb.model.ParseConstants;
import com.patels95.sanam.ewb.model.Project;
import com.patels95.sanam.ewb.ui.ProjectsActivity;

import org.w3c.dom.Text;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    public static final String PROJECT_TITLE = "PROJECT_TITLE";

    private Project[] mProjectCards;
    private Context mContext;

    public ProjectAdapter(Context context, Project[] projectCards){
        mContext = context;
        mProjectCards = projectCards;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_card, parent, false);
        ProjectViewHolder viewHolder = new ProjectViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.bindProject(mProjectCards[position]);
    }

    @Override
    public int getItemCount() {
        return mProjectCards.length;
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public TextView mDescription;
        public ImageView mImage;
        public TextView mParseId;


        public ProjectViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.projectTitle);
            mDescription = (TextView) itemView.findViewById(R.id.projectDescription);
            mImage = (ImageView) itemView.findViewById(R.id.projectImage);
            mParseId = (TextView) itemView.findViewById(R.id.parseId);

            itemView.setOnClickListener(this);
        }

        public void bindProject(Project projectCard) {
            String uri = projectCard.getImageUri();
            int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());
            Drawable drawable = mContext.getResources().getDrawable(imageResource);

            mTitle.setText(projectCard.getTitle());
            mDescription.setText(projectCard.getDescription());
            mImage.setImageDrawable(drawable);
            mParseId.setText(projectCard.getParseId());
        }

        @Override
        public void onClick(View v) {
            TextView title = (TextView) v.findViewById(R.id.projectTitle);
            TextView parseId = (TextView) v.findViewById(R.id.parseId);
            Intent intent = new Intent(mContext, ProjectsActivity.class);
            intent.putExtra(ParseConstants.PROJECT_TITLE, title.getText().toString());
            intent.putExtra(ParseConstants.PARSE_ID, parseId.getText().toString());
            mContext.startActivity(intent);
        }
    }

}
