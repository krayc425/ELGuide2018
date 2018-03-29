package youth.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;

import youth.android.R;
import youth.android.model.Question;

/**
 * Created by heleninsa on 2018/3/28.
 *
 * @author heleninsa
 */
public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{

    private static String KEY_QUESTION = "question";
    private Question mQuestion;
    private SparseIntArray choiceIndex;
    private TextView mResult;

    public static void startActivity(Question question, Context context) {
        Intent intent = new Intent(context, QuestionActivity.class);
        // 数据传入
        intent.putExtra(KEY_QUESTION, question);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        //
        mQuestion = getIntent().getParcelableExtra(KEY_QUESTION);
        initUi();
    }

    private void initUi() {
        mResult = findViewById(R.id.activity_question_result);
        setTitle(mQuestion.getTitle());
        ((TextView)findViewById(R.id.activity_question_content)).setText(mQuestion.getContent());
        ((TextView)findViewById(R.id.activity_question_time)).setText(mQuestion.getTime().toLocaleString());

        //todo： 可以使用动态生成插入
        Button op1 = findViewById(R.id.activity_question_op1);
        op1.setText("A: " + mQuestion.getChoice()[0]);
        op1.setOnClickListener(this);
        Button op2 = findViewById(R.id.activity_question_op2);
        op2.setText("B: " + mQuestion.getChoice()[1]);
        op2.setOnClickListener(this);
        Button op3 = findViewById(R.id.activity_question_op3);
        op3.setText("C: " + mQuestion.getChoice()[2]);
        op3.setOnClickListener(this);
        Button op4 = findViewById(R.id.activity_question_op4);
        op4.setText("D: " + mQuestion.getChoice()[3]);
        op4.setOnClickListener(this);

        //存储View ID。存储View本身也可以
        choiceIndex = new SparseIntArray();
        choiceIndex.put(R.id.activity_question_op1, 0);
        choiceIndex.put(R.id.activity_question_op2, 1);
        choiceIndex.put(R.id.activity_question_op3, 2);
        choiceIndex.put(R.id.activity_question_op4, 3);
    }

    @Override
    public void onClick(View v) {
        int answer = choiceIndex.get(v.getId());
        if (answer == mQuestion.getAnswer()) {
            mResult.setText("回答正确！");
        } else {
            mResult.setText("回答错误！");
        }
    }

}
