package com.example.projetozeradengue.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.example.projetozeradengue.core.AppUtil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Denounces implements Parcelable{
    private String a_Street;
    private String a_number;
    private String a_district;
    private String a_complement;
    private String a_city;
    private String a_coord;
    private String note;
    private String a_state;
    private String a_cep;
    private String id;
    private String userId;



  //CONSTRUTOR
    public Denounces(@Nullable String userId, String cep, String street, String number, @Nullable String complement, String district, String city, String state, String note ) {
        this.userId = userId;
        this.a_cep = cep;
        this.a_Street = street;
        this.a_number = number;
        this.a_complement = complement;
        this.a_district = district;
        this.a_city = city;
        this.a_state = state;
        this.note = note;
    }

    public Denounces() {

    }


    //GETTERES E SETTERES
    public String getA_state() {
        return a_state;
    }

    public void setA_state(String a_state) {
        this.a_state = a_state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCep() {
        return a_cep;
    }

    public void setCep(String cep) {
        this.a_cep = cep;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(@Nullable String userId) {
        this.userId = userId;
    }

    public String getA_Street() {
        return a_Street;
    }

    public void setA_Street(String a_Street) {
        this.a_Street = a_Street;
    }

    public String getA_number() {
        return a_number;
    }

    public void setA_number(String a_number) {
        this.a_number = a_number;
    }

    public String getA_district() {
        return a_district;
    }

    public void setA_district(String a_district) {
        this.a_district = a_district;
    }

    public String getA_complement() {
        return a_complement;
    }

    public void setA_complement(String a_complement) {
        this.a_complement = a_complement;
    }

    public String getA_city() {
        return a_city;
    }

    public void setA_city(String a_city) {
        this.a_city = a_city;
    }

    public String getA_coord() {
        return a_coord;
    }

    public void setA_coord(String a_coord) {
        this.a_coord = a_coord;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    //Database Web
    public void save(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child(AppUtil.REALTIME_DATABASE_DENOUNCE).child(getId()).setValue(this);

    }


    //  IMPLEMENTAÇÃO DE PARCELABLE

    //Construtor usado pelo android para criar a nossa classe, neste caso User
    protected Denounces(Parcel in) {
        a_Street = in.readString();
        a_number = in.readString();
        a_district = in.readString();
        a_city = in.readString();
        note = in.readString();
        a_complement = in.readString();
        a_state = in.readString();
        a_cep = in.readString();
        id = in.readString();
        userId = in.readString();


    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            throw new UnsupportedOperationException();
            //return new User[size];
        }
    };


    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString( a_Street);
        dest.writeString(a_number);
        dest.writeString(a_district);
        dest.writeString(a_city);
        dest.writeString(note);
        dest.writeString(a_complement);
        dest.writeString(a_state);
        dest.writeString(userId);

    }




}
