package youth.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 * Created by heleninsa on 2018/3/28.
 *
 * @author heleninsa
 */

public class Question implements Parcelable{

    private String title;
    private String content;
    private Date time;
    private String choice[];
    private int answer;

    public Question() {}

    /**
     * 反序列化，保证反序列和序列化的顺序相同
     * @param in
     */
    private Question(Parcel in) {
        title = in.readString();
        content = in.readString();
        time = new Date(in.readLong());
        choice = in.createStringArray();
        answer = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public String[] getChoice() {
        return choice;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 内容描述，可以不管
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 序列化
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeLong(time.getTime());
        dest.writeStringArray(choice);
        dest.writeInt(answer);
    }
}
