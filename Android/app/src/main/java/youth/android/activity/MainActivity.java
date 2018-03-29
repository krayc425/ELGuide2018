package youth.android.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import youth.android.R;
import youth.android.adapter.AdapterQuestion;
import youth.android.data.ApiGetQuestions;
import youth.android.model.Question;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    /**
     * 线程结果处理器
     */
    private Handler mFetcherHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                if (msg.obj instanceof List) {
                    List<Question> data = (List<Question>) msg.obj;
                    // 更新数据
                    mRecyclerView.setAdapter(new AdapterQuestion(data));
                }
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.data_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //开启数据获取线程
        new DataFetcherTask().execute();
    }

    /**
     * 数据获取线程
     */
    class DataFetcherTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
                List<Question> data = ApiGetQuestions.getApi().getQuestions();
                // 发送结果完成请求
                mFetcherHandler.obtainMessage(1, data).sendToTarget();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
