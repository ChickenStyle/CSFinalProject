package yovel.danil;

public class Committee {
    private String name;
    private Lecturer chairman;
    private Lecturer[] members;
    private int membersCount;


    public Committee(String name, Lecturer chairman, Lecturer[] members, int membersCount) {
        this.name = name;
        this.chairman = chairman;
        this.members = members;
        this.membersCount = membersCount;
    }

    public Committee(String name) {
        this(name, null, new Lecturer[1], 0);
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
        this.chairman = chairman;
        return true;
    }

    public Lecturer[] getMembers() {
        return members;
    }

    public boolean isMember(Lecturer lecturer) {
        if (lecturer == null) return false;
        for (Lecturer member: members) {
            if (member.equals(lecturer)) return true;
        }
        return false;
    }

    public boolean addMember(Lecturer member) {
        if (member == null) return false;
        if (isMember(member)) return false;

        if (this.membersCount >= members.length) {
            Lecturer[] newMembers = new Lecturer[members.length * 2];
            for (int i = 0; i < this.members.length; i++) {
                newMembers[i] = this.members[i];
            }
            members = newMembers;
        }
        members[this.membersCount] = member;
        this.membersCount++;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
