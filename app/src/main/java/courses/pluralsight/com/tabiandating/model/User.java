package courses.pluralsight.com.tabiandating.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String profile_image;
    private String name;
    private String gender;
    private String interested_in;
    private String status;

    public User() {
    }

    public User(String profile_image, String name, String gender, String interested_in, String status) {
        this.profile_image = profile_image;
        this.name = name;
        this.gender = gender;
        this.interested_in = interested_in;
        this.status = status;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterested_in() {
        return interested_in;
    }

    public void setInterested_in(String interested_in) {
        this.interested_in = interested_in;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.profile_image);
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeString(this.interested_in);
        dest.writeString(this.status);
    }

    protected User(Parcel in) {
        this.profile_image = in.readString();
        this.name = in.readString();
        this.gender = in.readString();
        this.interested_in = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
