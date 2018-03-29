package youth.android.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import youth.android.model.Question;

/**
 * Created by heleninsa on 2018/3/28.
 *
 * @author heleninsa
 */

public class ApiGetQuestions {

    private static ApiGetQuestions mApi;
    private List<Question> mQuestions;

    public static ApiGetQuestions getApi() {
        if (mApi == null) {
            mApi = new ApiGetQuestions();
        }
        return mApi;
    }

    public List<Question> getQuestions() {
        mQuestions = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Question q1 = new Question();
        q1.setTitle("三次函数练习题");
        q1.setContent("已知三次函数 fx=ax^3-x^2+x 在(0, +∞)存在极大值点，则x的范围是:");
        q1.setChoice(new String[]{"(0, 1/3)", "(0, 1/3]", "(-∞, 1/3)", "(-∞, 0)U(0,1/3)"});
        q1.setAnswer(2);
        calendar.set(2010, 0, 15);
        q1.setTime(calendar.getTime());
        mQuestions.add(q1);

        Question q2 = new Question();
        q2.setTitle("三角函数练习题");
        q2.setContent("a为锐角是 sin a > 0 的()");
        q2.setChoice(new String[]{"充分非必要条件", "必要非充分条件", "非充分非必要条件", "充要条件"});
        q2.setAnswer(0);
        calendar.set(2012, 9, 15);
        q2.setTime(calendar.getTime());
        mQuestions.add(q2);

        Question q3 = new Question();
        q3.setTitle("长句子滑动测试");
        q3.setContent("Pollution is ______bad ______many rivers are full of chemicals and kill sea creatures.Pollution is bad rivers are full of chemicals and kill sea creatures.Pollution is bad many rivers are full of chemicals and kill sea creatures.Pollution is bad rivers are full of chemicals and kill sea creatures.");
        q3.setChoice(new String[]{"so ; that", "such ; that", "too ; and that", "quite ;which"});
        q3.setAnswer(0);
        calendar.set(2015, 7, 12);
        q3.setTime(calendar.getTime());
        mQuestions.add(q3);

        Question q4 = new Question();
        q4.setTitle("三次函数练习题");
        q4.setContent("已知三次函数 fx=ax^3-x^2+x 在(0, +∞)存在极大值点，则x的范围是:");
        q4.setChoice(new String[]{"(0, 1/3)", "(0, 1/3]", "(-∞, 1/3)", "(-∞, 0)U(0,1/3)"});
        q4.setAnswer(2);
        calendar.set(2010, 0, 15);
        q4.setTime(calendar.getTime());
        mQuestions.add(q4);

        Question q5 = new Question();
        q5.setTitle("三角函数练习题");
        q5.setContent("a为锐角是 sin a > 0 的()");
        q5.setChoice(new String[]{"充分非必要条件", "必要非充分条件", "非充分非必要条件", "充要条件"});
        q5.setAnswer(0);
        calendar.set(2012, 9, 15);
        q5.setTime(calendar.getTime());
        mQuestions.add(q5);

        Question q6 = new Question();
        q6.setTitle("英语单选测试A");
        q6.setContent("Pollution is ______bad ______many rivers are full of chemicals and kill sea creatures.");
        q6.setChoice(new String[]{"so ; that", "such ; that", "too ; and that", "quite ;which"});
        q6.setAnswer(0);
        calendar.set(2015, 7, 12);
        q6.setTime(calendar.getTime());
        mQuestions.add(q6);

        Question q7 = new Question();
        q7.setTitle("三次函数练习题");
        q7.setContent("已知三次函数 fx=ax^3-x^2+x 在(0, +∞)存在极大值点，则x的范围是:");
        q7.setChoice(new String[]{"(0, 1/3)", "(0, 1/3]", "(-∞, 1/3)", "(-∞, 0)U(0,1/3)"});
        q7.setAnswer(2);
        calendar.set(2010, 0, 15);
        q7.setTime(calendar.getTime());
        mQuestions.add(q7);

        Question q8 = new Question();
        q8.setTitle("三角函数练习题");
        q8.setContent("a为锐角是 sin a > 0 的()");
        q8.setChoice(new String[]{"充分非必要条件", "必要非充分条件", "非充分非必要条件", "充要条件"});
        q8.setAnswer(0);
        calendar.set(2012, 9, 15);
        q8.setTime(calendar.getTime());
        mQuestions.add(q8);

        Question q9 = new Question();
        q9.setTitle("英语单选测试A");
        q9.setContent("Pollution is ______bad ______many rivers are full of chemicals and kill sea creatures.");
        q9.setChoice(new String[]{"so ; that", "such ; that", "too ; and that", "quite ;which"});
        q9.setAnswer(0);
        calendar.set(2015, 7, 12);
        q9.setTime(calendar.getTime());
        mQuestions.add(q9);
        return mQuestions;
    }

}
