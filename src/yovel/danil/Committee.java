package yovel.danil;

import yovel.danil.lecturers.Lecturer;

import java.io.Serializable;
import java.util.ArrayList;

public class Committee implements Serializable {
    private String name;
    private Lecturer chairman;
    private ArrayList<Lecturer> members;
    private final Degree committeeDegree;


    public Committee(String name, Lecturer chairman, ArrayList<Lecturer> members, Degree commititeesDegree) {
        this.name = name;
        this.chairman = chairman;
        this.members = members;
        this.committeeDegree = commititeesDegree;
    }

    public Committee(String name) {
        this(name, null, new ArrayList<>(), Degree.FIRST);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasChairman() {
        return this.chairman != null;
    }

    public Lecturer getChairman() {
        return this.chairman;
    }

    public boolean setChairman(Lecturer chairman) {
        if (chairman == null) return false;
        if (chairman.getDegree() == Degree.FIRST || chairman.getDegree() == Degree.SECOND) return false;
        if (isMember(chairman)) return false;
        this.chairman = chairman;
        return true;
    }

    public ArrayList<Lecturer> getMembers() {
        return members;
    }

    public boolean isMember(Lecturer lecturer) {
        return members.contains(lecturer);
    }

    public boolean addMember(Lecturer member) {
        if (member == null) return false;
        if (isMember(member)) return false;
        if (this.chairman == member) return false;
        if (member.getDegree() != committeeDegree) return false;

        members.add(member);
        member.addCommittee(this);
        return true;
    }

    public boolean removeMember(Lecturer member) {
        if (member == null) return false;
        if (!isMember(member)) return false;
        members.remove(member);
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Chairman:" + chairman.getName() + " Members Count: " + members.size();
    }

    public Committee copy() {
        return new Committee(name + "-new", chairman, members, committeeDegree);
    }
}
