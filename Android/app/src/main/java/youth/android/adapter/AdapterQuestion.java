package youth.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import youth.android.R;
import youth.android.activity.QuestionActivity;
import youth.android.model.Question;

/**
 * Created by heleninsa on 2018/3/28.
 *
 * @author heleninsa
 */

public class AdapterQuestion extends RecyclerView.Adapter<AdapterQuestion.HolderQuestion> {

    private List<Question> mData;

    public AdapterQuestion(List<Question> data) {
        mData = data;
    }

    @Override
    public HolderQuestion onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new HolderQuestion(v);
    }

    @Override
    public void onBindViewHolder(HolderQuestion holder, int position) {
        holder.bindQuestion(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HolderQuestion extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Question mQuestion;

        private TextView mTitle;
        private TextView mTime;

        HolderQuestion(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.item_title);
            mTime = itemView.findViewById(R.id.item_title_time);
            itemView.setOnClickListener(this);
        }

        void bindQuestion(@NotNull Question question) {
            mQuestion = question;
            mTitle.setText(question.getTitle());
            mTime.setText(question.getTime().toString());
        }

        @Override
        public void onClick(View v) {
            QuestionActivity.startActivity(mQuestion, v.getContext());
        }
    }

}
